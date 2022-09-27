package main;

import java.util.Scanner;

public class CommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a=Integer.MAX_VALUE;
        int N = sc.nextInt();
        int M[] = new int[N];
        for(int i=0; i<N; i++){
            M[i]=sc.nextInt();
        }

        int b=Math.min(M[0], M[1]);

        if(N==2){
            for(int i=1; i<=b; i++){
                if(M[0]%i==0&&M[1]%i==0){
                    System.out.println(i);
                    continue;
                }
            }
        }
        if(N==3){
            for(int i=1; i<=Math.min(b, M[2]); i++){
                if(M[0]%i==0&&M[1]%i==0&&M[2]%i==0){
                    System.out.println(i);
                    continue;
                }
            }
        }
    }
}
