package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든_순열 {
    private static int N;
    private static int[] data;
    private static int[] result;
    private static boolean[] visit;
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        data = new int[N];
        result = new int[N];
        for(int i=0; i<N; i++) {
            data[i] = i+1;
        }

        visit = new boolean[N];

        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int index) {
        if (index == N) {
            for(int i=0; i<N; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if (!visit[i]) {
                result[index] = data[i]; // 방문하지 않은 수 중 i 번째 인덱스의 data 배열 값을 index 번째 result 에 저장함.
                visit[i] = true;
                dfs(index+1);
                visit[i] = false;
            }
        }
    }
}
