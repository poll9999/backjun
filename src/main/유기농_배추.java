package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import org.w3c.dom.ls.LSOutput;

public class 유기농_배추 {
    private static int T;
    private static int M;
    private static int N;
    private static int K;
    private static int count;
    private static int[][] data;
    private static boolean[][] visit;
    private static final int[] sumRow = {0, 0, -1, 1};
    private static final int[] sumColumn = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            data = new int[M][N];
            visit = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int firstIndex = Integer.parseInt(st.nextToken());
                int secondIndex = Integer.parseInt(st.nextToken());
                data[firstIndex][secondIndex] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (data[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int row, int column) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row, column});
        visit[row][column] = true;

        while (!que.isEmpty()) {
            int a = que.peek()[0];
            int b = que.peek()[1];
            que.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = a + sumRow[i];
                int newColumn = b + sumColumn[i];

                if (newRow >= 0 && newRow < M && newColumn >= 0 && newColumn < N) {
                    if (data[newRow][newColumn] == 1 && !visit[newRow][newColumn]) {
                        que.add(new int[]{newRow, newColumn});
                        visit[newRow][newColumn] = true;
                    }
                }
            }
        }
    }
}
