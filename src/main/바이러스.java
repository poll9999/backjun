package main;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {
    private static int[][] data;
    private static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ComputerQuantity = sc.nextInt();
        int PairQuantity = sc.nextInt();

        data = new int[ComputerQuantity+1][ComputerQuantity+1];

        for(int i=0; i<PairQuantity; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            data[a][b]=1;
            data[b][a]=1;
        }

        visit = new boolean[ComputerQuantity+1];
        bfs(1);
    }

    private static void bfs(int begin){
        Queue<Integer> queue = new PriorityQueue<>();

        visit[begin] = true;
        queue.offer(begin); // 추가 개념(add 와는 다름)
        int count = 0;

        while(!queue.isEmpty()){
            int temp = queue.poll(); //삭제 개념(remove 와는 다름. 리턴함)
            for(int i=1; i<data.length; i++){
                if (data[temp][i] == 1 && !visit[i]){
                    queue.offer(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
