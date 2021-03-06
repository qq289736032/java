package com.jisen.IO.TimeClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by jisen on 2018/2/26.
 */
public class IOTimeClient {
    public static void main(String[] args) {
        int port = 8888;
        if(args != null && args.length > 0){
            try{

            }catch (Exception e){

            }
        }
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
            String localhost = ia.getHostAddress();
            System.out.println(localhost);
            socket = new Socket(localhost,port);

            //获取输出流写入数据
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIME ORDER, I am client1");
            System.out.println("Send order 2 server succeed.");

            //输入流,读取服务端的消息
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String resp = in.readLine();
            System.out.println("isRead?");
            System.out.println("Now is : " + resp);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(out != null ){
                out.close();
                out = null;
            }
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
