package C02MethodClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C08AccountMain {
    public static void main(String[] args) {
        /*
//        계좌개설(객체생성)
//        List를 계좌객체를 담는 자료구조로 사용 2-3개 담기
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("홍길동", "1234", 1000000));
        accountList.add(new Account("김순자", "54321", 5000000));
        accountList.add(new Account("최영철", "13579", 10000000));

//        계좌1("1234")에서 계좌2("54321")로 송금(50000) : 잔고변경메서드필요
//        내 객체를 찾아서 50000원을 차감하고, 상대방 객체를 찾아서 50000원을 가산한다.
        for (Account a : accountList) {
            if (a.getAccountNumber().equals("1234")) {
//               계좌1의 잔고를 5000 감소
                a.setBalance(a.getBalance() - 50000);
            }
            if (a.getAccountNumber().equals("54321")) {
//                계좌2의 잔고를 5000원 증가
                a.setBalance(a.getBalance() + 50000);
            }
        }
        System.out.println(accountList);
         */
        //Map을 계좌객체를 담는 자료구조로 사용
        Map<String, Account> accountMap = new HashMap<>();
        accountMap.put("12345", new Account("hong1", "12345", 5000000));
        accountMap.put("54321", new Account("hong2", "54321", 1000000));

        Account a = accountMap.get("12345");
        Account b = accountMap.get("54321");
        a.transfer(b, 50000);
        System.out.println(accountMap);

    }
}

//Account 클래스 - 계좌주명(name-string), 계좌번호(accountNumber-String), 잔고(balance-long)
class Account {
//    참조자료형은 초기값 null
    private Long id; // 회원별 고유 아이디. long 원시자료형으로 하면 초기값 세팅안하면 0이 되니까 고유id값이 다 0이면 이상해서 wrapper 로 세팅하면 null세팅됨. id값은 Long 자료형 씀
    private String name;
    private String accountNumber;
//    원시자료형은 각 자료형에 맞는 초기값 세팅(long:0, String: null..)
    private long balance;
    private static long staticId; //auto-increment를 위한 임시 클래스변수

    public Account(String name, String accountNumber, long balance) { //생성자함수
        staticId++; // 객체가 만들어질때마다 staticId 1씩 증가
        this.id = staticId;
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
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    //    setBalance보다는 의도를 명확히한 메서드명을 사용하기를 권장. setter는 가급적이면 쓰지 말 것.
    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void transfer(Account targetAccount, long money) {
//        잔고 체크
        if (this.balance < money) {
            return;
        }
//        송금할객체에서 돈을 차감
        this.balance -= money;
//        송금받을객체에 돈을 가산
        targetAccount.balance += money;
    }


}