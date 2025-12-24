package C08Thread;

public class MyThread extends Thread {

//    스레드를 실행(.start) 하면 Thread 클래스 내에 run 메서드 호출
//    그런데, Thread 클래스의 run 메서드는 비어 있으므로, 상속받아 오버라이딩
    @Override
    public void run() {
        System.out.println("스레드 실행");
    }
}
