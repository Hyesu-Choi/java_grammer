package C03Inheritance;

public class C03AnimalMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sound2();  //멍멍멍멍
        cat.sound();  //동물이 소리를 냅니다.

//        상속관계일때는 부모클래스의 타입을 자식클래스의 객체 타입으로 지정가능
        Animal dog2 = new Dog();
        dog2.sound();
//        부모클래스의 타입으로 지정시, 부모클래스에서 정의된 메서드만 객체에서 사용가능.
//        dog2.sound2();  //빨간불.
    }
}

class Animal {

    public void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    @Override
    public void sound(){
        System.out.println("멍멍");
    }
    public void sound2() {
        System.out.println("멍멍멍멍");
    }
}

class Cat extends Animal {
    public void sound2() {
        System.out.println("야옹야옹");
    }
}