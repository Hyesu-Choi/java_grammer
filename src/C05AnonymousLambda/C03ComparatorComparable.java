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
        myList2.sort((o1, o2) -> o1.length() - o2.length()); // 길이로 정렬
        System.out.println(myList2);  //[c++, java, python]

//        예시 : 문자열의 길이로 정렬하되, 문자열의 길이가 같은 경우에는 알파벳순으로 정렬
        myList2.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length() == b.length()) { // 길이가 같으면
                    return a.compareTo(b);  // 오름차순
                } else {
                    return a.length() - b.length(); // 길이 다르면 길이 기준 정렬
                }
            }
        });

//        배열, 리스트 정렬 외에 java의 그 외 정렬자료구조
        Queue<String> pq = new PriorityQueue<>((o1, o2) -> o1.length() - o2.length());
        Set<String> treeSet = new TreeSet<>((o1, o2) -> o1.length() - o2.length());

//        백준 : 단어정렬  ⭐풀어보기
//        백준 : 절대값 힙 ⭐풀어보기
//        백준 : 선긋기 ⭐풀어보기..못풀면 포기해도됨..

//        리스트 안의 배열 정렬
//        [{4,5}, {1,2}, {5,0}, {3,1}]
//        리스트안의 배열에 1번째 index를 기준으로 오름차순 정렬
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{4, 5});
        list.add(new int[]{1, 2});
        list.add(new int[]{5, 0});
        list.add(new int[]{3, 1});
        list.sort((o1, o2) -> o1[1] - o2[1]);
        for (int[] a : list) {
            System.out.println(Arrays.toString(a));
        }

//       직접 만든 객체 정렬
//        방법1. Comparator를 구현한 익명객체 방식
       List<Student> students = new ArrayList<>();
        students.add(new Student("홍길동", 30));
        students.add(new Student("홍길동2", 20));
        students.add(new Student("홍길동3", 70));
        students.add(new Student("홍길동4", 42));
        students.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));  // 이름순 정렬

//        방법2. Comparable을 구현한 방식
//        Student 객체 안에 Comparable을 implements 하는 방식
//        sort실행시 자동으로 Student 안의 compareTo메서드 호출
        Collections.sort(students);

    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    Comparable의 compareTo에서는 this와 매개변수로 주어지는 객체와 비교
//    this가 앞에 있으면 오름차순, 매개변수객체가 앞에 있으면 내림차순
    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}


//방법1 : comparator방식 구현에 사용
//class Student {
//    private String name;
//    private int age;
//
//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public String toString() {
//        return "{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}