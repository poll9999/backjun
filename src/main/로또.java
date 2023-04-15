package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
    private static int K;
    private static int[] data;
    private static boolean[] visit;
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            if (K==0){
                break;
            }

            data = new int[K];
            visit = new boolean[K];

            for(int i=0; i<K; i++){
                data[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);
        System.exit(0);
    }

    private static void dfs(int index, int start) {
        if (index == 6) {
           for(int i=0; i<K; i++) {
               if (visit[i]) {
                   sb.append(data[i]).append(" ");
               }
           }
            sb.append("\n");
        }

        for(int i=start; i<K; i++) {
            visit[i] = true;
            dfs(index + 1, i+1);
            visit[i] = false;
        }
    }
}
