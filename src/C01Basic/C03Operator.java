package C01Basic;

public class C03Operator {
    public static void main(String[] args) {
        //    산술연산자 : 사칙연산
//        int n1 = 8;
//        int n2 = 3;
//    *:곱셉, /:나눗셈(몫), %:나머지
//        System.out.println("n1 * n2 = " + (n1*n2));  // 24
//        System.out.println("n1 / n2 = " + (n1/n2));  // 2
//        System.out.println("n1 % n2 = " + (n1%n2));  // 2

//        대입연산자
//        int n = 7;
//        n += 7;  // 14
//        n -= 7;  // 0
//        n *= 7;  // 49
//
//        int n1 = 7;
//        int n2 = 7;
//        int n3 = 7;
//
//        n1 = n1-3;  //4
//        n2 -= 3;  // 4
//        n3 = - 3;  // -3
//
//        int n4 = 10;
//        int n5 = 10;
//        n4 /= 3;  // 3
//        n5 %= 3;  // 1

//        증감연산자
//        int a = 10;
//        a = a + 1;  // 11
//        a += 1; // 12
//        a++; // 13
//        ++a; // 14

//        a++ : 후위증감연산자. 현재 라인의 명령문이 실행되고 나서 1증가
//        ++a : 전위증감연산자. 현재 라인의 명령문이 실행되기 전에 1증가
//        int b = 5;
//        int c = b++;  // c:5 , b:6
//        int d = ++b;  // d:7, b:7

//        비교연산자 : ==, !=, >, >= 등
//        int n1 = 10;
//        int n2 = 20;
//        System.out.println(n1==n2);  // false
//        System.out.println(n1!=n2);  // true
//        if(n1>n2) {
//            System.out.println("n1이 n2보다 큽니다.");
//        }  // 출력 안됨

//        논리연산자 : &&(and), ||(or), !(not)
//        int n1 = 10;
//        int n2 = 20;
//        boolean b1 = n1>5 && n1<30;  // true
//        boolean b2 = n1>5 && n1<7;  // false
//        boolean b3 = n1>5 || n1<7;  // true

//        비트연산자 : 컴퓨터에 2진체계에서의 연산방식. &, |, ^, <<(2만큼곱한효과), >>(2만큼나눈효과)
        int n1 = 5;
        int n2 = 4;
        System.out.println(n1&n2); // 4 (2진법으로 계산)
        System.out.println(n1|n2); // 5 (2진법으로 계산)
        // n1의 값을 왼쪽으로 1칸 옮긴다는 의미는 해당 숫자값에 2로 1번 곱한다는 의미
        System.out.println(n1<<1); // 10
        // n2의 값을 오른쪽으로 2칸 옮긴다는 의미는 해당 숫자값에 2로 2번 나눈다는 의미

        System.out.println(n2>>2); // 1















    }
}
