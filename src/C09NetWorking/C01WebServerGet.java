package C09NetWorking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C01WebServerGet {
    public static void main(String[] args) throws IOException {
//        사용자 : 크롬을 통해 http://서버URL GET 요청 (http요청문서조립필요)
//        서버 : "hello world java" 문자열을 응답 (http응답문서조립필요)
//        소켓 : 서버와 사용자가 통신을 하기 위한 네트워크통신의 끝점을 나타내는 개념.
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 시작");
        while (true) {
//            accept : 사용자의 연결 요청을 수락
//            socket객체 안에는 사용자가 보내온 http요청문서 및 사용자정보(ip.. 등) 들어있음
            Socket socket = serverSocket.accept();
//            write : 사용자에게 서버의 응답메시지를 전송
            String response = "HTTP/1.1 200 OK\r\n\r\n" + "hello world java";
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
//            flush : 일반적으로 변경사항을 확정하는 것을 의미.
            socket.getOutputStream().flush();
            socket.close();

        }

    }
}
