package C01Basic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class C12Set {
    public static void main(String[] args) {
        /*
//        Set의 특성 : 중복X, 순서보장X, 성능 O(1)
        Set<String> mySet = new HashSet<>();
        mySet.add("야구");
        mySet.add("농구");
        mySet.add("야구");
        mySet.add("축구");
        System.out.println(mySet);  //[야구, 농구, 축구]
        System.out.println(mySet.contains("야구")); //true. O(1)의 복잡도

//        백준 : 수 찾기(1920)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);

//        TreeSet : 데이터를 오름차순 정렬
        Set<String> mySet2 = new TreeSet<>();
        mySet2.add("야구");
        mySet2.add("농구");
        mySet2.add("야구");
        mySet2.add("축구");
        System.out.println(mySet2);  //[농구, 야구, 축구]

//        백준 : 숫자카드(10815)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);

//        프로그래머스 : 폰켓몬(종류)
        Set<Integer> set = new HashSet<>();
        for(int a : nums) {
            set.add(a);
        }
        int monNums = set.size();
        int maxMon = nums.length/2;
        int answer = 0;
        if( monNums < maxMon) {
            answer = monNums;
        } else {
            answer = maxMon;
        }
        return answer;

//        집합관련 함수 : 교집합(retailAll), 합집합(addAll), 차집합(removeAll)
        Set<String> s1 = new HashSet<>();
        s1.add("java");
        s1.add("python");
        s1.add("c++");
        Set<String> s2 = new HashSet<>();
        s2.add("java");
        s2.add("html");
        s2.add("css");
        s1.retainAll(s2);  // s1에는 교집합인 java만 남음
        System.out.println(s1);  //[java]
        s1.addAll(s2); // s1에는 합집합인 java, python, c++, html, css 가 남음
        System.out.println(s1);  //[css, java, html]
        s1.removeAll(s2); // s1에는 차집합인 python, c++이 남음.
        System.out.println(s1); // [python, c++]
 */









    }
}
