package C05AnonymousLambda;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C04StreamApi {
    public static void main(String[] args) {
        /*
        int[] arr = {20,10,4,12};
//        전통적인 방식의 데이터 접근방법 : 메모리주소접근
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }

//        함수형 프로그래밍 방식 : 데이터와 객체 중심이 아닌, 입력에 따른 출력(연산작업포함)만 존재하는 코딩스타일
//        StreamApi : java에서 함수형프로그래밍을 지원하는 라이브러리
//        StreamApi 공식 라이브러리 문서 url : https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

//        forEach는 스트림의 각 요소를 하나씩 소모하면서 동작을 수행
        Arrays.stream(arr).forEach(a -> System.out.println(a));

//        스트림의 생성 : .stream()
        List<String> myList = new ArrayList<>();
        myList.add("java");
        myList.add("c++");
        myList.add("python");
        Stream<String> stream1 = myList.stream();  // 스트림객체 만들기
        String[] myArr = {"java", "python", "c++"};
        Stream<String> stream2 = Arrays.stream(myArr);
//        원시자료형을 위한 stream 객체가 별도로 존재 : IntStream, LongStream
        int[] intArr = {10,20,30,40,50};  // 원시자료형 int 배열
        IntStream stream3 = Arrays.stream(intArr);

//        stream의 중개연산(변환) : filter, map, sorted, distinct, mapToInt
        int[] intArr = {10,10,30,40,50};
//        filter : 특정기준으로 대상을 필터링하여 새로운 스트림을 반환하는 중개연산
//        sum : 스트림의 요소를 하나씩 소모하여 총합을 구하는 메서드
        int total = Arrays.stream(intArr).filter(a -> a>=30 ).sum();  // 스트림생성->30이상인수필터링->합계. 복잡도oN
        System.out.println(total);  //120

//        map : 기존의 스트림을 조작하여 새로운 스트림을 반환
        int total2 = Arrays.stream(intArr).map(a -> a*a).sum();  //스트림생성->스트림복제해서 제곱하고 또다른 스트림 생성 -> 합계
        System.out.println(total2);  //5200

//        distinct : 중복제거
        int total3 = Arrays.stream(intArr).distinct().sum();  // 스트림생성->배열내중복데이터제거->합계
        System.out.println(total3); //130

//        sorted : 정렬
//        toArray() : 스트림을 Array로 변환
        int[] sortedArr = Arrays.stream(intArr).sorted().toArray();
        System.out.println(Arrays.toString(sortedArr));  //[10, 10, 30, 40, 50]

//        mapToInt : intStream형태로 변환해주는 map
        String[] stArr = {"java", "python", "c++"};
        int totalLength = Arrays.stream(stArr).mapToInt(a -> a.length()).sum(); // 스트림생성 -> 스트립복제해서 인트스트림으로 변환(a.length반환값은 int라서 변환해줘야함) -> 합계
        System.out.println(totalLength);  //13

        int[] arr = {1,2,3,4,5,6};
//        실습1)arr에서 홀수만 담은 배열을 생성 후 배열출력
        int[] arr1 = Arrays.stream(arr).filter(a -> a%2 != 0).toArray();
        System.out.println(Arrays.toString(arr1));  //[1, 3, 5]

//        실습2)arr에서 홀수만 걸러서 해당 홀수의 제곱값을 담은 배열을 출력
        int[] arr2 = Arrays.stream(arr).filter(a -> a%2 != 0).map(a -> a*a).toArray();
        System.out.println(Arrays.toString(arr2));  //[1, 9, 25]

//        실습3)arr에서 홀수만 걸러 제곱값을 구하고, 해당숫자값을 오름차순한 순서로 배열을 출력
        int[] arr3 = Arrays.stream(arr).filter(a -> a%2 != 0).map(a -> a*a).sorted().toArray();
        System.out.println(Arrays.toString(arr3));  //[1, 9, 25]

//        stream의 소모 : forEach(출력), sum(합계),  count(갯수), average, max, min, reduce(누적연산), findFirst(스트림의 첫번째값 리턴)
        int[] intArr = {10, 20, 30, 40};
        Arrays.stream(intArr).forEach(a -> System.out.println(a));

        int total = Arrays.stream(intArr).sum();
        System.out.println(total);  //100

        long count = Arrays.stream(intArr).count();  // 필터링하고 갯수 세고싶을때 씀.
        System.out.println(count);  //4
//        optional객체 : 값이 있을수도 있고, 없을수도 있음을 명시한 객체
        int max = Arrays.stream(intArr).max().getAsInt();  // 값이 무조건 있다고 가정하고 값 내놓으라고 getAsInt선언.원래는 하면 안됨.optional로 에러처리해야함..
        System.out.println(max);  //40
        int min = Arrays.stream(intArr).min().getAsInt();
        System.out.println(min);  //10

//        reduce : 누적연산 -> reduce(초기값, 연산식)
        int[] intArr = {10,20,30,40};
        int accSum = Arrays.stream(intArr).reduce(0, (a, b) -> a+b);
        System.out.println(accSum);  //100
        int multiply = Arrays.stream(intArr).reduce(1, (a, b) -> a*b);
        System.out.println(multiply);  //240000
        String[] stArr = {"java", "python", "c++"};
        String result = Arrays.stream(stArr).reduce("", (a,b) -> a+b);
        System.out.println(result);  //javapythonc++

//        findFirst : 첫번째 요소 반환
        String firstValue = Arrays.stream(stArr).filter(a -> a.length()>=5).findFirst().get(); // get은 값 무조건 있으니까 결과 내놓으라고 쓴거임.
        System.out.println(firstValue);  //python

        Map<String, Integer> myMap = new TreeMap<>();
        myMap.put("hello", 10);
        myMap.put("java", 20);
        String firstKeyValue = myMap.keySet().stream().findFirst().get();
        System.out.println(firstKeyValue);  //hello

//        배열로 변환시 주의사항 : 제네릭의 타입소거 -> 자바의 런타임시점에 <String> 과 같은 제네릭의 타입이 제거되는 현상
//        제네릭의 타입소거로 인해, toArray를 통해 새로운 String 배열을 곧바로 만들어내는 것은 불가.
        String[] stArr = {"hello", "java", "world"};
        String[] answer = Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray(a -> new String[a]);  //a 안에는 배열의 길이가 담김
//        System.out.println(Arrays.toString(answer));  //[hello, world]

//        메서드 참조 : 하나의 메서드만을 호출하는 경우에 매개변수를 제겨한 형상
//        형식 - 클래스명::메서드명 , 조건 - 하나의 메서드(실행문)만을 호출하는 경우
        Arrays.stream(stArr).forEach(a -> System.out.println(a));
        Arrays.stream(stArr).forEach(System.out::println);  // 위에 코드를 이렇게 축약할 수 있음

        String[] answer = Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray(a -> new String[a]);
        String[] answer2 = Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray(String[]::new);  // 위에 메서드 축약 가능

        List<Student> myList = new ArrayList<>();
        myList.add(new Student("kim", 20));
        myList.add(new Student("choi", 30));
        myList.add(new Student("lee", 35));
        myList.add(new Student("park", 22));
//        1) 모든 객체의 평균나이(average함수)
        double avgAge = myList.stream().mapToInt(a->a.getAge()).average().getAsDouble();  // 배열에서 나이 추출(mapToInt)

//        2) 정렬을 통한 가장 나이 어린 사람 찾기(sorted, findFirst)
        String young = myList.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).findFirst().get();  // 나이순으로 정렬.

//        3) 30대인 사람들만의 이름만 모아서 새로운 String배열에 담기(map활용)
        String[] s2 = myList.stream().filter(a -> a.getAge()>=30).map(a -> a.getName()).toArray(a -> new String[a]);

//        Optional객체 : 특정 객체에 값이 없을지도(null) 모른다는 것을 명시적으로 표현한 객체
        String st1 = null;
        if (st1 == null) {
            System.out.println("값이 없습니다.");
        } else {
            System.out.println(st1.length());
        }
        Optional<String> opt1 = Optional.ofNullable(null);
        System.out.println(opt1.get()); // 에러남. 있는지 없는지 확인해야함 밑에 코드로
//        .isPresent() : Optional 객체가 있는지 확인. return : boolean
        if(opt1.isPresent()) {
            System.out.println(opt1.get().length());
        } else {
            System.out.println("값이 없습니다.");
        }
//        Optional객체 생성 방법 3가지. 중요함⭐
        Optional<Stream> opt1 = Optional.empty(); // 비어있는 optional객체 생성
        Optional<String> opt2_1 = Optional.ofNullable(null); //비어있는 Optional객체 생성
        Optional<String> opt2_2 = Optional.ofNullable("hello");  //값이 있는 optional객체 생성
        Optional<String> opt3 = Optional.of("hello");  // 값이 있는 optional객체 생성

//        Optinal객체 처리 방법 4가지.
//        방법1. isPresent()로 확인후에 get()
        if (opt1.isPresent()) {
            System.out.println(opt1.get());
        } else {
//            System.out.println(opt1.get());  // 애러발생 NoSuchElementException: No value present
            System.out.println("값이 없습니다.");
        }
//        방법2. orElse() : 값이 있으면 있는 값 return, 없으면 지정한 값 return
        System.out.println(opt2_1.orElse("값이 없습니다."));  //값이 없습니다.
        System.out.println(opt2_2.orElse("값이 없습니다."));  //hello

//        방법3. orElseGet() : 값이 있으면 있는 값 return, 없으면 람다함수 실행
        System.out.println(opt2_1.orElseGet(() -> new String("값이 없습니다.")));  //값이 없습니다.

//        방법4. orElseThrow() - 가장 많이 사용, 값이 있으면 있는 값 return, 없으면 지정한 예외(에러) 강제발생
//        웹개발에서 값을 입력하는 사용자에게 적절한 메시지 전달 목적과 의도될 코드 중단을 목표로 강제로 예외(에러)를 발생시키는 경우는 매우 일반적.
        System.out.println(opt2_1.orElseThrow(() -> new RuntimeException("값이 없습니다.")));  //RuntimeException: 값이 없습니다.
//        System.out.println(opt2_1.get());  //의도치않은 에러발생(지양해야할 에러) NoSuchElementException: No value present

//        optional객체 처리 실습1)
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("kim", 20));
        studentList.add(new Student("choi", 30));
        studentList.add(new Student("lee", 35));
        studentList.add(new Student("park", 22));
//        optional객체 처리방법1.
        OptionalDouble optionalAvg = studentList.stream().mapToInt(a -> a.getAge()).average();
        double value1 = 0;
        if(optionalAvg.isPresent()) {
            value1 = optionalAvg.getAsDouble();
            System.out.println(value1);
        } else {
            System.out.println("값이 없습니다.");
        }
//        optional객체 처리방법2.
        double value2 = studentList.stream().mapToInt(a -> a.getAge()).average().orElseThrow(() -> new NoSuchElementException("값이 없습니다."));
        System.out.println(value2);  //26.75
          */
//        optional객체 처리 실습2)
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("kim", 20));
        studentList.add(new Student("choi", 30));
        studentList.add(new Student("lee", 35));
        studentList.add(new Student("park", 22));
        System.out.println("조회하고자 하는 student의 index번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        Optional<Student> s1;  // optional객체는 원시자료형 빼고는 거의 다 담을 수 있음. wrapper자료형, 클래스 등..
        if (studentList.size() <= number || number < 0) {  //없는 회원번호나, 음수의 회원번호 입력 받을 경우
            s1 = Optional.empty();  // 비어있는 optional객체 생성
        } else {
            s1 = Optional.of(studentList.get(number));  // number데이터 들어있는 optional객체 생성
        }
        System.out.println(s1.orElseThrow(()-> new NoSuchElementException("없는 회원입니다.")));


    }
}
