package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 단지번호붙이기 {
    private static int N;
    private static int count = 0;
    private static boolean[][] visit;
    private static int[][] data;
    private static final int[] sumRow = {0, 0, 1, -1};
    private static final int[] sumColumn = {1, -1, 0, 0};
    private static final int[] apartNumber = new int[25 * 25];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        data = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                data[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (data[i][j] == 1 && !visit[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        Arrays.sort(apartNumber);
        System.out.println(count);

        for (int num : apartNumber) {
            if (num != 0) {
                System.out.println(num);
            }
        }
    }

    private static void bfs(int row, int column) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row, column});
        visit[row][column] = true;
        apartNumber[count]++;

        while (!que.isEmpty()) {
            int a = que.peek()[0];
            int b = que.peek()[1];
            que.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = a + sumRow[i];
                int newColumn = b + sumColumn[i];

                if (newRow >= 0 && newRow < N && newColumn >= 0 && newColumn < N) {
                    if (data[newRow][newColumn] == 1 && !visit[newRow][newColumn]) {
                        que.add(new int[]{newRow, newColumn});
                        visit[newRow][newColumn] = true;
                        apartNumber[count]++;
                    }
                }
            }
        }
    }

    private static void dfs(int row, int column) {
        visit[row][column] = true;
        apartNumber[count]++;

        for (int i = 0; i < 4; i++) {
            int newRow = row + sumRow[i];
            int newColumn = column + sumColumn[i];

            if (newRow >= 0 && newRow < N && newColumn >= 0 && newColumn < N) {
                if (data[newRow][newColumn] == 1 && !visit[newRow][newColumn]) {
                    dfs(newRow, newColumn);
                }
            }
        }
    }
}
