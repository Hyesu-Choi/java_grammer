package C02MethodClass;

// 변수의 유효범위 : 클래스변수와 객체변수는 클래스 전역에서 사용 가능
public class C05Scope {
    //    클래스변수
    static int v1 = 10;  //클래스변수
    //    객체변수 : 객체메서드에서만 접근 가능
    int v2 = 20; // 객체변수 : static 클래스 안에서 사용 불가

    public static void main(String[] args) {
//        지역변수 : 지역변수는 해당 메서드 내에서만 사용.
        int v3 = 10;
        System.out.println(v3);  //10
        scope1(v3);
        C04Person p1 = new C04Person();
        p1.setName("kim");
        p1.setEmail("kim@naver.com");
        p1.setAge(30);
        scope2(p1);
        System.out.println(p1.returnPersonInfo()); //name: lee

    }

    public static void scope1(int v3) { // call by value : 값을 통한 호출. 값만을 전달. 원본을 수정하지는 않음
        v3 = 30;
        System.out.println(v3);  //30
    }

    public static void scope2(C04Person person) { // call by reference : 참조의 의한 호출. 힙메모리 주소값 전달. 원본주소를 넘겨받아서 값을 수정해버림
        person.setName("lee");
        System.out.println(person.returnPersonInfo()); //name: lee
    }
}