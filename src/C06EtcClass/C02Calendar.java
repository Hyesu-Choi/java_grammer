package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class C02Calendar {
    public static void main(String[] args) {
        /*
//        java.util패키지의 Calendar클래스
        Calendar myCalendar = Calendar.getInstance();
        System.out.println(myCalendar.getTime());  //Tue Dec 23 09:39:15 KST 2025
        System.out.println(myCalendar.get(Calendar.YEAR));  //2025
        System.out.println(myCalendar.get(Calendar.MONTH)+1);  //->12 ..0월부터 카운트해버려서 +1해야함
        System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK));  //요일 3
        System.out.println(myCalendar.get(Calendar.DAY_OF_MONTH));  //일 23
        System.out.println(myCalendar.get(Calendar.HOUR));  // 9
        System.out.println(myCalendar.get(Calendar.MINUTE));  // 44
        System.out.println(myCalendar.get(Calendar.SECOND));  // 36

//        java.time패키지의 LocalDateTime, LocalDate, LocalTime 클래스 : 이게 많이 쓰임
        LocalDate myLocalDate = LocalDate.now();
        System.out.println(myLocalDate);  //2025-12-23
        System.out.println(myLocalDate.getYear());  //2025
        System.out.println(myLocalDate.getMonth());  //DECEMBER
        System.out.println(myLocalDate.getMonthValue());  //12
        System.out.println(myLocalDate.getDayOfMonth());  //23
        System.out.println(myLocalDate.getDayOfWeek());  //TUESDAY

        LocalTime myLocalTime = LocalTime.now();
        System.out.println(myLocalTime.getHour());
        System.out.println(myLocalTime.getMinute());
        System.out.println(myLocalTime.getSecond());
   */
        LocalDateTime myLocalDateTime = LocalDateTime.now();
        System.out.println(myLocalDateTime.getYear());  //2025
        System.out.println(myLocalDateTime.getHour());  //10
//        ChronoField매개변수로 다양한 형식의 날짜/시간정보 조회
        System.out.println(myLocalDateTime.get(ChronoField.YEAR));  //2025
        System.out.println(myLocalDateTime.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(myLocalDateTime.get(ChronoField.AMPM_OF_DAY));  //0:오전 1:오후
        System.out.println(myLocalDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY));  //24시체계의 시 출력

//        .of : 임의로 특정시간정보객체를 만들어내고 싶을 떄 사용
        LocalDate birthDay = LocalDate.of(2000, 11, 12);
        System.out.println(birthDay);  //2000-11-12
        LocalDateTime birthDayTime = LocalDateTime.of(2000, 12, 25, 11, 26, 56);
        System.out.println(birthDayTime);  //2000-12-25T11:26:56


    }
}
