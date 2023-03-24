package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 로마_숫자_만들기 {
    private static int N;
    private static int count = 0;
    private static final int[] data = new int[]{1, 5, 10, 50};
    private static final boolean[] visit = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0, 0, 0);

        System.out.print(count);
    }

    private static void dfs(int index, int start, int sum) {
        if (index == N) {
            if (!visit[sum]) {
                visit[sum] = true;
                count++;
            }
            return;
        }

        for(int i=start; i<4; i++) {
            dfs(index+1, i, sum+data[i]);
        }
    }
}
