package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의_합 {
    private static int N;
    private static int S;
    private static int count = 0;
    private static int[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        data = new int[N];

        for(int i=0; i<N; i++){
            data[i]= Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) {
            System.out.print(count-1);
        }
        else{
            System.out.print(count);
        }
    }

    private static void dfs(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(index+1, sum + data[index]);
        dfs(index+1, sum);
    }
}
