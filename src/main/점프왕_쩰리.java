package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프왕_쩰리 {
    private static int N;
    private static int[][] data;
    private static boolean[][] visit;
    private static int[] right = {0, 1}, down = {1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println("Hing");

    }

    private static void dfs(int a, int b) {
        if(data[a][b] == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for (int i = 0; i < right.length; i++) {
            int x = a + right[i] * data[a][b];
            int y = b + down[i] * data[a][b];
            if(x>=N || y>=N || visit[x][y])
                continue;
            visit[x][y] = true;
            dfs(x, y);
        }
    }
}