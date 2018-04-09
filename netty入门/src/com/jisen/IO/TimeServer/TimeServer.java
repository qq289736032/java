package com.jisen.IO.TimeServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jisen on 2018/2/26.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length>0){
            port = Integer.valueOf(args[0]);
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port,10,InetAddress.getByName("192.168.1.80"));
            System.out.println("The time server is start in port :"+port);
            Socket socket = null;
            while(true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(server != null){
                System.out.println("The time server close");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server = null;
            }
        }

    }
}
