package main;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[][] result = new int[N][5];
        for(int i=0; i<N; i++){
            for(int j=0; j<5; j++){
                result[i][j]=sc.nextInt();
            }
        }
        int a=0;
        int b = 0;
        for(int i=0; i<N; i++){
            a=Math.max(a, Big(result[i]));
            if(a == Big(result[i])){
                b=i+1;
            }
        }
        System.out.print(b);
        
    }

    public static int Big(int[] n){
        int result1 = 0;
        for(int i=0; i<5; i++){
            for(int j=i+1; j<5; j++) {
                for (int k = j + 1; k <5; k++) {
                    result1=Math.max((n[i]+n[j]+n[k])%10, result1);
                }
            }
        }
        return result1;
    }
}