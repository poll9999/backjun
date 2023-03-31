package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
    private static int count = 0;
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final boolean[][] visit = new boolean[101][101];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] data = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = data[i][0]; j < data[i][0] + 10; j++) {
                for (int k = data[i][1]; k < data[i][1] + 10; k++) {
                    if (!visit[j][k]) {
                        visit[j][k] = true;
                        count++;
                    }
                }
            }
        }
        System.out.print(count);
    }
}
