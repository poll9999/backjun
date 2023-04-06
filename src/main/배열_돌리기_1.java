package main;

import java.util.*;
import java.io.*;

public class 배열_돌리기_1 {
    private static int N;
    private static int M;
    private static int minValue;
    private static int[][] data;
    private static final int[] sumRow = {0, 1, 0, -1};
    private static final int[] sumColumn = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        minValue = Math.min(N, M);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= R; i++) {
            rotate();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void rotate() {
        for (int K = 0; K < minValue / 2; K++) {
            int row = K;
            int column = K;
            int temp = data[row][column];
            int index = 0;

            while (index < 4) {
                int newRow = row + sumRow[index];
                int newColumn = column + sumColumn[index];

                if (newRow < N - K && newColumn < M - K && newRow >= K && newColumn >= K) {
                    data[row][column] = data[newRow][newColumn];
                    row = newRow;
                    column = newColumn;
                } else {
                    index++;
                }
            }
            data[K + 1][K] = temp;
        }
    }
}
