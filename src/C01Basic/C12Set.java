package C01Basic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class C12Set {
    public static void main(String[] args) {
//        Set의 특성 : 중복X, 순서보장X, 성능 O(1)
        Set<String> mySet = new HashSet<>();
        mySet.add("야구");
        mySet.add("농구");
        mySet.add("야구");
        mySet.add("축구");
        System.out.println(mySet);  //[야구, 농구, 축구]
        System.out.println(mySet.contains("야구")); //true. O(1)의 복잡도

//        백준 : 수 찾기(1920) -> ⭐ 다시 풀어보기(set을 활용해서)

//        TreeSet : 데이터를 오름차순 정렬
        Set<String> mySet2 = new TreeSet<>();
        mySet2.add("야구");
        mySet2.add("농구");
        mySet2.add("야구");
        mySet2.add("축구");
        System.out.println(mySet2);  //[농구, 야구, 축구]

//        ⭐ 주말에 풀어보기(set을 활용해서)
//        백준 : 숫자카드(10815)
//        프로그래머스 : 폰켓몬


    }
}
