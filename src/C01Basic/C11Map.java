package C01Basic;

import java.util.*;

public class C11Map {
    public static void main(String[] args) {
        /*
//        map : key, value로 이루어진 자료구조. 키의 중복이 없다. 순서가 없다. O(1)의 복잡도.
//        Map(String, Integer) 변수명 = new HashMap<>();
        Map<String, Integer> sports = new HashMap<>();
//        특징 : 키는 중복이 없음. value는 중복이 가능.
        sports.put("농구", 2);
        sports.put("축구", 3);
        sports.put("배구", 2);
//        sports.put("농구", 3); //키가 중복이라서 덮어쓰기가 됨
//        특징 : map의 key에는 순서가 없음
        System.out.println(sports);  //{배구=2, 농구=2, 축구=3}
//        특징 : map에서 key값을 통한 검색 복잡도는 o(1). 해시값과 해시테이블 사용(해시함수). 해시충돌 방지위해 메모리 낭비 발생 가능성.
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

//        containsKey : key가 있으면 true, 없으면 false. 제일 많이 씀.
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
//            getOrDefailt(키값, 초기값) : key값이 있으면 있는 값 리턴, 없을경우 초기값 리털. 이것도 많이 씀
//            a를 찾되, a의 키값이 있으면 myMap.get(a)리턴, 없으면 0을 리턴.
            myMap.put(i, myMap.getOrDefault(i, 0)+1);
        }

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
                if(myMap.get(b) == 1) {
                    myMap.remove(b);
                } else {
                    myMap.put(b, myMap.get(b)-1);
                }
            }
        }

//        프로그래머스 : 완주하지 못한 선수
        Map<String, Integer> myMap = new HashMap<>();
        for (String a : participant) {
            if(myMap.containsKey(a)) {
                myMap.put(a, myMap.get(a)+1);
            } else {
                myMap.put(a, 1);
            }
        }
        for (String b : completion) {
            myMap.put(b, myMap.get(b)-1);
            if (myMap.get(b) == 0) {
                myMap.remove(b);
            }
        }
        // 여기서 myMap으로 써야 함!
        for (String key : myMap.keySet()) {
            answer = key;
        }
        return answer;
//        프로그래머스 : 의상 ⭐다시 풀기
        Map<String, Integer> map = new HashMap<>();
        for(String[] a : clothes) {
            String type = a[1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }

        int answer = 1;
        for(int cnt : map.values()) {
            answer *= (cnt + 1);
        }
        return answer - 1;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
           String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0)+1);
        }  // map에 팔린것들 다 집어넣으면서 1개 이상 팔린건 카운트 올림

        int max = Integer.MIN_VALUE;
        String maxKey = "";
        List<String> myList = new ArrayList<>();
        for(String a : map.keySet()) {
            int value = map.get(a);
            if(max < value) {
                max = value;
                maxKey = a;
            }
        }  // max값 구한 for문

        for(String b : map.keySet()) {
            if(map.get(b) == max) {
                myList.add(b);
            }
        }  // max구한것에서 같은값 있는지 확인해서 myList에 담는 for문

        myList.sort(Comparator.naturalOrder()); // 오름차순 정렬
        System.out.println(myList.get(0));  /첫번쨰값 출력

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Map<String, Integer> myMap = new TreeMap<>();
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(),("."));
            st.nextToken();
            String file = st.nextToken();
            myMap.put(file, myMap.getOrDefault(file, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(String a : myMap.keySet()) {
            sb.append(a + " " + myMap.get(a) + "\n");
        }
        System.out.println(sb);

//        LinkedHashMap : 데이터 산입순서 보장(입력시간순 정렬)
        Map<String, Integer> myMap = new LinkedHashMap<>();
        myMap.put("hello5", 1);
        myMap.put("hello4", 2);
        myMap.put("hello3", 3);
        myMap.put("hello2", 4);
        myMap.put("hello1", 5);
        for(String a: myMap.keySet()) {
            System.out.println(a + " " +  myMap.get(a));  // 1 2 3 4 5
        }
     */
//        Iterator를 활용한 출력
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("야구", 2);
        myMap.put("축구", 3);
        myMap.put("농구", 2);
        Iterator<String> iters = myMap.keySet().iterator();
//        next메서드는 데이터를 하나씩 소모시키면서 값을 반환
        System.out.println(iters.next()); // 야구
//        hasNext 메서드는 iterator안에 그 다음값이 있는지 없는지 boolean 리턴
        System.out.println(iters.hasNext());  //true
        while (iters.hasNext()) {
            System.out.println(iters.next());  // 농구 축구
        }






    }
}
