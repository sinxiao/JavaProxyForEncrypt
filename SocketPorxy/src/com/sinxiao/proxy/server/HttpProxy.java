package com.sinxiao.proxy.server;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpProxy {
	static long threadCount = 0;
	int myTcpPort = 8080;
	private ServerSocket myServerSocket;
	private Thread myThread;

	public HttpProxy(int port) throws IOException {
		myTcpPort = port;
		myServerSocket = new ServerSocket(myTcpPort);
		myThread = new Thread(new Runnable() {
			public void run() {
				try {
					while (true)
						new HTTPSession(myServerSocket.accept());
				} catch (IOException ioe) {
				}
			}
		});
		myThread.setDaemon(true);
		myThread.start();
	}

	/**
	 * Stops the server.
	 */

	public void stop() {
		try {
			myServerSocket.close();
			myThread.join();
		} catch (IOException ioe) {
		} catch (InterruptedException e) {
		}
	}

	public class HTTPSession implements Runnable {
		private Socket mySocket;

		public HTTPSession(Socket s) {
			mySocket = s;
			Thread t = new Thread(this);
			t.setDaemon(true);
			t.start();
		}

		@Override
		public void run() {
			try {
				++threadCount;

				InputStream is = mySocket.getInputStream();
				if (is == null)
					return;
				final int bufsize = 8192;
				byte[] buf = new byte[bufsize];
				int splitbyte = 0;
				int rlen = 0;
				{
					int read = is.read(buf, 0, bufsize);
					while (read > 0) {
						rlen += read;
						splitbyte = findHeaderEnd(buf, rlen);
						if (splitbyte > 0)
							break;
						read = is.read(buf, rlen, bufsize - rlen);
					}
					ByteArrayInputStream hbis = new ByteArrayInputStream(buf,
							0, rlen);
					BufferedReader hin = new BufferedReader(
							new InputStreamReader(hbis));
					Host host = new Host();
					{
						String string;
						boolean flag = false;
						while ((string = hin.readLine()) != null) {
							if (string.toLowerCase().startsWith("host:")) {
								host.host = string;
								flag = true;
							}
							System.out.println(string);
						}
						if (!flag) {
							mySocket.getOutputStream().write(
									"error!".getBytes());
							mySocket.close();
							return;
						}
					}

					host.cal();
					System.out.println("address:[" + host.address + "]port:"
							+ host.port + "\n-------------------\n");

					try {
						pipe(buf, rlen, mySocket, mySocket.getInputStream(),
								mySocket.getOutputStream(), host);
					} catch (Exception e) {
						System.out.println("Run Exception!");
						e.printStackTrace();
					}
				}

			} catch (Exception e) {
			}
			System.out.println("threadcount:" + --threadCount);
		}

		/**
		 * finad http header
		 **/
		private int findHeaderEnd(final byte[] buf, int rlen) {
			int splitbyte = 0;
			while (splitbyte + 3 < rlen) {
				if (buf[splitbyte] == '\r' && buf[splitbyte + 1] == '\n'
						&& buf[splitbyte + 2] == '\r'
						&& buf[splitbyte + 3] == '\n')
					return splitbyte + 4;
				splitbyte++;
			}
			return 0;
		}

		void pipe(byte[] request, int requestLen, Socket client,
				InputStream clientIS, OutputStream clientOS, Host host)
				throws Exception {
			byte bytes[] = new byte[1024 * 32];
			Socket socket = new Socket(host.address, host.port);
			socket.setSoTimeout(3000);
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			try {
				do {
					os.write(request, 0, requestLen);
					int resultLen = 0;
					try {
						while ((resultLen = is.read(bytes)) != -1
								&& !mySocket.isClosed() && !socket.isClosed()) {
							clientOS.write(bytes, 0, resultLen);
						}
					} catch (Exception e) {
						System.out.println("target Socket exception:"
								+ e.toString());
					}

					System.out.println("proxy requset-connect broken,socket:"
							+ socket.hashCode());
				} while (!mySocket.isClosed()
						&& (requestLen = clientIS.read(request)) != -1);
			} catch (Exception e) {
				System.out.println("client Socket exception:" + e.toString());
			}

			System.out.println("end,socket:" + socket.hashCode());
			os.close();
			is.close();
			clientIS.close();
			clientOS.close();
			socket.close();
			mySocket.close();

		}

		// target Host info
		final class Host {
			public String address;
			public int port;
			public String host;

			public boolean cal() {
				if (host == null)
					return false;
				int start = host.indexOf(": ");
				if (start == -1)
					return false;
				int next = host.indexOf(':', start + 2);
				if (next == -1) {
					port = 80;
					address = host.substring(start + 2);
				} else {
					address = host.substring(start + 2, next);
					port = Integer.valueOf(host.substring(next + 1));
				}
				return true;
			}
		}
	}

	public static void main(String[] args) {
		try {
			new HttpProxy(6627);
		} catch (IOException ioe) {
			System.err.println("Couldn't start server:\n" + ioe);
			System.exit(-1);
		}
		System.out.println("start!");
		try {
			System.in.read();
		} catch (Throwable t) {
		}
		System.out.println("stop!");
	}
}
