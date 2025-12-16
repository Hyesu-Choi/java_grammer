package C02MethodClass;

import java.util.*;

// java에서 같은 이름의 메서드 선언은 불가
// 다만, 같은 이름의 메서드명을 사용하되, 매개변수의 개수 또는 매개변수의 타입이 달라지는 메소드 오버로딩은 허용.
public class C06MethodOverloading {
    public static void main(String[] args) {
//        메서드 오버로딩 후 해당 메서드 호추
        System.out.println(sum(10, 20));
        System.out.println(sum(10.5, 20.5));
        System.out.println(sum(10, 20, 30));

//        또다른 메서드 오버로딩 사례
        System.out.println("hello");
        System.out.println(10);
        System.out.println(10.5);
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(0, 20);

    }

    public static int sum(int a, int b) {
        return a+b;
    }

    public static double sum(double a, double b) { //타입 달라짐
        return a+b;
    }

    public static int sum(int a, int b, int c) { //매개변수 개수 달라짐
        return a+b+c;
    }

}

