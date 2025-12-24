package C07ExceptionFileParsing.MemberException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

//사용자와 인터페이싱(입출력)하는 계층
public class MemberController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService memberService = new MemberService();
        while (true) {
            System.out.println("1번 : 회원가입, 2번 : 회원상세조회, 3번 : 회원목록조회, 4번 : 로그인");
            String input = sc.nextLine();
            if (input.equals("1")) {
                System.out.println("회원가입서비스입니다.");
                System.out.println("이름을 입력해주세요");
                String name = sc.nextLine();
                System.out.println("email을 입력해주세요");
                String email = sc.nextLine();
                System.out.println("비밀번호를 입력해주세요");
                String password = sc.nextLine();
//                사용자의 입력값 단순검증(이메일형식, 이름길이 등 db조회안해도되는경우..)
                if (password.length() < 10) {
                    System.out.println("입력값이 너무 짧습니다.");
                    return;
                }
//                회원가입시 발생하는 예외를 적절히 try/catch
                try {
                    memberService.register(name, email, password);
                } catch (IllegalArgumentException e) {  // 에러 더 많아지면 catch문 추가하면 됨..
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }

            } else if (input.equals("2")) {
                System.out.println("회원상세조회 서비스입니다.");
                System.out.println("회원 ID값을 입력해주세요");
                long id = Long.parseLong(sc.nextLine());
//                회원상세조회시 발생하는 예외를 적절히 try/catch
                try {
                    Member member = memberService.findById(id);
                    System.out.println(member);
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            } else if (input.equals("3")) {
                System.out.println("회원목록조회 서비스입니다.");
                List<Member> memberList = memberService.findAll();
                System.out.println(memberList);
            } else if (input.equals("4")) {
                System.out.println("로그인 서비스입니다.");
                System.out.println("email을 입력해주세요");
                String email = sc.nextLine();
                System.out.println("비밀번호를 입력해주세요");
                String password = sc.nextLine();
//                예외처리 : 예외발생시, 예외의 원인 출력.
                try {
                    memberService.login(email, password);
                    System.out.println("로그인 성공입니다.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}