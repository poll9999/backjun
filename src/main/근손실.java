package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근손실 {
    private static int N;
    private static int K;
    private static int count = 0;
    private static int[] data;
    private static int[] result;
    private static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new int[N];
        result = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);
        System.out.print(count);
    }

    private static void dfs(int index, int sum) {
        if (index == N) {
            if (sum >= 500) {
                count++;
            }
            return;
        }

        if (sum < 500) {
            return;
        }

        for (int i=0; i<N; i++) {
            if (!visit[i]) {
                result[index] = data[i];
                visit[i] = true;
                dfs(index+1, sum+result[index]-K);
                visit[i] = false;
            }
        }
    }
}