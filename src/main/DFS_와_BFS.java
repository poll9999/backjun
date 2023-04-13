package main;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class DFS_와_BFS {
    public static int[][] data;
    public static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        data = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            data[a][b] = 1;
            data[b][a] = 1;
        }

        visit = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visit = new boolean[N + 1];
        bfs(V);
    }

    public static void dfs(int V) {
        visit[V] = true;
        System.out.print(V + " ");

        if(V == data.length) {
            return;
        }
        else {
            for (int j = 1; j < data.length; j++) {
                if (data[V][j] == 1 && visit[j] == false) {
                    dfs(j);
                }
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(V);

        visit[V] = true;
        System.out.print(V + " ");

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i = 1; i < data.length; i++) {
                if(data[temp][i] == 1 && visit[i] == false) {
                    queue.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}