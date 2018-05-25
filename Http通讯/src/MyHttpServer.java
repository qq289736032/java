import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jisen on 2018/5/24.
 */
public class MyHttpServer  {

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080),10);
        httpServer.createContext("/httpServer", new MyHandler());
        httpServer.setExecutor(null);
        httpServer.start();
    }
     static class MyHandler implements HttpHandler {
        public void handle(HttpExchange he) throws IOException {

            InputStream is = he.getRequestBody();
            //接收反馈
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is,"utf8"));

            StringBuffer sBuffer = new StringBuffer();

            String line = "";
            while ((line = reader.readLine()) != null) {
                sBuffer.append(line).append("\r\n");
            }
            reader.close();
            is.close();
            System.out.println("接收到来自数据库的数据");
            System.out.println(sBuffer);
            //服务器收到
            String response = "the data is receive";
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
