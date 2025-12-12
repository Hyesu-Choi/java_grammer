package C01Basic;

import java.util.*;

public class C11Map {
    public static void main(String[] args) {
        /*
//        map : key, value로 이루어진 자료구조. 키의 중복이 없다. 순서가 없다.
//        Map(String, Integer) 변수명 = new HashMap<>();
        Map<String, Integer> sports = new HashMap<>();
//        특징 : 키는 중복이 없음. value는 중복이 가능.
        sports.put("농구", 2);
        sports.put("축구", 3);
        sports.put("배구", 2);
//        sports.put("농구", 3); //키가 중복이라서 덮어쓰기가 됨
//        특징 : map의 key에는 순서가 없음
        System.out.println(sports);  //{농구=2, 배구=2, 축구=3}
//        특징 : map에서 key값을 통한 검색 복잡도는 o(1).
        System.out.println(sports.get("배구"));  //2

//        map의 전체 value 데이터 출력
//        map의 key값 접근시에는 인덱스 사용 불가능(순서가 없음) :for문 불가
//        keySet() : map의 전체 key목록을 반환하는 메서드
        for(String a : sports.keySet()) {
            System.out.print("키:" + a + "value:" +sports.get(a)); // 키:농구value:2 키:배구value:2 키:축구value:3223
        }

//        values() : map의 전체 value 목록을 반환하는 메서드(잘 안쓰임)
        for(int a :sports.values()) {
            System.out.print(a);  //2 2 3
        }

        Map<String, Integer> sports = new HashMap<>();
        sports.put("축구", 2);
        sports.put("농구", 3);
        sports.put("배구", 2);

//        remove : key를 통해 map 요소 삭제
        sports.remove("축구");
        System.out.println(sports);  //{농구=3, 배구=2}

//        putIfAbsent : key값이 업는 경우에만 put
        sports.putIfAbsent("배구", 10);
        System.out.println(sports);  // {농구=3, 배구=2} 덮어쓰기 안됨

//        containsKey : key가 있으면 true, 없으면 false
        System.out.println(sports.containsKey("배구")); //true
        System.out.println(sports.containsKey("탁구")); //false

//        map을 통한 개수 count
//        담으려고 하는 key가 있으면 기존것+1
//        key가 없으면 (key,1)로 세팅
        String[] arr = {"농구", "축구", "농구", "야구", "축구"}; // 농구:2, 야구:1, 축구:2
        Map<String, Integer> myMap = new HashMap<>();

        for (String i : arr) {
//            if (myMap.containsKey(i)) {
//                myMap.put(i, myMap.get(i) + 1);
//            } else {
//                myMap.put(i, 1);
//            }  // 이 위에 코드를 아래로 간단하게 표현할 수 있다.
//            getOrDefailt(키값, 초기값) : key값이 있으면 있는 값 리턴, 없을경우 초기값 리털
//            a를 찾되, a의 키값이 있으면 myMap.get(a)리턴, 없으면 0을 리턴.
            myMap.put(i, myMap.getOrDefault(i, 0)+1);
        }
        System.out.println(myMap);

//        map의 value값 감소 로직
        String[] arr = {"농구", "축구", "농구", "야구", "축구"};
        String[] arr2 = {"농구", "농구", "농구", "야구", "축구"}; // 농구3, 야구1, 축구1
        Map<String, Integer> myMap = new HashMap<>();
        for (String a : arr) {
            if (myMap.containsKey(a)) {
                myMap.put(a, myMap.get(a) + 1);
            } else {
                myMap.put(a, 1);
            }
        }
        for(String b : arr2) {
            if(myMap.containsKey(b)) {
                if(myMap.get(b) ==1) {
                    myMap.remove(b);
                } else {
                    myMap.put(b, myMap.get(b)-1);  // 아 put메서드로 업데이트 쳐야하는군.. remove로 하고있었음.. remove는 키랑 값 같이 지우는 메서드임..
                }
            }
        }
        System.out.println(myMap);

//        프로그래머스 : 완주하지 못한 선수.. 다품
//        프로그래머스 : 의상 ⭐다시 풀기

//        가장 value가 큰 key값 찾기
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("축구", 3);
        myMap.put("농구", 2);
        myMap.put("야구", 1);

        int max = Integer.MIN_VALUE;
        String maxKey = "";
        for(String a : myMap.keySet()) {
            int value = myMap.get(a);
            if(max < value) {
                max = value;
                maxKey = a;
            }
        }
        System.out.println(maxKey);  //축구

//        백준 : 베스트셀러  ⭐다시 풀기
//        맥스 value를 구한다(for문)
//        해당 맥스  value를 갖는 key를 구한다. 모드 list에 더한다. (for문)
//        list를 정렬한다. .0번째 값 출력
          */
//        TreeMap : key를 정렬(오름차순)하여 map을 저장
        Map<String, Integer> myMap = new TreeMap<>(); //오름차순
        Map<String, Integer> myMap2 = new TreeMap<>(Comparator.reverseOrder());  // 내림차순

        myMap.put("hello5", 1);
        myMap.put("hello4", 2);
        myMap.put("hello3", 3);
        myMap.put("hello2", 4);
        myMap.put("hello1", 5);
        System.out.println(myMap);  //{hello1=5, hello2=4, hello3=3, hello4=2, hello5=1}

//        백준 : 파일정리








    }
}
