package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와_링크 {
    private static int N;
    private static int answer = Integer.MAX_VALUE;
    private static boolean[] visit;
    private static int[][] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        visit = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int column, int row) {
        if (column == N/2) {
            sum();
            return;
        }

        for(int i = row; i<N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(column+1, i+1);
                visit[i] = false;
            }
        }
    }

    private static void sum() {
        int startTeam = 0;
        int linkTeam = 0;
        for(int i=0; i<N-1; i++) {
            for (int j=i; j<N; j++) {
                if (visit[i] && visit[j]) {
                    startTeam = startTeam+data[i][j]+data[j][i];
                }
                if (!visit[i] && !visit[j]) {
                    linkTeam = linkTeam+data[i][j]+data[j][i];
                }
            }
        }
        answer = Math.min(answer, Math.abs(startTeam-linkTeam));
    }
}