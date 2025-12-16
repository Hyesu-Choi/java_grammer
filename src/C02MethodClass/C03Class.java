package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C03Class {
    public static void main(String[] args) {
//        클래스메서드의 기본 호출 방식 클래스명.메서드명();
        int result = Calculator.sum(10, 20);
        System.out.println(result);  //30

//        객체가 아닌 클래스 사용의 문제점 : 고유의 변수, 고유의 메서드 사용 불가
//        A부서의 매출
//        20원매출 발생
        Calculator.sumAcc(20);
        System.out.println(Calculator.total);  //20
//        30원매출 발생
        Calculator.sumAcc(30);
        System.out.println(Calculator.total);  //50
//        40원매출 발생
//        누적매출 : 90원매출 발생
        System.out.println(Calculator.sumAcc(40));  //90

//        B부서의 매출
//        10원 매출 : 누적 10
        System.out.println(Calculator.sumAcc(10));  //100 -> 10이 되어야함
//        20원 매출 : 누적 30
        System.out.println(Calculator.sumAcc(20));  //120 -> 30이 되어야함

//        객체를 활용한 부서별 매출계산
//        객체 생성 방법 : 클래스명 객체명 = new 클래스명(); // 메모리공간을 나누기 위해 객체로 선언함. 객체를 선언하면 total이 메모리당 할당되서 각자 누적값 계산 가능함.
        CalculatorForInstance calA = new CalculatorForInstance();
        calA.sumAcc(20);  //객체명.메소드명()
        calA.sumAcc(30);
        calA.sumAcc(40);
        System.out.println(calA.total); //90
        CalculatorForInstance calB = new CalculatorForInstance();
        calB.sumAcc(10);
        calB.sumAcc(20);
        System.out.println(calB.total); //30

//        클래스메서드 사용 예시
        System.out.println(Math.min(10,20));  // 메모리공간 필요없을 경우 클래스메서드 사용
//        객체 사용 예시  : 각자의 메모리공간이 필요할 경우 객체 사용
        List<Integer> myList = new ArrayList<>();
        myList.add(10);  //10
        List<Integer> myList2 = new ArrayList<>();
        myList2.add(20);  //20

    }
}


//일반적으로는 파일에 클래스 여러개 안만드는데 이건 연습위해 만듬. 만들 수는 있음. 단, public class는 하나만 있어야함
class Calculator {
    //    static이 붙어있으면 클래스변수, 붙어있지 않으면 객체변수
    static int total = 0;  //클래스변수

    public static int sum(int a, int b) { //클래스 메서드
        return a + b;
    }

    public static int sumAcc(int a) {  //클래스 메서드
        total += a;
        return total;
    }
}

class CalculatorForInstance {
    int total = 0;  // 객체변수
//    메서드이 static이 있는 경우는 클래스 메서드
//    클래스메서드는 일반적으로 객체의 상태와 상관없는 독립적인 로직 수행시에 사용
//    클래스메서드호출시 : 클래스명.메서드명();
    public static int sum(int a, int b) {
        return a + b;
    }
//    메소드에 static이 없는 경우는 객체메서드
//    객체메서드 호출시 : 객체명.메서드명();
    public int sumAcc(int a) {
//        this는 객체를 지칭. 일반적으로, 매개변수와 객체변수 이름을 구분짓기 위해서 사용
        this.total += a;  //int total = 0; 이걸 의미함.
        return this.total;
    }
}
