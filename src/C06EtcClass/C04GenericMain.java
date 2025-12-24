package C06EtcClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class C04GenericMain {
    public static void main(String[] args) {
        String[] stArr = {"java", "python", "c++"};
        stChane(stArr, 0, 1);
        System.out.println(Arrays.toString(stArr));  //[python, java, c++]

        Integer[] intArr = {10, 20, 30};
        intChange(intArr, 0, 1);
        System.out.println(Arrays.toString(intArr));  //[20, 10, 30]

        allChange(stArr, 1, 2);  // 제네릭 타입 선언 change 메서드
        allChange(intArr, 0, 2);
        System.out.println(Arrays.toString(stArr));  //[python, c++, java]
        System.out.println(Arrays.toString(intArr));  //[30, 10, 20]

//        제네릭을 사용한 객체 생성
        GenericPerson<String> p1 = new GenericPerson<>("honggildong");
        GenericPerson<Integer> p2 = new GenericPerson<>(20);
        System.out.println(p1.getVale());  //honggildong
        System.out.println(p2.getVale());  //20

//        제네릭의 사용 예시 : 꺾쇠 자리에 참조변수형이기만 하면 아무거나 들어와도 됨.
        List<String> myList = new ArrayList<>();
        Stream<String> myStream;
        Optional<Student> myStudent;


    }

//    제네릭메서드는 반환타입 왼쪽에 <T>라고 선언.
//    이때 T는 참조형변수인 객체타입만은 허용.
    static <T> void allChange(T[] intArr, int a, int b) {  // 아무 타입의 배열이나 이나 넣을 수 있음
        T temp = intArr[a];  // 아무 타입의 temp변수 선언
        intArr[a] = intArr[b];
        intArr[b] = temp;
    }
    static void intChange(Integer[] intArr, int a, int b) {
        int temp = intArr[a];
        intArr[a] = intArr[b];
        intArr[b] = temp;
    }

    static void stChane(String[] stArr, int a, int b) {
        String temp = stArr[a];
        stArr[a] = stArr[b];
        stArr[b] = temp;
    }

}

class GenericPerson<T>{
    private T value;  // 아무타입의 변수 넣을 수 있음

    public GenericPerson(T value) {
        this.value = value;
    }

    public T getVale() {
        return value;
    }

    public void setVale(T value) {  // 클래스 차원에서 T 선언하면 메서드에는 T 선언 안해도됨
        this.value = value;
    }
}
