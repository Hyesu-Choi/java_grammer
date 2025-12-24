package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class C05HttpJsonParsing {
    public static void main(String[] args) throws IOException, InterruptedException {
//        외부에서 데이터를 받아 java의 객체로 변환
//        외부 Api요청을 하기 위한 라이브러리 : HttpClient, RestTemplate, RestClient
//        HttpClient 는 java 내장클래스.
//        RestTemplate, RestClient 는 스프링에서 가장 많이 사용하는 클래스.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String data = response.body();
        ObjectMapper o1 = new ObjectMapper();

//        객체로 파싱
        Post myPost = o1.readValue(data, Post.class);
        System.out.println(myPost);
//        리스트형식의 객체로 파싱
//        ObjectMapper o1 = new ObjectMapper();
//        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts")).GET().build();
        HttpResponse<String> response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());
        String data2 = response2.body();

        JsonNode jsonNodes = o1.readTree(data2);
        List<Post> postList = new ArrayList<>();
        for(JsonNode j : jsonNodes) {
            Post p1 = o1.readValue(j.toString(), Post.class);
            postList.add(p1);
        }
        System.out.println(postList);
    }
}

class Post {
    private long userId;
    private long id;
    private String title;
    private String body;

    public Post(long userId, long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
    public Post() {}

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}