package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
    private static int R;
    private static int C;
    private static int maxCount = 0;
    private static int[][] data;
    private static final boolean[] visit = new boolean[26];
    private static final int[] sumRow = {-1, 0, 1, 0};
    private static final int[] sumColumn = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                data[i][j] = s.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);
        System.out.print(maxCount);
    }

    private static void dfs(int count, int row, int column) {
        if (visit[data[row][column]]) {
            maxCount = Math.max(maxCount, count);
            return;
        }

        visit[data[row][column]] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + sumRow[i];
            int newColumn = column + sumColumn[i];

            if (newRow >= 0 && newColumn >= 0 && newRow < R && newColumn < C) {
                dfs(count + 1, newRow, newColumn);
            }
        }

        visit[data[row][column]] = false;
    }
}
