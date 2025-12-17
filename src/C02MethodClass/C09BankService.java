package C02MethodClass;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
       <계좌개설 및 입출금 서비스>
       1.계좌객체 : id(auto_increment Long), name(String), accountNumber(String), balance(long)
       2.자료구조 :  계좌객체를 담아둘 자료구조는 Map
       3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요.
           3-1)계좌개설 : "이름"과 사용하실 "계좌번호"와 현재 "가지고있는돈"을 입력하세요. -> 자동으로 id값 증가되어 객체 생성
           3-2)계좌조회 : 계좌조회서비스입니다. 조회하실 계좌의 계좌번호를 입력해주세요. -> 계좌주명, 계좌번호번호, 잔고를 보기좋게 출력
           3-3)입금 : 계좌입금서비스입니다. 입금하실 계좌번호와 입금금액을 입력해주세요. -> 입금전 잔액, 입금후 잔액 출력
           3-4)출금 : 계좌출금서비스입니다. 출금하실 계좌번호와 출금금액을 입력해주세요. -> 잔액검증 -> "출금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력
           3-5)송금 : 송금서비스입니다. 본인의 계좌번호, 상대방의 계좌번호, 송금금액을 입력해 주세요. -> 잔액검증 -> "송금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력.
       4.주의사항
           4-1)프로그램은 상시적 실행될수 있도록 전체코드를 while(true)처리
           4-2)main메서드에서 입출력 처리를 하고, 입금(deposit), 출금(withdraw), 송금(transfer)기능에 대한 핵심 메서드는 BankAccount클래스에 생성.
        */
public class C09BankService {
    public static void main(String[] args) throws IOException {
        Map<String, BankAccount> accountMap = new HashMap<>();  // 계좌번호, 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            int number = Integer.parseInt(br.readLine());
            if(number == 1) {
//                계좌개설
                System.out.println("이름, 계좌번호, 가지고 있는 돈 차례로 입력하세요.");
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String bankAccount = st.nextToken();
                long balance = Long.parseLong(st.nextToken());
//                 만약에 입력값 검증하고 싶으면 사용자와 인터페이싱하는 main 메서드에서 하는게 좋음.
                if(accountMap.containsKey(bankAccount)) {
                    System.out.println("계좌가 중복입니다.");
                } else {
                    accountMap.put(bankAccount, new BankAccount(name, bankAccount, balance));
                }
            }
            else if( number == 2) {
//                계좌조회
                System.out.println("조회하실 계좌번호 입력해주세요.");
                String bankAccount = br.readLine();
                BankAccount a = accountMap.get(bankAccount);
//                System.out.println(a);
                System.out.println(a.getAccountNumber()  + a.getName() + a.getBalance());
            }
            else if (number == 3) {
//                계좌입금
                System.out.println("입급하실 계좌번호와 입금금액을 입력해주세요.");
                st = new StringTokenizer(br.readLine());
                String bankAccount = st.nextToken();
                long money = Long.parseLong(st.nextToken());
                BankAccount a = accountMap.get(bankAccount);
                long beforeDeposit = a.getBalance();
                a.deposit(money);
                long afterDeposit = a.getBalance();
                System.out.println("입금 전 잔액 : " + beforeDeposit + " 입금 후 잔액 : " + afterDeposit );
            }
            else if (number == 4) {
//                계좌출금
                System.out.println("출금하실 계좌번호와 출금금액을 입력해주세요.");
                st = new StringTokenizer(br.readLine());
                String bankAccount = st.nextToken();
                long money = Long.parseLong(st.nextToken());
                BankAccount a = accountMap.get(bankAccount);
                if (a.withdraw(money)) {  // withdraw에 잔액검증이랑, 출금까지 같이 만들었는데, 잔액검증이랑 출금 메서드 나눠도 됨.
                    long afterWithdraw = a.getBalance();
                    System.out.println("출금 후 남는 금액은 " + afterWithdraw + "입니다.");
                } else {
                    System.out.println("잔액이 부족합니다.");
                }
            }
            else if (number == 5) {
//                송금
                System.out.println("본인의 계좌번호, 상대방의 계좌번호, 송금금액을 입력해주세요.");
                st = new StringTokenizer(br.readLine());
                String myAccount = st.nextToken();
                String transferAccount = st.nextToken();
                long money = Long.parseLong(st.nextToken());
                BankAccount a = accountMap.get(myAccount);
                BankAccount b = accountMap.get(transferAccount);
                if(a.transfer(b, money)) {
                    System.out.println("송금 후 남은 금액은 " + a.getBalance() + "입니다." );
                } else {
                    System.out.println("잔액이 부족합니다.");
                }

            }
        }

    }
}

class BankAccount {
    private Long id;
    private static long staticId;
    private String name;
    private String accountNumber;
    private long balance;

    public BankAccount(String name, String accountNumber, long balance) {
        staticId++;
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
//                "id=" + id +
                ", 계좌주명='" + name + '\'' +
                ", 계좌번호='" + accountNumber + '\'' +
                ", 잔고=" + balance +
                '}';
    }

    public void deposit(long money) {
        this.balance += money;
    }
    public boolean withdraw(long money) {
        if(this.balance <money) {
            return false;
        }
        this.balance -= money;
        return true;
    }
    public boolean transfer(BankAccount b, long money) {
        if(this.balance < money) {
            return false;
        }
        this.balance -= money;
        b.balance += money;
        return true;
    }
    public boolean checkBalance(long money) {
        if(this.balance <money) {
            return false;
        } else {
            return true;
        }
    }
}
