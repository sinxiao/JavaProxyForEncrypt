package com.sinxiao.server;

import it.sauronsoftware.base64.Base64;

import java.io.InputStream;
import java.io.OutputStream;

import com.sinxiao.utils.SimpleCrypt;
/** 
 * * 从外部读取，向内部发送信息 
 */  
public class SocketThreadInput extends Thread {
	private InputStream isOut;  
    private OutputStream osIn;  
  
    public SocketThreadInput(InputStream isOut, OutputStream osIn) {  
        this.isOut = isOut;  
        this.osIn = osIn;  
    }  
  
    private byte[] buffer = new byte[409600];  
  
    public void run() {  
        try {  
            int len;  
            while ((len = isOut.read(buffer)) != -1) {  
                if (len > 0) {  
                    System.out.println("get request: "+new String(buffer, 0, len));
                    
//                    buffer = Base64.decode(buffer);
//                    byte[] endata = SimpleCrypt.decrypt(buffer,len);
//                    osIn.write(endata, 0, endata.length);
                    
                    osIn.write(buffer, 0, buffer.length);
                    osIn.flush();  
                }  
            }  
        } catch (Exception e) {  
            System.out.println("SocketThreadInput leave");  
        }  
    }  
}
