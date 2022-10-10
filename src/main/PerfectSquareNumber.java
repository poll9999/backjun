package main;

import java.util.Scanner;

public class PerfectSquareNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        int answer=0;
        int first= Integer.MAX_VALUE;

        for(int i=M; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j*j){
                    first=Math.min(i, first);
                    answer=answer+i;
                }
            }
        }
        if(answer==0){
            System.out.print(-1);
            return;
        }
        System.out.println(answer);
        System.out.print(first);
    }
}