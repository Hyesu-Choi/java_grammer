package C01Basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class C09Array {
    public static void main(String[] args) {
        /*
//        배열표현식1. 배열 선언 후 값 할당 방식
//        java의 배열은 반드시 사전에 길이가 결정되어야함
//        int[] arr1 = new int[]; // 허용안됨. 길이가 결정되어야함
        int[] arr1 = new int[5];
        arr1[0] = 10;
        arr1[1] = 20;
//        int배열의 경우 선언시 기본적으로 0으로 초기화. boolean은 false로 초기화. 참조자료형은 null로 초기화.
        arr1[3] = 40;
        arr1[4] = 50;
//        arr1[5] = 60;  // ArrayIndexOutOfBoundsException 예외 발생.
        System.out.println(Arrays.toString(arr1));  //[10, 20, 0, 40, 50]

//        배열표현식2. 리터럴 방식
        int[] arr2 = {10, 20, 30, 40, 50};
//        배열표현식3. 명시적 배열 생성 방식
        int[] arr3 = new int[]{10, 20, 30, 40, 50};

//        배열표현식3.활용 예시 : 배열을 다른 메서드의 매개변수로 사용할 경우.
        List<int[]> myList = new ArrayList<>();  // 배열이랑 비슷한데 길이 결정 안해도됨.
        myList.add(new int[3]);
        myList.get(0)[0] = 10;
        myList.get(0)[1] = 20;
        myList.add({1,2,3,4,5}); // 사용 불가(배열인지 아닌지 확인불가)
        myList.add(new int[]{10, 20, 30, 40, 50}); // 이건 가능.

//        85,65,90으로 구성된 int배열을 선언하고, 총합과 평균을 구하시오  1번 아님 3번 방식으로 선언.
        int[] arr = new int[]{85, 65, 90};
        int total = 0;
        double average = 0;

        for (int i : arr) {
            total += i;
        }
        average = (double) total / arr.length;

        System.out.println(total);
        System.out.println(average);

//        배열의 최대값, 최소값
        int[] arr = {10,20,30,12,8,7};
//        최대값을 구할때는 가장 작은 값을 설정.
        int max = Integer.MIN_VALUE;  // -20억
//        최소값을 구할때는 가장 큰 값을 설정.
        int min = Integer.MAX_VALUE;  // 20억

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max ) {  // 최대값
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(max);  //30
        System.out.println(min);  //7

//        배열의 자리 바꾸기
        int[] arr = {20,10,30};
//        i, i+1 자리를 바꾼다.
        int temp = arr[0];
        arr[0] = arr[1];  // arr[0]은 없어질수도 있음 temp에 넣어두기
        arr[1] = temp;
//        배열 뒤집기
//        방법1
        int[] arr = {10,20,30,40,50};
        int[] newArr = new int[arr.length];
        int index=0;
        for(int i=arr.length-1; i>=0; i--) {
            newArr[index] = arr[i];
            index++;
        }
        System.out.println(Arrays.toString(newArr));
//        방법2
        int[] arr = {10,20,30,40,50};
        int[] newArr = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            newArr[arr.length-1-i] = arr[i];
        }
        System.out.println(Arrays.toString(newArr));

//        배열의 정렬
        String[] stArr = {"abc", "aaa","acb","abb"};
        Arrays.sort(stArr);  //오름차순 정렬
        System.out.println(Arrays.toString(stArr));  //[aaa, abb, abc, acb]
        Arrays.sort(stArr, Comparator.reverseOrder());  // 내림차순(string배열)
        System.out.println(Arrays.toString(stArr));  //[acb, abc, abb, aaa]
        int[] arr = {17,12,20,10,15};
        Arrays.sort(arr);//오름차순정렬
        System.out.println(Arrays.toString(arr));  //[10, 12, 15, 17, 20]
//        Arrays.sort(arr, Comparator.reverseOrder());  //원시자료형은 Comparator 사용 불가능. 이건 안됨.

//        선택 정렬 알고리즘 구현   ⭐이건 다시 해보기
//        구현로직 : 1)2중 for문 사용하며 index마다 최소값 찾기 2) 현재위치와 자리 change
        int[] arr = {17,12,20,10,15};
        for(int i=0; i<arr.length; i++) {
            int min = arr[i];  // 최소값 초기화
            int minIndex = i;  // 0으로 초기화하면 내가 최고값일경우 인덱스가 0으로 그대로 남아있는데 자리를 0으로 바꿔버리면 틀어질 수도 있음
            for(int j=i+1; j<arr.length; j++) { i의 +1부터 최소값을 찾는다
                if(arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
//            자리 바꾸기 : i와 index 자리 change
            int temp = arr[i];  // 잃어버릴 대상 keep
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));  // [10, 12, 15, 17, 20]
//        선택정렬의 복잡도 : O(n^2). java 기본 내장 정룔함수의 복잡도 : O(n*log(n))

//        방법2.
        int[] arr = {17,12,20,10,15};
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length;j++){
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

//        조합문제 : 모두 각기 다른 숫자의 배열이 있을 때, 만들어질 수 있는 두 숫자의 조합을 출력
//        ex) (10,20), (10,30), (10,40), (10,50), (20,30), (20,40) ....
        int[] arr = {10,20,30,40,50};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                sb.append("(" + arr[i] + "," + arr[j] + "),");
            }
        }
        System.out.println(sb);

//        배열의 중복제거 : set자료구조(중복X, 순서X-인덱스없음)활용. 중복제거 키워드 나오면 set이라는 자료구조 생각해야함
//        ex) 10,20,30,40만 남도록.
        int[] arr = {10, 30, 20, 30, 10, 40};
        Set<Integer> mySet = new HashSet<>();
        for (int a : arr) {  // arr을 하나씩 꺼내서 set에 담음(담기만하면 중복 제거됨).
            mySet.add(a);
        }
        System.out.println(mySet);  //[20, 40, 10, 30]

        int[] answer = new int[mySet.size()];  // 정렬시키기 위한 배열 만듬.
        int index = 0;  // set은 인덱스 없기 때문에 만들기 위해 변수 선언
        for (int a : mySet) {  // set은 인덱스가 없기 때문에 향상 for문 이용해야하고, 인덱스는 별도로 선언해서 임의로 만들어줘야함.
            answer[index] = a;  // 임의로 만든 index arr[index]에 myset의 중복제거된 데이터를 하나씩 넣는다
            index++;  // index는 1씩 증가시킨다
        }
        Arrays.sort(answer);  // 정렬안된 만들어진 answer를 sort 메서드를 이용해 정렬시킨다.
        System.out.println(Arrays.toString(answer));  //[10, 20, 30, 40]

//        프로그래머스 문제 : 두 개 뽑아서 더하기(조합+중복제거)
        class Solution {
            public int[] solution(int[] numbers) {
                Set<Integer> mySet = new HashSet<>();
                for (int i = 0; i < numbers.length; i++) {
                    for (int j = i + 1; j < numbers.length; j++) {
                        int num = numbers[i] + numbers[j];
                        mySet.add(num);
                    }
                }
                int[] answer = new int[mySet.size()];
                int index = 0;
                for (int i : mySet) {
                    answer[index] = i;
                    index++;
                }
                Arrays.sort(answer);
                return answer;
            }
        }

//        배열의 검색 : 복잡도 O(n)
        int[] arr = {1, 3, 6, 8, 8, 9, 11, 15};
        int target = 11;
//         targer이 몇번째 index에 있는지 출력
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }
        System.out.println(index);  //6

//        배열의 검색-이분탐색(이진검색) - binary search, 복잡도 log2(n)
//        사전에 데이터가 오름차순 정렬되어 있는 경우만, 이분탐색 가능.
        int[] arr = {1, 3, 6, 8, 8, 9, 11, 15};
        int target = 11;
        int index = Arrays.binarySearch(arr, target);
//        찾고자 하는 값이 있으면 해당 index리턴
//        찾고자 하는 값이 없으면 음수값 리턴
        int index2 = Arrays.binarySearch(arr, 13);
        int index3 = Arrays.binarySearch(arr, 8); // 8은 중복인 숫자여서 중복 제거하고 찾는게 좋다.
        System.out.println(index);  //6
        System.out.println(index2);  //-8
        System.out.println(index3);  //3이 나올수도 있고 4가 나올수도 있음. 정확한 값 찾기 어려움

//        백준 - 수 찾기(1920) 이분탐색으로 풀기
//        정렬 복잡도 : nlogn, 이분탐색 복잡도 : logn => 2 nlogn의 복잡도가 나옴
        String[] inputs = br.readLine().split(" ");  // StringTokenizer방식 말고 다른방식으로 입력값 배열에 넣는 코드
        int[] arr = new int[inputs.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(arr[i]);
        }

//        배열의 값 비교
        int[] arr1 = {10,20,30};
        int[] arr2 = {10,20,30};
        System.out.println(arr1==arr2);  // false
        System.out.println(Arrays.equals(arr1, arr2)); //true

//        배열 복사
//        Arrays.copyOf(배열명, length) : 0부터 l미만까지 복사
//        Arrays.copyOfRange(배열명, n, m) : n+1부터 m미만까지 복사
        int[] arr={1,4,6,7,8,1,2,4,6};
        int[] arr1 = Arrays.copyOf(arr, 4);
        System.out.println(Arrays.toString(arr1));  //[1, 4, 6, 7]
        int[] arr2 = Arrays.copyOfRange(arr, 3, 6);
        System.out.println(Arrays.toString(arr2));  //[7, 8, 1]

//        Arrays.fill : 배열에 모든값을 변경(채우기)
        String[] arr = new String[5];
        // for문방식
        for(int i=0; i<arr.length; i++) {
            arr[i] = "";
        }
        // fill 메소드 사용
        Arrays.fill(arr, "");
//        2차원배열의 선언과 값 할당
//        방법1. 선언 후 할당 방식
        int[][] arr1 = new int[3][2];
        arr1[0][0] = 1;
        arr1[0][1] = 2;
        arr1[1][0] = 1;
//        방법2. 리터럴방식
        int[][] arr2 = {{1, 2}, {1, 2}, {1, 2}};

//        [3][4] 사이즈의 2차원배열을 선언하고, 1~12까지의 숫자값을 각 배열에 순차적으로 할당
        int[][] arr = new int[3][4];
        int num = 1;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = num;
                num++;
            }
        }
//        2차원 배열의 출력 : Arrays.deepToString(arr)
        System.out.println(arr); // 2차원배열의 heap 메모리의 주소값. [[I@4c873330
        System.out.println(Arrays.toString(arr));  // 각 1차원배열의 heap주소값. [[I@119d7047, [I@776ec8df, [I@4eec7777]
        System.out.println(Arrays.deepToString(arr));  // 각 1차원배열의 값을 출력. [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]

//        프로그래머스 - 행렬의 덧셈
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(answer));
        return answer;

//        프로그래머스 - k번째수
        class Solution {
            public int[] solution(int[] array, int[][] commands) {
                int[] answer = new int[commands.length];
                for (int i = 0; i < commands.length; i++) {
                    int a = commands[i][0] - 1; // 실제 인덱스를 준게 아니라서 -1빼야함. 컴퓨터 인덱스는 0부터 시작하니까
                    int b = commands[i][1];
                    int c = commands[i][2] - 1;

                    int[] arr1 = Arrays.copyOfRange(array, a, b);
                    Arrays.sort(arr1);

                    answer[i] = arr1[c];
                }
                return answer;
            }
        }
//        가변배열 : 2차원 배열에서 각 1차원의 배열의 길이가 서로 다를 수 있는 배열의 구조
        int[][] arr1 = {{1,2}, {1,2,3}, {1,2,3,4}};
//        배열 전체길이는 반드시 사전할당되어야하지만, 1차원배열의 길이는 추후 할당 가능.
        int[][] arr2 = new int[3][];
        arr2[0] = new int[2];
        arr2[1] = new int[3];
        arr2[2] = new int[4];
         */


    }
}
