package C01Basic;

import java.util.*;

public class C10List {
    public static void main(String[] args) {
        /*
//        List선언방법1
        ArrayList<String> myList1 = new ArrayList<String>();
        ArrayList<String> myList2 = new ArrayList<>();
//        ⭐ List선언방법2 : 가장 일반적인 방법
        List<String> myList3 = new ArrayList<>();  // <>참조변수만 들어갈 수 있음

//        초기값 세팅방법1. 개별data add
        myList3.add("java");
        myList3.add("python");
        myList3.add("c++");
        System.out.println(myList3); // [java, python, c++]

//        초기값 세팅방법2. 배열을 리스트로 변환
        String[] arr = {"java", "python", "c++"};
        List<String> myList4 = new ArrayList<>(Arrays.asList(arr));

//        List의 출력
//        List등의 컬렉션프레임워크 안에는 toString 메서드가 구현되어 있고, 자동 호출되고 있다.
        System.out.println(myList4);  //[java, python, c++]

//        List의 안의 자료타입으로는 기본형타입은 쓸 수 없음.
        int[] intArr = {10,20,30};
        List<Integer> myList5 = new ArrayList<>();
        for (int i : intArr) {
            myList5.add(i);
        }

//        add : 리스트에 값을 하나씩 추가하는 메서드
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(0, 30);  //List는 중간위치에 데이터를 삽입/삭제하는 작업은 비효율적
        System.out.println(myList);  // [30, 10, 20]

//        get(index) : 특정 index의 요소 반환
        System.out.println(myList.get(2));  // 20

//        size() : 리스트의 개수(길이)를 반환
        System.out.println(myList.size());  //3

//        리스트의 값 출력 방법1. 일반for문
        for(int i=-0; i<myList.size(); i++) {
            System.out.println(myList.get(i));
        }

//        리스트의 값 출력 방법2. 향상된for문
        for(int m : myList) {
            System.out.println(m);  //향상된 for문은 인덱스로 꺼내는게 아니라 바로 값 꺼내면 됨
        }

//        remove : 값 삭제
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.remove(0); // 중간 값 삭제는 성능 저하됨
        myList.remove(myList.size()-1);  // 맨 마지막값 삭제

//        indexOf : 특정값을 찾아 index return(가장 먼저 나오는 값)
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(30);
        System.out.println(myList.indexOf(30)); // 2

//        contains : 값이 있는지 없는지 여부를 리턴. 복잡도 O(n)
        System.out.println(myList.contains(20)); //true

//        프로그래머스 : n의 배수 고르기
        List<Integer> myList = new ArrayList<>();
        for (int i : numlist) {
            if (i % n == 0) {
                myList.add(i);
            }
        }

        int[] answer = new int[myList.size()];
        for( int i=0; i<answer.length; i++) {
            answer[i] = myList.get(i);
        }

//        정렬 : 방법2가지(Collections클래스의 sort메서드 사용, 객체의 sort메서드 사용 : 두개의 복잡도(nLogN) 비슷해서 아무거나 써도 됨)
        List<Integer> myList = new ArrayList<>();
        myList.add(5);
        myList.add(3);
        myList.add(2);
        myList.add(1);
        myList.add(4);
//        Collections클래스의 sort메서드 사용
        Collections.sort(myList); // 오름차순 정렬 [1, 2, 3, 4, 5]
        Collections.sort(myList, Comparator.reverseOrder()); //내림차순 [5, 4, 3, 2, 1]
//        객체의 sort메서드 사용 : 이게 좀 더 최근에 나왔음.
        myList.sort(Comparator.naturalOrder());  //오름차순
        myList.sort(Comparator.reverseOrder()); // 내림차순

//        이중리스트 : 리스트 안의 리스트
        List<List<Integer>> myList = new ArrayList<>();  // 마이 리스트 힙메모리에 m1, m2 메모리주소를 가지고 있고, m1,m2은 따로 메모리를 가지고 있음.
        List<Integer> m1 = new ArrayList<>();
        myList.add(m1);  // [[]]
        myList.add(new ArrayList<>());  // [[], []]. 이런방식으로 list추가 많이 함.
        m1.add(1);
        m1.add(2);
        m1.add(3); // [[1,2,3], []]
        myList.get(1).add(4);
        myList.get(1).add(5);
        myList.get(1).add(6); // [[1,2,3], [4,5,6]]
        System.out.println(myList); //[[1, 2, 3], [4, 5, 6]]

//        [[1,2,3], [4,5,6], [7,8,9]..., [58,59,60]] .. 리스트 20개
//        내가 푼거
//        List<List<Integer>> myList = new ArrayList<>();
//        int num = 1;
//        for(int i=0; i<60/3 ; i++) {
//            myList.add(new ArrayList<>());
//            for(int j=0; j<3; j++) {
//                myList.get(i).add(num);
//                num++;
//            }
//        }
//        System.out.println(myList);

//        다른방법
        List<List<Integer>> myList = new ArrayList<>();
        for(int i=0; i<20; i++) {
            myList.add(new ArrayList<>());
        }
        int num = 1;
        for (int i=0; i<20; i++) {
            for (int j=0; j<3; j++) {
                myList.get(i).add(num);
                num++;
            }
        }
//        리스트 안의 배열
//        [{10,20}, {1,2,3}, {4,3,2,1}]
        List<int[]> myList = new ArrayList<>();
        int[] arr = new int[2];
        arr[0] = 10;
        arr[1] = 20;
        myList.add(arr);
        myList.add(new int[3]);
        myList.get(1)[0] =1;  // 리스트의 2번째에 선언된 배열의 인덱스 0번에 1추가
        myList.get(1)[1] =2;
        myList.get(1)[2] =3;
        myList.add(new int[]{4,3,2,1});
        System.out.println(myList);  //[[I@4c873330, [I@119d7047, [I@776ec8df] 배열의 주소값 출력
        for(int i=0; i<myList.size(); i++) {
            System.out.println(Arrays.toString(myList.get(i)));
        }
        */


    }
}
