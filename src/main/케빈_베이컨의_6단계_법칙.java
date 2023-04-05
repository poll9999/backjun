package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈_베이컨의_6단계_법칙 {
    private static int N;
    private static int minIndex;
    private static int minKevin = Integer.MAX_VALUE;
    private static int[][] data;
    private static boolean[] visit;
    private static final List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        data = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            data[a][b] = 1;
            data[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            bfs(i);
        }

        for (int i = 0; i < result.size(); i++) {
            if (minKevin > result.get(i)) {
                minKevin = result.get(i);
                minIndex = i + 1;
            }
        }

        System.out.print(minIndex);
    }

    private static void bfs(int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{index, 0});
        visit[index] = true;
        int kevin = 0;

        while (!queue.isEmpty()) {
            int a = queue.peek()[0];
            int b = queue.peek()[1];
            kevin += b;
            queue.poll();

            for (int i = 1; i <= N; i++) {
                if (data[a][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.offer(new int[]{i, b + 1});
                }
            }
        }

        result.add(kevin);
    }
}
