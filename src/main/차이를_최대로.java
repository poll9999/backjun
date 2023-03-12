package main;

import java.util.Scanner;

public class 차이를_최대로{
    public static int N;
    public static int[] data;
    public static int[] memory;
    public static boolean[] visit;
    public static int answer;

    public static void dfs(int count){
        if(count == N) {
            int sum = 0;
            for(int i = 0; i < N -1; i++) {
                sum += Math.abs(memory[i] - memory[i+1]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visit[i]){
                memory[count] = data[i];
                visit[i] = true;
                dfs(count + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        data = new int[N];
        memory = new int[N];
        visit = new boolean[N];

        for(int i = 0; i < N; i++) {
            data[i] = scan.nextInt();
        }

        dfs(0);
        System.out.println(answer);
    }
}
