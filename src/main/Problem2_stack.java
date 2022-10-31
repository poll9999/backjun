package onboarding;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Problem2_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Deque<Character> deque = new LinkedList<>();
        deque.add((char) 0);
        for(int i = 0; i < s.length(); i++) {
            if (deque.peekLast() == s.charAt(i)) {
                // 맨 뒤에 남아있는 애랑 같은 놈이 들어오면 2개 연속 같은 게 되는거니까 뺀다.
                // peek : 해당 위치를 그냥 찾아보는것
                // poll : pop의 역할, 빼는 것
                deque.pollLast();
            }
            else {
                // 맨 뒤랑 다르면 연속으로 같지 않은거니까 더한다.
                // add 또는 offer : 넣는거
                deque.add(s.charAt(i));
            }
        }
        // 예외처리 안 하기위해 넣어놓은 놈을 뺀다.
        deque.pollFirst();
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        System.out.print(sb.toString());
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(usedMemory+"bytes");
    }
}