package C02MethodClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
<게시판서비스>  -- 리팩토링  리팩토링전이랑 public class로 만들어서 이름 겹치니까 일단은 Author2, Post2 로 만들어서 공부해보기
1.계좌객체 : Author, Post
2.자료구조 : List(authorList, postList)
3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요
    3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
    3-2.회원 전체 목록 조회 : id, email
    3-3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수(postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
    3-4.게시글 작성 : id, title, contents, 작성자Email(직접 Author 객체를 변수로 갖는것도 가능)
    3-5.게시물 목록 조회 : id(post), title
    3-6.게시물 상세 조회(게시글 id로 조회) : id, title, contents, 작성자이름
 */
public class C10BoardService2 {
    public static void main(String[] args) {
        List<Author2> authorList = new ArrayList<>();
        List<Post2> postList = new ArrayList<>();
        while (true) {
            System.out.println("서비스번호를 선택하세요.");
            Scanner sc = new Scanner(System.in);
            int number = Integer.parseInt(sc.nextLine());
            if (number == 1) {
                System.out.println("회원가입서비스입니다.");
                System.out.print("이름을 입력해주세요");
                String name = sc.nextLine();
                System.out.print("이메일을 입력해주세요");
                String email = sc.nextLine();
                System.out.print("비밀번호을 입력해주세요");
                String password = sc.nextLine();
                Author2 author = new Author2(name, email, password);
                authorList.add(author);
            } else if (number == 2) {
                System.out.println("회원목록조회서비스입니다.");
                for (Author2 a : authorList) {
                    System.out.println("id는 " + a.getId() + " email은 " + a.getEmail());
                }
            } else if (number == 3) {
                System.out.println("회원상세조회입니다.");
                System.out.print("회원ID를 입력해주세요");
                long id = Long.parseLong(sc.nextLine());
                Author2 author = null;
                for (Author2 a : authorList) {
                    if (a.getId() == id) {
                        author = a;
                        break;
                    }
                }

                System.out.println(" id : " + author.getId() + " email : " + author.getEmail() + " name : " + author.getName() + " password : " + author.getPassword() + " 작성글수 : " + author.getPostList().size());  // 작성한글을 post추가할때마다 업데이트 하기 때문에 글목록리스트의 사이즈 찍어주면됨.

            } else if (number == 4) {
                System.out.println("게시글작성서비스입니다.");
                System.out.print("제목을 입력해주세요");
                String title = sc.nextLine();
                System.out.print("내용을 입력해주세요");
                String contents = sc.nextLine();
                System.out.print("회원EMAIL을 입력해주세요");
                String email = sc.nextLine();
//                회원검색
                Author2 author = null;
                for (Author2 a : authorList) {
                    if (a.getEmail().equals(email)) {
                        author = a;
                        break;
                    }
                }
                Post2 post = new Post2(title, contents, author);
                postList.add(post);
            } else if (number == 5) {
                System.out.println("게시글목록조회서비스입니다.");
                for (Post2 p : postList) {
                    System.out.println("id는 " + p.getId() + " 제목은 " + p.getTitle());
                }
            } else if (number == 6) {
                System.out.println("게시글상세조회입니다.");
                System.out.print("게시글ID를 입력해주세요");
                long id = Long.parseLong(sc.nextLine());
                Post2 post = null;
                for (Post2 p : postList) {
                    if (p.getId() == id) {
                        post = p;
                        break;
                    }
                }

                System.out.println(" id : " + post.getId() + " title : " + post.getId() + " contents : " + post.getContents() + " 작성자이름 : " + post.getAuthor().getName());  // 작성자이름은 post에 author 객체 주소 저장해놨기 떄문에 꺼내와서 넣어주면됨.
            }
        }
    }
}

class Author2 {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Post2> postList;  // 게시글리스트 메모리주소 저장
    private static long staticId;

    public Author2(String name, String email, String password) {
        staticId++;
        this.id = staticId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postList = new ArrayList<>();  // 생성자 생성할때 게시글리스트 초기화. 안해주면 nullerror 터짐
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

    public List<Post2> getPostList() {  // 원래는 게시글작성갯수인데, 그 대신 게시글 작성할때 postList 업데이트 해줌
        return postList;
    }
}

class Post2 {
    private Long id;
    private String title;
    private String contents;
    private Author2 author;  // 작성자객체를 할당. 이메일주소에서 이름 알아내려고
    private static long staticId;

    public Post2(String title, String contents, Author2 author) {
        staticId++;
        this.id = staticId;
        this.title = title;
        this.contents = contents;
        this.author = author;  // 해당 작성자 객체 가져옴
//        여기서 this는 지금 만들고자 하는 post객체를 의미
        author.getPostList().add(this);  // 글작성할때 작성한글 게시글목록 업데이트 같이하기
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

    public Author2 getAuthor() {
        return this.author;  // 작성자 객체 찾아오기
    }
}