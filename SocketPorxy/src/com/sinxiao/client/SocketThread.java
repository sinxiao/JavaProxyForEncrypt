package com.sinxiao.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketThread extends Thread{
	public static final String REMOTE_HOST ="127.0.0.1";
	public static final int REMOTE_PORT =8888;
	private Socket socketIn;  
    private InputStream isIn;  
    private OutputStream osIn;  
    //  
    private Socket socketOut;  
    private InputStream isOut;  
    private OutputStream osOut;  
  
    public SocketThread(Socket socket) {  
        this.socketIn = socket;  
    }  

    public void run() {  
        try {  
            System.out.println("clinet now xxx \n\na client connect " + socketIn.getInetAddress() + ":" + socketIn.getPort());  
            isIn = socketIn.getInputStream();  
            osIn = socketIn.getOutputStream();
            
            // 访问远程代理服务器接口
            socketOut = new Socket(REMOTE_HOST,REMOTE_PORT);
            System.out.println("clinet now xxx begin to connect host="+REMOTE_HOST+" ,port= "+REMOTE_PORT);
            
            isOut = socketOut.getInputStream();  
            osOut = socketOut.getOutputStream();  

            SocketThreadOutput out = new SocketThreadOutput(isIn, osOut);  
            out.start();  
            SocketThreadInput in = new SocketThreadInput(isOut, osIn);  
            in.start();  
            out.join();  
            in.join();  
        } catch (Exception e) {  
            System.out.println(" clinet now xxx a client leave");  
        } finally {  
            try {  
                if (socketIn != null) {  
                    socketIn.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println("clinet now xxx socket close");  
    }  
  
//    public static String findHost(byte[] bArray, int begin, int end) {  
//        StringBuffer sb = new StringBuffer();  
//        for (int i = begin; i <= end; i++) {  
//            sb.append(Integer.toString(0xFF & bArray[i]));  
//            sb.append(".");  
//        }  
//        sb.deleteCharAt(sb.length() - 1);  
//        return sb.toString();  
//    }  
//  
//    public static int findPort(byte[] bArray, int begin, int end) {  
//        int port = 0;  
//        for (int i = begin; i <= end; i++) {  
//            port <<= 16;  
//            port += bArray[i];  
//        }  
//        return port;  
//    }  
  
    // 4A 7D EB 69  
    // 74 125 235 105  
//    public static final String bytesToHexString(byte[] bArray, int begin, int end) {  
//        StringBuffer sb = new StringBuffer(bArray.length);  
//        String sTemp;  
//        for (int i = begin; i < end; i++) {  
//            sTemp = Integer.toHexString(0xFF & bArray[i]);  
//            if (sTemp.length() < 2)  
//                sb.append(0);  
//            sb.append(sTemp.toUpperCase());  
//            sb.append(" ");  
//        }  
//        return sb.toString();  
//    }  
}
