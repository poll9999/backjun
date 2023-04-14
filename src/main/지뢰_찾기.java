package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지뢰_찾기 {
    private static final StringBuilder sb = new StringBuilder();
    private static final int[] sumRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] sumColumn = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] data = new char[N][N];
        char[][] result = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                data[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                if (data[i][j] != '.') {
                    result[i][j] = '*';
                } else {
                    for (int k = 0; k < 8; k++) {
                        if (i + sumRow[k] >= 0 && i + sumRow[k] < N && j + sumColumn[k] >= 0 && j + sumColumn[k] < N) {
                            if (data[i + sumRow[k]][j + sumColumn[k]] > '0') {
                                count += data[i + sumRow[k]][j + sumColumn[k]] - '0';
                            }
                        }

                        if (count < 10) {
                            result[i][j] = (char) (count + '0');
                        } else {
                            result[i][j] = 'M';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
