package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠 {
    private static final int[][] data = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }

    public static void dfs(int row, int column) {
        if (column == 9) {
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(data[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        if (data[row][column] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, column, i)) {
                    data[row][column] = i;
                    dfs(row, column + 1);
                }
            }
            data[row][column] = 0;
            return;
        }

        dfs(row, column + 1);
    }

    public static boolean check(int row, int column, int index) {
        for (int i = 0; i < 9; i++) {
            if (data[row][i] == index) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (data[i][column] == index) {
                return false;
            }
        }

        int newRow = (row / 3) * 3;
        int newColumn = (column / 3) * 3;

        for (int i = newRow; i < newRow + 3; i++) {
            for (int j = newColumn; j < newColumn + 3; j++) {
                if (data[i][j] == index)
                    return false;
            }
        }
        return true;
    }
}
