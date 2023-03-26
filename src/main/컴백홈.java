package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컴백홈 {
    private static int R, C, K;
    private static int count = 0;
    private static boolean[][] visit;
    private static final int[] sumRow = {-1, 0, 1, 0};
    private static final int[] sumColumn = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char[][] data = new char[R+1][C+1];
        visit = new boolean[R+1][C+1];

        for(int i=1; i<=R; i++) {
            String string = br.readLine();
            for(int j=1; j<=C; j++) {
                data[i][j] = string.charAt(j-1);
                if (data[i][j] == 'T') {
                    visit[i][j] = true;
                }
            }
        }
        visit[R][1] = true;

        dfs(R, 1, 1);
        System.out.print(count);
    }

    private static void dfs(int row, int column, int index) {
        if (row == 1 && column == C) {
            if (index == K){
                count++;
            }
            return;
        }

        for(int i=0; i<4; i++) {
            int newRow = row + sumRow[i];
            int newColumn = column + sumColumn[i];

            if (1 <= newRow && newRow <= R && 1 <= newColumn && newColumn <= C) {
                if (!visit[newRow][newColumn]) {
                    visit[newRow][newColumn] = true;
                    dfs(newRow, newColumn, index+1);
                    visit[newRow][newColumn] = false;
                }
            }
        }
    }
}
