package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선발_명단 {
    private static int totalMax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            boolean[] visit = new boolean[11];
            totalMax = Integer.MIN_VALUE;
            int[][] data = new int[11][11];
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(visit, data, 0, 0);
            System.out.println(totalMax);
        }
    }

    private static void dfs(boolean[] newVisit, int[][] newData, int index, int max) {
        if (index == 11) {
            totalMax = Math.max(max, totalMax);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (newData[index][i] != 0 && !newVisit[i]) {
                newVisit[i] = true;
                dfs(newVisit, newData, index + 1, max + newData[index][i]);
                newVisit[i] = false;
            }
        }
    }
}
