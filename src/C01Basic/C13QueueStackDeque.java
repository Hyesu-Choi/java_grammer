package C01Basic;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C13QueueStackDeque {
    public static void main(String[] args) {
        /*
//        Queue인터페이스를 Linkedlist를 구현한 아래와 같은 방식으로 가장 많이 사용
        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(10);  // add: 값 뒤에 추가
        myQue.add(20);
        myQue.add(30);
//        poll : 큐에서 가장 앞의 데이터를 삭제하면서, 동시에 return하는 메서드
        int value = myQue.poll();
        System.out.println(value);  //10
        System.out.println(myQue);  //[20, 30]
//        peek : 큐에서 데이터를 삭제하지 않고, 가장 앞의 데이터를 return하는 메서드
        int value2 = myQue.peek();
        System.out.println(value2);  //20
        System.out.println(myQue);  //[20, 30]

//        while문을 통한 queue 출력 방식
        Queue<String> printerQueue = new LinkedList<>();
        printerQueue.add("문서1");
        printerQueue.add("문서2");
        printerQueue.add("문서3");
        printerQueue.add("문서4");
//        큐는 일반적으로 while문을 통해 요소를 소모..외우기
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }

//        LinkedList와 ArrayList 성능차이 비교
//        ArrayList 장점 : 조회성능 빠름, 단점 : 중간 삽입/삭제 성능 저하
//        LinkedList 장점 : 중간 삽입/삭제 성능 빠름, 단점 : 조회성능 저하
        LinkedList<Integer> myLinkedList = new LinkedList<>(); //체인기반
        long startTime = System.currentTimeMillis();
        for(int i=0; i<1000000; i++) {
            myLinkedList.add(0, i);  //On의 복잡도
        }
        long endTime = System.currentTimeMillis();
        System.out.println("linkedList에 중간에 값 add시에 소요시간: " + (endTime-startTime));  //132

        ArrayList<Integer> myArrayList = new ArrayList<>(); //인덱스기반
        long startTime2 = System.currentTimeMillis();
        for(int i=0; i<1000000; i++) {
            myArrayList.add(0, i);  // On2의 복잡도
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("ArrayList에 중간에 값 add시에 소요시간: " + (endTime2-startTime2));  //53532

//        관련문제 : 백준 카드2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();

        for(int i=0; i<N; i++) {
            que.add(i+1);
        }
        while (que.size() >1) {
            que.poll();
            que.add(que.poll());
        }
        System.out.println(que.peek());

//        관련문제 : 요세푸스 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            que.add(i+1);
        }
        while(que.size() > 1 ) {
            for(int i=0; i<K-1; i++) {  //n-1까지 뒤에 집어넣기
                que.add(que.poll());
            }
            sb.append(que.poll()).append(", ");  // 마지막값은 sb에 넣기
        }
        sb.append(que.poll());

        System.out.println("<" + sb + ">");

//        길이제한큐
        Queue<String> blockingQueue = new ArrayBlockingQueue<>(3);  //최대 3 집어넣을 수 있음
//        blockingQueue.add("문서1");
//        blockingQueue.add("문서2");
//        blockingQueue.add("문서3");
//        blockingQueue.add("문서4"); // 길이 초과시 에러 발생 : IllegalStateException: Queue full
        blockingQueue.offer("문서1");
        blockingQueue.offer("문서2");
        blockingQueue.offer("문서3");
        blockingQueue.offer("문서4");  //제한된 길이까지만 insert, 에러발생X
        System.out.println(blockingQueue); //[문서1, 문서2, 문서3]

//        우선순위 큐 : 데이터를 poll할때 정렬된 데이터의 결과값(최소값/최대값) 보장
//        지속적으로 데이터가 추가/제거 되면서 전체 데이터가 실시간으로 변경되는 상황에 사용.
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(20);
        pq.add(10);
        pq.add(40);
        pq.add(50);
        while (!pq.isEmpty()) {
//            poll할때마다 최소값을 추출하게 되고, 복잡도 log(n). peek은 최소값을 확인만 하고 추출은X. 복잡도 log(n)
//            전체 데이터를 모두 poll하면 복잡도 n*log(n)
            System.out.println(pq.poll());  //10,20,30,40,50
        }

//        백준 : 최소합
//        0이 아닌값이면 넣고, 0이면 꺼낸다. 배열이 비어있으면 0출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(num);
            }
        }
        System.out.println(sb);

//        프로그래머스 : 더 맵게
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = 0;
        Queue<Integer> dq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            dq.add(scoville[i]);
        }
        while (dq.peek() < K) {
            if (dq.size() == 1) {
                return -1;
            }
            dq.add(dq.poll() + (dq.poll() * 2));
            answer++;
        }
        return answer;

//        프로그래머스 : 최대힙 : poll할때마다 최대값을 추출 ⭐풀기
        Queue<Integer> dq2 = new PriorityQueue<>(Comparator.reverseOrder());

//        Stack : 후입선출의 자료구조
        Stack<Integer> myStack = new Stack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
//        pop : 가장 마지막에 입력한 값을 꺼내면서 제거
        System.out.println(myStack.pop()); // 30
//        peek : 가장 마지막에 입력한 값을 확인
        System.out.println(myStack.peek()); // 20
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());

//        프로그래머스 : 올바른 괄호
        boolean answer = true;

        Stack<Character> myStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                myStack.push(c);
            }
            if (c == ')') {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                } else {
                    return false;
                }
            }
        }
        return myStack.isEmpty() ? true : false;

//        프로그래머스 : 같은 숫자는 싫어
        Stack<Integer> myStack = new Stack<>();
        for (int num : arr) {
            if (myStack.isEmpty() || myStack.peek() != num) { //공백일 경우 집어넣고, 연속숫자가 안되기 떄문에 앞에 추가된거 비교해서 같지 않으면 넣기
                myStack.push(num);
            }
        }
        int[] answer = new int[myStack.size()];
        for (int i = 0; i < myStack.size(); i++) {
            answer[i] = myStack.get(i);
        }
   */
//        Deque : addFirst, addLast, pollFirst, pollLast, peekFirst, peekLast
        Deque<Integer> myDeque = new ArrayDeque<>();
        myDeque.addLast(10);
        myDeque.addLast(20);
        myDeque.addFirst(30); //[30, 10, 20]
        System.out.println(myDeque.pollLast());  //20
        System.out.println(myDeque.pollFirst());  //30
        System.out.println(myDeque.peekFirst());  //0


    }
}
