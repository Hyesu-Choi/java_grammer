package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C08AccountMain {
    public static void main(String[] args) {
//        계좌개설(객체생성)
        Account account = new Account("홍길동", "1234", 1000000 );
        Account account2 = new Account("김순자", "54321", 5000000 );

//        List를 계좌객체를 담는 자료구조로 사용 2-3개 담기
        List<Account> myList = new ArrayList<>();
        myList.add(account);
        myList.add(account2);
        myList.add(new Account("최영철", "13579", 10000000));

//        계좌1("1234")에서 계좌2("54321")로 송금(50000) : 잔고변경메서드필요(from.set(0,300) 뭐 이런거)
//        내 객체를 찾아서 50000원을 차감하고, 상대방 객체를 찾아서 50000원을 가산한다.

        for(Account a : myList) {  // 여기서 값을 바꿔버리면 위험하눼...메서드로 바꿔야할듯..
            if(a.getAccountNumber().equals("1234")) {

            }
            if(a.getAccountNumber().equals("54321")) {

            }
        }
//        for(Account a : myList) {
//            if(a.getAccountNumber .equles('123')) {
//                차감
//            }
//            if(a.getAccountNumber.equals("234")) {
//                증감
//            }
//        }

    }
}

//Account 클래스 - 계좌주명(name-string), 계좌번호(accountNumber-String), 잔고(balance-long)
//tostring필요하면 넣고..
class Account {
    private String name;
    private String accountNumber;
    private long balance;

    public Account(String name, String accountNumber, long balance) { //생성자함수
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    // 잔고 변경 메서드
//    public long changeBalance(String a, String b, long amount){
//this.balance - amount
//
//    }

}