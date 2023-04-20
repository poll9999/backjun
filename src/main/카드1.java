package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드1 {
    private static final StringBuilder sb = new StringBuilder();
    private static final Queue<Integer> data = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            data.offer(i);
        }

        while (data.size() > 1) {
            sb.append(data.poll()).append(" ");
            data.offer(data.poll());
        }
        sb.append(data.poll());

        System.out.print(sb);
    }
}
