package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C07Constructor {
    public static void main(String[] args) {
//        캘린더 객체 생성, 생성자에 값 초기화 세팅
        Calendar cal = new Calendar("2025", "12", "25");  // 객체 생성하면서 생성자메서드 실행하면서 매개변수 넘겨줌.
//        캘린더 객체 출력
//        System.out.println(cal);

//        java자료구조내에 직접 만든 객체를 담아 관리
        List<Calendar> myList = new ArrayList<>();
        myList.add(cal);
        myList.add(new Calendar("2024", "10", "11")); // 객체 바로 넣기
        System.out.println(myList); //[{year='2025', month='12', day='25'}, {year='2024', month='10', day='11'}]. Calander객체에 tostring구현해놔서 깔끔하게 출력됨

    }
}

//    클래스명 : Calendar, 변수 : year, month, day 모두 String. 프린트메서드
class Calendar {
    private String year;  // 변수의 안정성 높이기 위해 private 선언
    private String month;
    private String day;

//    생성자 : 객체가 만들어지는(new) 시점에 호출되는 메서드
//    생성자 특징 : 1)클래스명과 메서드명이 동일. 2)반환타입이 없음(void X)
//    생성자의 사용목적 : 1)객체 생성시점에 객체변수값들을 초기화(세팅). 2)변수의 안정성을 위해 setter 사용을 지양하고, 생성자를 사용.
    public Calendar(String year, String month, String day) { //생성자 선언. 값초기화
        this.year = year;
        this.month = month;
        this.day = day;
    }
//    직접 생성자를 1개라도 추가할경우, 초기(기본)생성자는 무시가 되므로, 필요시 별도로 추가
    public Calendar() {}  // 기본생성자 : 객체를 만들 때(new) 할 때 자동으로 만들어지고, 호출되는 생성자 메서드. 이 생성자 메서드가 숨어있음.

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

//    public String returnCalendar(){
//        return this.year + "년" + this.month + "월" + this.day + "일";
//    }

//    toString()메서드는 객체며으로 출력시 자도으로 메서드가 호출 : 오른쪽버튼 생성에 tostring클릭하면 자동으로 생성됨.
    @Override
    public String toString() {
        return "{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
