package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 누울_자리를_찾아라 {
    private static int widthCount = 0;
    private static int heightCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] data = new char[101][101];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                data[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            int checkWidth = 0;
            int checkHeight = 0;
            for (int j = 0; j < N; j++) {
                if (data[i][j] == '.') {
                    checkWidth++;
                }
                if (data[i][j] == 'X' || (j == N - 1)) {
                    if (checkWidth >= 2) {
                        widthCount++;
                    }
                    checkWidth = 0;
                }

                if (data[j][i] == '.') {
                    checkHeight++;
                }
                if (data[j][i] == 'X' || (j == N - 1)) {
                    if (checkHeight >= 2) {
                        heightCount++;
                    }
                    checkHeight = 0;
                }
            }
        }

        System.out.println(widthCount + " " + heightCount);
    }
}
