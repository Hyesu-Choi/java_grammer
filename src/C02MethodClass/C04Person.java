package C02MethodClass;

public class C04Person {
//    ⭐⭐⭐객체변수는 일반적으로 변수의 안정성을 위해 private(클래스내에서만 접근 가능한 접근제어자)으로 설정..
//    String name;  // 아무것도 안쓰여있으면 default(같은 패키지에서는 접근 가능)
//    String email;
//    int age;
    private String name;  // 다른 클래스에서 이 객체변수 접근 못하게 막음(private)
    private String email;
    private int age;

//    setter와 getter를 통해 외부에서 객체변수에 접근가능하도록 설정
//    setter, getter는 외부 접근이 가능하도록 일반적으로 public하게 설정
    public void setName(String name) {  // name 값 세팅하는 메서드
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public String returnPersonInfo() {
        return "이름은 " + this.name + ", 이메일은 " + this.email + ", 나이는 " + this.age + " 입니다.";  // C04Person 객체변수 바로 가져오기.여기서는 바로 접근 가능하니까! getXXX 안써도됨.
    }
//    객체 메서드들간의 호출은 문제없이 호출 가능.
    public void testMethod1() {
        String temp = this.returnPersonInfo();
    }
//    클래스메서드는 기본적으로 객체생성을 가정하지 않으므로, 클래스메서드내에서 객체메서드를 호출하는것은 불가능(논리적 모순)
    public static void testMethod2(){  // 객체 메소드는 객체가 있다느 전체하에 만들어진건데.. 이건 클래스메서드인데 객체를 호출하는게 말이 안됨
//        String temp = this.returnPersonInfo();  // this는 자기 자신의 객체 참조하는건데 이건 클래스메서드라서 논리가 안맞음.
    }

}
