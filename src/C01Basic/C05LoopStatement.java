package C01Basic;

import java.util.Scanner;

public class C05LoopStatement {
    public static void main(String[] args) {
//        while문의 조건식에 변화를 주지 않으면 while문은 기본적으로 무한루프
//        int a=0;
//        아래 while문은 10번 반복되는 반복문
//        while (a<10) {
//            System.out.println("hello world");
//            a=a+1;
//        }

//        while문을 활용하여 2~10까지 출력
//        int a=2;
//        while(a<11) {
//            System.out.println(a);
//            a++;
//        }
//        int c = 2;
//        while(true) {
//            System.out.println(c);
//            c++;
//            if(c >10) {
//                break 키워드를 통해 가장 가까이에 있는 반복을 즉시종료: 2중 while문일 경우 안쪽 while문 종료
//                break;
//            }
//        }

//        반복되는 도어락키 예제
//        만약 비밀번호를 맞추면 즉시 종료 : 문이 열렸습니다.
//        5회입력을 초과할때까지 맞추지 못하면 종료 : 비밀번호 5회 초과 출력
//        int count=0;
//        while(true) {
//            String answer = "1234";
//            Scanner sc = new Scanner(System.in);
//            String input = sc.nextLine();
//            if(answer.equals(input)) {
//                System.out.println("문이 열렸습니다.");
//                break;
//            } else {
//                System.out.println("비밀번호 틀렸습니다.");
//            }
//            count++;
//            if(count==5){
//                System.out.println("비밀번호 5회 초과");
//                break;
//            }
//        }

//        입력한 숫자의 구구단 단수 출력 ex)2X1=2 2X2=4 ... 2X9=18 종료가 안되게
//        while(true) {
//            Scanner sc = new Scanner(System.in);
//            int dan = Integer.parseInt(sc.nextLine());
//            int count = 1;
//
//            while(count<10) {
//                System.out.println(dan + "X" + count + "=" + dan*count);
//                count++;
//
//            }
//        }

//        do while문 : 무조건 1번은 실행되는 while문
//        int a = 100;
//        do{
//            System.out.println("hello world");
//        }
//        while (a<10);
//
//        for문 : 초기식, 조건식, 증감식이 모두 포함되어 있는 반복문
//        실행순서 : 초기식, 조건식, 실행문, 증감문, 조건식, 실행문, 증감문 ....
//        for(int i=0; i<10; i++) {
//            System.out.println("hello world");
//        }

//        1~10중에 홀수만 출력하기
//        for(int i=1; i<11; i++) {
//            if(i%2 != 0 ) {
//                System.out.println(i);
//            }
//        }
//        continue : 반복문의 증감 조건식으로 이동하는 명령어. 즉, continue 하위의 코드를 더이상 실행하지 않음.
        for(int i=1; i<11; i++) {
            if(i%2 == 0 ) {
//                continue는 코드의 직관성과 가독성을 위해 사용.
                continue;
            }
            System.out.println(i);
        }










    }
}
