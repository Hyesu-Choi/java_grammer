package C09NetWorking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


public class C04WebServerDb {
    public static void main(String[] args) throws IOException, SQLException {
//        사용자 : 크롬을 통해 http://localhost:8080?id=1 get 요청
//        서버 : DB에서 조회한 결과값을 문자열 형식으로 응답 1)일반문자열 2)json
        ServerSocket serverSocket = new ServerSocket(8080);

        String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
        String userName = "root";
        String password = "test1234";
        Connection myConnection = DriverManager.getConnection(url, userName, password);
        Statement st = myConnection.createStatement();

        System.out.println("서버 시작");
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null && !line.isEmpty()) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            String requestString = sb.toString();
            String firstLine = requestString.split("\n")[0];
            String infos = firstLine.split(" ")[1];
            String id = "";
            if (infos.contains("?")) {
                id = infos.split("=")[1];
            }

            ResultSet result = st.executeQuery("select * from post where id=" + "\'" + id + "\'");

            Post post = null;
            while (result.next()) {
//                response += ("id : " + result.getInt("id"));
//                response += ("title : " + result.getString("title"));
//                response += ("title : " + result.getString("contents"));
                post = new Post(result.getLong("id"), result.getString("title"), result.getString("contents"));
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPost = objectMapper.writeValueAsString(post);

            String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: application/json; charset=UTF=8\r\n\r\n" + jsonPost;
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            socket.close();

        }

    }
}

class Post {
    private long id;
    private String title;
    private String contents;

    public Post() {
    }

    public Post(long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
