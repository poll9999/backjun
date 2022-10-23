package main;

import java.util.Scanner;

public class CoinZero {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        int[] result=new int[N];
        int count=0;

        for(int i=0; i<N; i++){
            result[i]=sc.nextInt();
        }

        for(int i=N-1; i>=0; i--){
            while(result[i]<=K){
                K=K-result[i];
                count++;
            }
        }

        System.out.print(count);
    }
}
