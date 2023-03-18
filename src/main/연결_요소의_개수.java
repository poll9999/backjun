package main;

import java.io.IOException;
import java.util.Scanner;

public class 연결_요소의_개수 {
    private static int[][] data;
    private static boolean[] visit;
    private static int N;
    private static int M;

    private static void dfs(int a) {
        visit[a] = true;
        for(int i = 1; i <= N; i++) {
            if(data[a][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        data = new int[1001][1001];
        visit = new boolean[1001];

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            data[a][b] = 1;
            data[b][a] = 1;
        }

        int count = 0;

        for(int i = 1; i <= N; i++) {
            if(!visit[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.print(count);
    }
}