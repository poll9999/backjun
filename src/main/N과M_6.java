package main;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_6 {
    public static int N, M;
    public static int[] data;
    public static int[] memory;
    public static boolean[] visit;

    public static void dfs(int startCount, int count){
        if (count == M){
            for (int i=0; i<M; i++){
                System.out.print(memory[i]+" ");
            }
            System.out.println();
        }

        else{
            for (int i=startCount; i<N; i++){
                if(!visit[i]){
                    visit[i]=true;
                    memory[count]=data[i];
                    dfs(i+1, count+1);
                    visit[i]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        data = new int[N];
        visit = new boolean[N];
        memory = new int[M];

        for(int i=0; i<N; i++){
            data[i]=sc.nextInt();
        }

        Arrays.sort(data);

        dfs(0, 0);
    }
}
