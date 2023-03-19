package main;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 촌수계산 {
    private static int N, M;
    private static int[][] data;
    private static int[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        data = new int[N+1][N+1];
        M = sc.nextInt();

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            data[a][b] = 1;
            data[b][a] = 1;
        }

        visit = new int[N+1];

        bfs(start, end);
        if (visit[end]==0){
            System.out.print(-1);
        }
        else {
            System.out.print(visit[end]);
        }
    }

    private static void bfs(int start, int end){
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int a = queue.poll();

            if (a==end){
                break;
            }
            else {
                for (int i = 1; i <= N; i++) {
                    if (data[a][i] == 1 && visit[i] == 0) {
                        visit[i] = visit[a] + 1;
                        queue.offer(i);
                    }
                }
            }
        }
    }
}
