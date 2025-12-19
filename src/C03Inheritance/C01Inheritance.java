package C03Inheritance;

// 상속 : 부모의 변수와 메서드를 자식클래스에서 물려받는것(extends 키워드 사용)

// 자식 클래스
public class C01Inheritance extends Parents {
    int b = 20;

    public static void main(String[] args) {
//        부모클래스의 a변수 상속
        C01Inheritance c1 = new C01Inheritance();
        System.out.println(c1.a);  //10
        System.out.println(c1.b);  //20
//        부모클래스의 m1메서드 상속
        c1.m1();  //부모 클래스 입니다. 부모메서드에서 정의한 메소드 상속받음.
        c1.m2();  //자식클래스 입니다.  자식메서드에서 정의한 메소드. 부모와 똑같은 이름으로 만든 자식 메서드 있으면 내꺼가 우선됨(오버라이딩)
//        System.out.println(c1.c);

    }
//    오버라이딩(부모 메서드의 재정의) : 부모클래스의 메서드명과 자식클래스의 메서드명이 동일한 경우
//    Override된 메서드임을 명시적으로 표현하는 키워드(어노테이션). 성능 최적화를 위해서 해당 키워드 붙여주는 것이 더 좋음.
    @Override
    public void m1(){  // 재정의
        System.out.println("자식클래스에서 오버라이딩한 m1입니다.");
    }
    public void m2() {
        System.out.println("자식클래스 입니다.");
    }
}

// 부모 클래스
class Parents {
    int a = 10;  //접근 제어자 default : 같은 패키지
//    private접근제어자는 클래스내부에서만 접근가능하므로, 자식클래스에서도 접근불가
    private int c = 30;
    public void m1() {
        System.out.println("부모 클래스 입니다.");
    }

}
