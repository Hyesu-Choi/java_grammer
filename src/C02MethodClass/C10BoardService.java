package C02MethodClass;
 /*
<게시판서비스> - 내가 짠 코드
1.계좌객체 : Author, Post
2.자료구조 : List(authorList, postList)
3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요
    3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
    3-2.회원 전체 목록 조회 : id, email
    3-3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수(postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능) : 포스트리스트에서 이 회원이 몇개 작성했는지 조회해야함(이메일로조회).
    3-4.게시글 작성 : id, title, contents, 작성자Email(직접 Author 객체를 변수로 갖는것도 가능) : 이메일 수동입력
    3-5.게시물 목록 조회 : id(post), title
    3-6.게시물 상세 조회(게시글 id로 조회) : id, title, contents, 작성자이름 : 작성자이름은 author에서 이름 찾아와야함
     */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C10BoardService {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == 1) {
//                회원가입
                System.out.println("회원가입 : 이름, 이메일, 비밀번호 입력해주세요.");
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String email = st.nextToken();
                String password = st.nextToken();
                authorList.add(new Author(name, email, password));

            } else if (number == 2) {
//                회원목록 전체 조회
                System.out.println("회원 전체 목록 조회 입니다.");
                for (Author a : authorList) {
                    System.out.println("회원아이디 : " + a.getId() + "회원이메일 : " + a.getEmail());
                }
            } else if (number == 3) {
                System.out.println("회원상세조회 : 회원 아이디를 입력하세요.");
                long id = Long.parseLong(br.readLine());
                Author a1 = null;
                for (Author a : authorList) {
                    if (a.getId() == id) {
                        a1 = a;
                        break;
                    }
                }
                int postCount = 0;
                for (Post p : postList) {
                    if (p.getAuthorEmail().equals(a1.getEmail())) {
                        postCount++;
                    }
                }
                System.out.println("아이디: " + a1.getId() + " 이메일: " + a1.getEmail() + " 이름: " + a1.getName() + " 비밀번호: " + a1.getPassword() + " 작성글수: " + postCount);
            } else if (number == 4) {
//               게시글 작성
                System.out.println("게시글 작성 : 제목, 내용, 이메일 입력하세요.");
                st = new StringTokenizer(br.readLine());
                String title = st.nextToken();
                String contents = st.nextToken();
                String authorEmail = st.nextToken();
                postList.add(new Post(title, contents, authorEmail));
            } else if (number == 5) {
//                게시물 목록 조회
                System.out.println("게시물 전체 목록 조회입니다.");
                for (Post p : postList) {
                    System.out.println("게시글아이디: " + p.getId() + " 글제목: " + p.getTitle());
                }

            } else if (number == 6) {
//               게시물 상세 조회
                System.out.println("게시물 상세조회 : 게시물 아이디를 입력하세요");
                long postId = Long.parseLong(br.readLine());
                Post p1 = null;
                for (Post p : postList) {
                    if (p.getId().equals(postId)) {
                        p1 = p;
                    }
                }
                Author author = null;
                for (Author a : authorList) {
                    if (p1.getAuthorEmail().equals(a.getEmail())) {
                        author = a;
                        break;
                    }
                }
                System.out.println("게시글아이디: " + p1.getId() + " 글제목: " + p1.getTitle() + " 글내용 : " + p1.getContents() + " 작성자 이름: " + author.getName());
            }
        }
    }
}

//  3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
class Author {
    private Long id;
    private static long staticId;
    private String name;
    private String email;
    private String password;

    public Author(String name, String email, String password) {
        staticId++;
        this.id = staticId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

class Post {
    private Long id;
    private static long staticId;
    private String title;
    private String contents;
    private String authorEmail;

    //    private Author author;  // Author의 메모리주소가 들어가는거임. 잘안되면 포기하라함.
    public Post(String title, String contents, String authorEmail) {
        staticId++;
        this.id = staticId;
        this.title = title;
        this.contents = contents;
        this.authorEmail = authorEmail;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                '}';
    }

}
