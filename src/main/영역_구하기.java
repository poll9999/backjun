package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 영역_구하기 {
    private static int M;
    private static int N;
    private static int count = 0;
    private static int[][] data;
    private static final int[] sumRow = {0, 0, -1, 1};
    private static final int[] sumColumn = {-1, 1, 0, 0};
    private static final List<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        data = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            for (int j = b; j <= d; j++) {
                for (int z = a; z <= c; z++) {
                    data[j][z] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (data[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    areaList.add(count);
                }
            }
        }
        Collections.sort(areaList);

        StringBuilder sb = new StringBuilder();
        sb.append(areaList.size()).append("\n");
        for (Integer i : areaList) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }

    private static void dfs(int row, int column) {
        data[row][column] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int newRow = row + sumRow[i];
            int newColumn = column + sumColumn[i];

            if (newRow >= 0 && newRow < M && newColumn >= 0 && newColumn < N) {
                if (data[newRow][newColumn] == 0) {
                    dfs(newRow, newColumn);
                }
            }
        }
    }
}
