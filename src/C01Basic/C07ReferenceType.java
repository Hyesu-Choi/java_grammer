package C01Basic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
public class C07ReferenceType {
    public static void main(String[] args) {

//        기본(원시)자료형 : int, char, boolean 등
//        특징 : 리터럴형식(값그대로)으로 값을 세팅.
        int a = 10;
//        참조자료형 : 기본자료형을 제외한 클래스 기반의 객체
//        특징 : new 키워드를 통해 값 세팅
        String st1 = new String("hello world");  // 원래는 이렇게 선언해야하지만 현대적코딩으로는 밑에껄로 씀
//        String은 예외적으로 리터럴값 세팅 허용
        String st2 = "hello world";
//        참조자료형을 출력하면 힙메모리의 주소값이 출력되어야 하나, String 내부에 toString메서드가 구현 및 자동호출 되도록 설계 되어 있다.
        System.out.println(st1);  // hello world

        int[] arr1 = new int[4];
//        배열도 객체이므로 new 키워드 써야 하나, 예외적으로 리터럴값 세팅 허용
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(arr2);  // [I@4c873330(힙메모리주소값 출력)
//        배열은 toString메서드가 별도로 구현되어있기 때문에, 별도로 호출해줘야함.
        System.out.println(Arrays.toString(arr2));  // [1, 2, 3, 4]

//        원시자료형을 스택메모리에 값이 저장되므로, ==로 비교시 값 자체를 비교
        int a = 10;
        int b = 10;
        System.out.println(a == b);  // true

//        참조자룧은 스택메모리에 힙메모리의 주소값이 저장되므로, ==로 비교시 메모리주소값을 비교
        String st1 = new String("hello");
        String st2 = new String("hello");
        System.out.println(st1 == st2);  // false
//        별도의 메서드를 통해 힙메모리의 값을 비교
        System.out.println(st1.equals(st2));

//        WrapperClass : 기본형 타입을 Wrapping한 클래스(참조자료형)
        int i1 = 10;
        Integer i2 = 10;
//        Integer i4 = new Integer(10);  // 원래는 이렇게 써야하지만 현대적프로그래밍에서 삭제됨.
//        Wrapper 클래스의 주요 메서드 사용 예시
        String st1 = Integer.toString(i1);  // int형을 string으로 변환
        int i3 = Integer.parseInt(st1);  // string형을 int형으로 변환

//        추후 배우게 될 list, map, set 등 참조자료형에는 원시자료형을 쓸 수 없음.
        List<Integer> list1 = new ArrayList<>();  // List에 integer넣기로 선언함.
        list1.add(new Integer(10));
        list1.add(20);
        list1.add(30);
        Integer a = list1.get(0); //10

//        다만, 예외적으로 배열(참조자료형)에는 원시자료형 세팅 가능
        int[] arr1 = {10, 20, 30};  // 원시자료형도 가능. 원시자료형을 관례적으로 많이 씀
        Integer[] arr2 = {10, 20, 30};  //  wapper클래스도 가능

        int i1 = 10;
//        Integer ig1 = new Integer(10);
//        오토박싱 : 원시자료형 -> Wrapper클래스 자동 형변환
        Integer ig1 = i1;
//        오토언박싱 : Wrapper클래스 -> 원시자료형 자동 형변환
        int i2 = ig1;


    }
}
*/