package C05AnonymousLambda;

// 익명내부클래스
public class C02AnonymousClass {
    public static void main(String[] args) {
//        AbstractAnimal을 상속한 클래스가 별도로 존재하지 않고,
//        내부에서 익명클래스가 만들어짐과 동시에 익명객체가 생성.
        AbstractAnimal aa = new AbstractAnimal() {
            @Override
            void makeSound() {
                System.out.println("멍멍");
            }
        };
        aa.makeSound();
        aa.eat();
//        구현체가 없는 추상클래스 또는 인터페이스는 익명객체로 생성.
        Animal1 a1 = new Animal1() {
            @Override
            public void makeSound() {

            }

            @Override
            public void eat() {

            }
        };

//        인터페이스의 익명객체에 구현해야할 메서드가 1개밖에 없을때에는 람다표현식(화살표함수) 사용 가능
        Animal2 a2_1 = () -> {
            System.out.println("hello world1");
            System.out.println("hello world2");
        };
        a2_1.makeSound();

//        실행문이 1줄 밖에 없을때에는 {} 생략 가능
        Animal2 a2_2 = () -> System.out.println("hello world1");
        a2_2.makeSound();

//        매개변수가 있는 익명객체의 람다함수 생성
        Animal3 a3_1 = (a, b, c) -> {
            return a + " , " + b + " , " + c;
        };
        System.out.println(a3_1.makeSound("java", "c", "python"));

        Animal3 a3_2 = (a, b, c) -> a + " , " + b + " , " + c;
        System.out.println(a3_2.makeSound("apple", "banana", "orange"));

//        실습
//        Animal4 인터페이스 생성 및 makeSound매서드 선언 : 매개변수는 String, String, int, 리턴타입은 String
//        익명객체 생성시 메서드의 기능 : 매개변수의 숫자값이 10이상이면 a+b를 리턴. 10미만이면 a만 리턴.
//        Animal4 a4 = new Animal4() {  // 이렇게 만들어도 되구..
//            @Override
//            public String makeSound(String a, String b, int c) {
//                if(c >=10) {
//                    return a + b;
//                } else {
//                    return a;
//                }
//            }
//        };
        Animal4 a4 = (a, b, c) -> {
            if (c >= 10) {
                return a + b;
            } else {
                return a;
            }
        };
        System.out.println(a4.makeSound("apple", "juice", 15));

    }
}

// abstract는 구현체가 없어서 객체로 못만듬. 객체 만들려면 자식 클래스에서 받아서 상속하고, 거기서 구현체 만들어서 써야함. 근데 안만들고 바로 익명내부클래스 만들어서 써도됨..
abstract class AbstractAnimal {
    abstract void makeSound();

    void eat() {
        System.out.println("동물이 먹이를 먹습니다.");
    }
}

interface Animal1 {
    void makeSound();

    void eat();
}

interface Animal2 {
    void makeSound();
}

interface Animal3 {
    String makeSound(String a, String b, String c);
}

interface Animal4 {
    String makeSound(String a, String b, int c);
}