package main;

import java.util.Arrays;
import java.util.Scanner;

public class SnakeBird {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();
        int L=sc.nextInt();

        int[] M=new int[N];
        for(int i=0; i<N; i++){
            M[i]=sc.nextInt();
        }
        Arrays.sort(M);
        for(int i=0; i<N; i++){
            if(M[i]<=L)
                L++;
        }
        System.out.print(L);

    }
}