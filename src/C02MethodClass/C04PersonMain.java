package C02MethodClass;

public class C04PersonMain {
    public static void main(String[] args) {
//        회원가입 예시
        String name1 = "hong1";
        String email1 = "hong1@naver.com";
        int age1 = 30;

        String name2 = "hong2";
        String email2 = "hong2@naver.com";
        int age2 = 40;
        printMember(name1, email1, age1);  //이름은 hong1, 이메일은 hong1@naver.com, 나이는 30 입니다.
        printMember(name2, email2, age2);  //이름은 hong2, 이메일은 hong2@naver.com, 나이는 40 입니다.
//        위의 코드는 요소(속성)들이 그룹화되어 있지 않다보니, 중복과 코드의 가독성이 저하

//        클래스에 속성을 정의(C04Persion.java)하여, 사람 객체로 생성
//        C04Person p1 = new C04Person();  // 객체생성
//        p1.name = "hong1";  // 객체변수에 값 직접 대입. 다른 클래스 personMain에서 person클래스의 email 객체변수에 접근하고 있음. 위험함.
//        p1.email="hong1@naver.com";
//        p1.age=30;
//        C04Person p2 = new C04Person();
//        p2.name="hong2";
//        p2.email="hong2@naver.com";
//        p2.age=40;
//        printMember2(p1);  //이름은 hong1, 이메일은 hong1@naver.com, 나이는 30 입니다.
//        printMember2(p2);  //이름은 hong2, 이메일은 hong2@naver.com, 나이는 40 입니다.
//        위쪽 코드의 문제점
//        1.person객체의 변수에 외부 클레스에서 접근가능
//        2.person에 대한 출력 코드가 외부클래스마다 중복되어 들어갈 여지가 있다.

        C04Person p3 = new C04Person();
        p3.setName("hong3");  // private화한 객체변수의 값을 setName메서드로 값 세팅.
        p3.setEmail("hong3@naver.com");
        p3.setAge(30);
//        printMember2(p3);  //  printMember2는 중복이 많이 되서, 객체메서드로 만들어서 호출하는게 좋음.
        System.out.println(p3.returnPersonInfo()); //이름은 hong3, 이메일은 hong3@naver.com, 나이는 30 입니다.


    }

//    사용자정보 출력메서드(printMember)
//    예시) 이름은 XX, 이메일을 yy, 나이는 zz 입니다.
    public static void printMember(String name, String email, int age) {
        System.out.println("이름은 " + name + ", 이메일은 " + email + ", 나이는 " + age + " 입니다." );
    }
//    public static void printMember2(C04Person person) {  // 객체의 주소값이 매개변수로 잔달
//        System.out.println("이름은 " + person.name + ", 이메일은 " + person.email + ", 나이는 " + person.age + " 입니다." );
//    }
    public static void printMember2(C04Person person) {  // 객체의 주소값을 매개변수로 받아옴. 객체변수를 private화한걸 get해옴.
        System.out.println("이름은 " + person.getName() + ", 이메일은 " + person.getEmail() + ", 나이는 " + person.getAge() + " 입니다." );
    }

}
