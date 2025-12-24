package C08Thread;

public class Library {
    private static int bookCount = 100;

    //    synchronized : 메서드내에서 1개의 스레드만을 실행되도록 보장.
//    public synchronized static void borrow() {
    public static void borrow() {
        if (bookCount > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bookCount -= 1;
            System.out.println("대출 완료");
        } else {
            System.out.println("대출 불가");
        }
    }

    public static int getBookCount() {
        return bookCount;
    }
}
