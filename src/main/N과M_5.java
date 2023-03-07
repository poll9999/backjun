package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5 {
    static int N, M;
    static int[] data;
    static int[] result;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N];
        result = new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        dfs(0);
        System.out.print(sb.toString());
    }

    public static void dfs(int index){
        if (index == M){
            for (int i=0; i<M; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++){
            if (!check[i]){
                check[i] = true;
                result[index] = data[i];
                dfs(index+1);
                check[i] = false;
            }
        }
    }
}
