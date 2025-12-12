package C01Basic;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

public class C08String {
    public static void main(String[] args) {
/*
//        String 선언방법 2가지
//        객체선언방식
        String st1 = new String("hello world");
        String st2 = new String("hello world");
//        리터럴방식 : String pool을 사용하는 방식(java에서 추천)
        String st3 = "hello world";
        String st4 = "hello world";
        System.out.println(st1 == st2);  // false. 다른 힙영역에 저장됨
        System.out.println(st3 == st4);  // true. 같은 string pool 을 써서
        System.out.println(st1 == st3);  // false. 다른 힙영역에 저장됨.
//        참조변수형의 비교는 ==을 지향할것.
        System.out.println(st1.equals(st3));  // true

//        equals : 힙메모리의 문자열을 가져와서 equal 관계 비교
        String st1 = "hello1";
        String st2 = "Hello1";
        System.out.println(st1.equals(st2));  // false
        System.out.println(st1.equalsIgnoreCase(st2));  // true. 대소문자여부는 무시하겠다

//        length() : 문자열의 길이 출력
        String st1 = "hello1 world1 java1";
        System.out.println(st1.length());  // 19
//        charAt(n) : 특정 index의 문자(char)값을 리턴
        char ch1 = st1.charAt(7);
        System.out.println(ch1);  // w

//        a의 개수가 몇개인지 출력
        String st1 = "hello1 world1 java1";
        int count = 0;
        for (int i=0; i<st1.length(); i++) {
            if(st1.charAt(i)=='a') {
                count++;
            }
        }
        System.out.println(count);
        }
//        toCharArray : String문자열을 char배열로 변환
        int total = 0;
        for(char ch : st1.toCharArray()) {
            if(ch=='a') {
                total++;
            }
        }
        System.out.println(total);

//        indexOf(문자열) : 특정 문자열의 위치(index) 반환. 가장 먼저 나오는 문자열의 위치 반환.
        String st1 = "hello java java";
        System.out.println(st1.indexOf("java"));  // 6
        System.out.println(st1.lastIndexOf("java"));  // 11. java라는 문자가 여려개일경우 마지막 java의 인덱스 찾기
        System.out.println(st1.contains("hello"));  // true. 문자열에서 해당 문자가 있는지 확인
        System.out.println(st1.contains("world"));  // false

//        문자열 더하기 : += 사용. 성능측면에서는 추후 배울 StringBuffer, StringBuilder사용
        String st1 = "hello";
        st1 += " world";
        st1 += '1';  // String에서 char를 더하면 String으로 변환
        System.out.println(st1);  // hello world1

//        프로그래머스 - 플랫폼 사용법(나머지 구하기) ⭐풀어보기
//        프로그래머스 - 특정 문자 제거하기 (⭐다시 풀어보기) 향상for문, toCharArray 사용해서
        String answer = "";
        for(char ch : my_string.toCharArray()) {
            if(ch != letter.charAt(0)) {
                answer += ch;
            }
        }
        return answer;

//        substring(a,b) : a이상 b미만의 index의 문자를 잘라 문자열로 반환
        String st1 = "hello world";
        System.out.println(st1.substring(0, 4));  // hell
        System.out.println(st1.substring(0, 5));  // hello
        System.out.println(st1.substring(6, st1.length()));  // world. 마지막index는 length로 구하면됨

//        프로그래머스 - 가운데 글자 가져오기 ⭐풀어보기
        String s= "asbc";
        String answer = "";

        // 길이를 일단 계산하고. 나머지가 0 이면 짝수니까 가운데 두개 반환하고, 홀수면 그냥 가운데 반환
        if(s.length() % 2 == 0) {
            answer = s.substring(s.length()/2-1 , s.length()/2+1);  // 이거 살짝 틀렸다. 다시 체크하기
        } else {
            answer = s.substring(s.length()/2 , s.length()/2+1);
        }
//        return answer;
        System.out.println(answer);

//        trim, strip : 문자열 양쪽 끝의 공백 제거. 성능은 strip이 더 좋음. 전통적으로 trim 많이 씀
        String st1 = "  hello world  ";
        String st2 = st1.trim();
        System.out.println(st2);  //hello world
        String st3 = st1.strip();
        System.out.println(st3);  //hello world

//        toUpperCase : 모든 문자열을 대문자로 변환
//        toLowerCase : 모든 문자열을 소문자로 변환
        String st1 = "Hello";
        String st2 = st1.toUpperCase();
        String st3 = st1.toLowerCase();
        System.out.println(st2);  //HELLO
        System.out.println(st3);  //hello

//        replace(a,b) : a문자열을 b문자열로 대체
        String st1 = "hello world world";
        String st2 = st1.replace("world", "java");  // st1을 대체하진 않음. 새로운걸 뱉어냄.
        System.out.println(st2);  // hello java java

//        replaceAll(a,b) : replace와 사용법을 동일. 정규표현식을 쓸 수 있는 점이 차이점이다.
        String st1 = "01abC123  한글123";
//        한글 제거
        String answer1 = st1.replaceAll("[가-힣]", "");
        System.out.println(answer1);  // 01abC123123

//        알파멧소문자제거
        String answer2 = st1.replaceAll("[a-z]", "");
        System.out.println(answer2);  //01C123한글123

//        알파멧제거
        String answer3 = st1.replaceAll("[A-za-z]", "");
        System.out.println(answer3);  //01123한글123

//        공백제거
        String answer4 = st1.replaceAll(" ", "");
        System.out.println(answer4);  //01abC123한글123
        String answer5 = st1.replaceAll("\\s+", "");
        System.out.println(answer5);  //01abC123한글123

//        전화번호 검증
        String number = "010-1234-1234";
        boolean check = number.matches("^\\d{3}-\\d{4}-\\d{4}$");  // ^정규표현식 시작, $정규표현식 끝
        System.out.println(check);  // true

//        이메일 검증
        String email = "abc@naver.com";
        boolean check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
        System.out.println(check);  // true

//        split : 특정문자를 기준으로 잘라서 문자배열로 만드는것.
        String a = "a:b:c:d";
        String[] arr = a.split(":");
        System.out.println(Arrays.toString(arr));  //[a, b, c, d]

        String b = "a b c  d";
        String[] arr2 = b.split(" ");
        String[] arr3 = b.split("\\s+");  // n개의 공백을 기준으로 자르겠다.
        System.out.println(arr2.length);  //5. 하나는 빈문자열.
        System.out.println(arr3.length);  //4

//        null과 공백의 차이
        String st1 = null;  //null은 문자열 아님
        String st2 = "";  //빈문자열은 문자열
        String st3 = " ";  //공백
        System.out.println(st1==st2);  //false
//        System.out.println(st1.isEmpty());  //NullPointerException
        System.out.println(st2.isEmpty()); //true
        System.out.println(st3.isEmpty()); //false
        System.out.println(st3.isBlank()); //true

//        공백의 개수 세기
        String abc = "hello    world   java";
        int total = 0;
        for(int i=0; i<abc.length(); i++) {
            if(abc.substring(i, i+1).isBlank()) {
                total++;
            }
        }
        System.out.println(total);  //7

//        문자열 조립 : StringBuffer, StringBuilder
        String[] arr = {"java", "python", "javascript"};
        StringBuffer sb = new StringBuffer();
        String result = "";
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
            sb.append("\n");  // \n은 줄바꿈을 의미.
        }
        result = sb.toString();
        sb.insert(0, "C++");  // 문자열 중간에 insert하는 것은 성능저하를 발생.
        sb.deleteCharAt(0); // 마지막 index를 삭제하는 것 외에는 성능저하 발생.
        sb.deleteCharAt(sb.length()-1); // 마지막 index 삭제.
        System.out.println(result); //java python javascript. StringBuffer를 string으로 변환해서 출력함.
        System.out.println(sb);  // java python javascript. StringBuffer를 출력함
//        StringBuilder는 성능이 뛰어나지만(멀티쓰레드가 가능해서), 동시성문제 있음(Thread-Safe하지 않음). 실전코딩에서는 StringBuffer쓰면됨
//        예를들어)쓰레드A가 append("Hello")하고 쓰레드B가 append("world")
//        이 두 작업이 중간에 섞여 "heworldllo" 이런식으로 잘못된 값을 만들 수 있음.


//        문자열 뒤집기
//        방법1)
        StringBuilder sb2 = new StringBuilder();
        String st1 = "hello";
        for(int i=st1.length()-1; i>=0; i--) {
            sb2.append(st1.charAt(i));
        }
        System.out.println(sb2); //olleh
//        방법2)
        StringBuilder sb3 = new StringBuilder(st1);
        sb3.reverse();
        System.out.println(sb3);  //olleh

//        프로그래머스 - 문자열밀기 ( 모름. 다시 풀어보기)
//        A를 stringbuilder로 변환
//        A에 마지막값을 앞으로 insert, 마지막값 제거
//        A와 B를 비교
class Solution {
    public int solution(String A, String B) {
       if (A.length() != B.length()) return -1;
        StringBuilder sb = new StringBuilder(A);
        for (int i = 0; i < A.length(); i++) {
            if (sb.toString().equals(B)) {
                return i;
            }
            // 오른쪽으로 한 칸 밀기
            char last = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, last);
        }

        return -1;
    }
}
//        방법2) A+A 더해서 B있는지 확인

//        문자열 비교 : 비교하면서 아스키코드값을 뺌. 문자 비교하면서 같은 문자 나오면 다음 문자로 가고, 다른문자 나오면 아스키코드 비교하는듯. 오름차순 내림차순 비슷한듯?
        String st1 = "hello";
        String st2 = "dello";
        String st3 = "hello";
        String st4 = "hfllo";
        String st5 = "java";
        System.out.println(st1.compareTo(st2));  //양수. 4 (h-d)
        System.out.println(st2.compareTo(st1)); //음수. -4 (d-h)
        System.out.println(st1.compareTo(st3)); //0 . 문자열일치
        System.out.println(st4.compareTo(st3)); //양수. 1 (f-3)
        System.out.println(st5.compareTo(st3));  // 양수. 2(j-h)
*/










    }
}
