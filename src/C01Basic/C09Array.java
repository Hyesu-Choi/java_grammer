package C01Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            if(arr[i] > max ) {
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
                 */


    }
}
