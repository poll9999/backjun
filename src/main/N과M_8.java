package main;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_8 {
    public static int N, M;
    public static int[] data;
    public static int[] memory;
    public static boolean[] visit;
    public static StringBuilder sb=new StringBuilder();
    public static void dfs(int startCount, int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(memory[i]+" ");
            }
            sb.append("\n");
        }
        else{
            for (int i=startCount; i<N; i++){
                memory[count] = data[i];
                dfs(i, count+1);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        data = new int[N];
        memory = new int[M];

        for(int i=0; i<N; i++){
            data[i]=sc.nextInt();
        }

        Arrays.sort(data);

        dfs(0, 0);
        System.out.println(sb);
    }
}
