package C03Inheritance;

// 부모클래스를 상속받을떄, 자식객체의 생성자에서는 부모객체를 자동으로 생성.
// 이때, 부모클래스에 기본생성자가 없으면 자식클래스에서 에러발생
public class C02SuperKeyword extends SuperParents {
    int a;
    public C02SuperKeyword(){
//        super() : 부모클래스의 생성자를 호출하는 메서드
        super(10);
        this.a = 20;
    }
    public static void main(String[] args) {
        C02SuperKeyword c1 = new C02SuperKeyword();
        c1.display(); //20
    }
    public void display(){
        System.out.println("자식의 변수 :  " + this.a);  //20
//        부모의 변수나 메서드에 접근할때에는 super키워드를 사용
        System.out.println("부모의 변수 :  " + super.a);  // 10

    }
}

class SuperParents{
    int a;
    public SuperParents(int a){
        this.a = a;
    }
}
