package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_10 {
    public static int N, M;
    public static int[] data, memory;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N];
        memory = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int startCount, int count) {
        if (count == M) {
            for (int a : memory) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = startCount; i < N; i++) {
            int a = data[i];
            if (before == a || visit[i]) continue;
            else {
                visit[i] = true;
                memory[count] = data[i];
                before = a;
                dfs(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
}