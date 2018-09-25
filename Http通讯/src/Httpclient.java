import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import netscape.javascript.JSObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jisen on 2018/5/24.
 */
public class Httpclient {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
       // String dataByJDBC = getDataByJDBC();
        //如果不从数据库取直接发送字符串
        String dataByJDBC="hello httpserver";
        String backData = httpPost(dataByJDBC);

        System.out.println(backData);
    }

    //获取数据库的数据并封装成json字符串
    public static String getDataByJDBC() throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/admin?useSSL=false";
        String username = "root";
        String password = "root";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        //从数据库中获取数据
        String sql = "select * from menu";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);//

        ResultSet resultSet = preparedStatement.executeQuery();
        int columnCount  = resultSet.getMetaData().getColumnCount();
        ResultSetMetaData metaData = resultSet.getMetaData();
        Map<String,Object> dataMap = new HashMap<String,Object>();
        List<Map<String,Object>> list = new ArrayList<>();
        while (resultSet.next()){
            for(int i=1 ; i<=columnCount;i++){
                String columnName = metaData.getColumnName(i);
                Object object = resultSet.getObject(i);
                dataMap.put(columnName,object);
            }
            list.add(dataMap);
        }

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        return jsonString;
    }

    public static String httpGet() throws IOException {
        URL url = new URL("http://localhost:8080/httpServer?param1=jisen&param2=jisen2");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        //接收反馈
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer sBuffer = new StringBuffer();
        String line = "";
        while ((line = reader.readLine())!=null){
            sBuffer.append(line).append("\r\n");
        }
        reader.close();
        return sBuffer.toString();
    }

    public static String httpPost(String data) throws IOException {
        URL url = new URL("http://localhost:8080/httpServer");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        //HttpURLConnection中的doInput默认为true,而doOutput默认为false,所以如果需要些内容到流,需要设置为true
        conn.setDoOutput(true);
        conn.connect();
        //写入流,发送Http请求
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                conn.getOutputStream()));
        writer.write(data);
        writer.flush();

        //接收反馈
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                conn.getInputStream(),"utf8"));
        StringBuffer sBuffer = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sBuffer.append(line).append("\r\n");
        }
        reader.close();
        return sBuffer.toString();
    }
}
