package C05AnonymousLambda;

import java.util.*;

public class C03ComparatorComparable {
    public static void main(String[] args) {
//        java에서는 비교를 위한 인터페이스 대표적으로 2개 제공
//        1. Comparator 인터페이스 : 인터페이스 내에 compareTo 메서드만 존재
//        2. Comparable 인터페이스 : 인터페이스 내에 compare 메서드만 존재
        List<Integer> myList = new ArrayList<>();
        myList.add(20);
        myList.add(10);
        myList.add(30);
//        java의 대부분의 정렬함수는 매개변수로 Comparator객체 요구.
        myList.sort(Comparator.naturalOrder());
//        o1과 o2의 숫자값을 마이너스 형식으로 코딩을 하되, o1이 먼저 있으면(o1-o2 / o1.compareTo(o2):문자) 오름차순. o2가 먼저 있으면(o2-o1, o2.compareTo(o1)) 내림차순
        myList.sort((o1, o2) -> o1 - o2);

        List<String> myList2 = new ArrayList<>();
        myList2.add("java");
        myList2.add("python");
        myList2.add("c++");
//        문자비교 compareTo()  // 음, 양, 0 리턴
//        기본적인 문자열정렬일때는 Comparator커스텀을 하지 않고, 복잡한 자신만의 정렬기준을 가지고 정렬해야 할때 Comparator 익명객체 생성.
        Collections.sort(myList2, (o1, o2) -> o1.length() - o2.length());
        System.out.println(myList2);  //[c++, java, python]

//        예시 : 문자열의 길이로 정렬하되, 문자열의 길이가 같은 경우에는 알파벳순으로 정렬
        Collections.sort(myList2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                   return o1.compareTo(o2);
                } else{
                    return o1.length() - o2.length();
                }
            }
        });


//        배열, 리스트 정렬 외에 java의 그 외 정렬자료구조
        Queue<String> pq = new PriorityQueue<>((o1, o2) -> o1.length() - o2.length());
        Set<String> treeSet = new TreeSet<>((o1, o2) -> o1.length() - o2.length());

//        백준 : 단어정렬  ⭐풀어보기
//        백준 : 최대값힙 ⭐풀어보기
//        백준 : 선긋기 ⭐풀어보기..못풀면 포기해도됨..골드임..
//        백준 : 카테고리 정렬 많이 풀어봐야함..










    }
}
