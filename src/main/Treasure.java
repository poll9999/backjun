package main;

import java.util.Arrays;
import java.util.Scanner;

public class Treasure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        if (N % 2 == 1) {
            for (int i = 0; i < N / 2; i++) {
                int term = 0;
                term = B[N - i - 1];
                B[N - i - 1] = B[i];
                B[i] = term;
            }
        } else if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                int term = 0;
                term = B[N - i - 1];
                B[N - i - 1] = B[i];
                B[i] = term;
            }
        }
        int sum=0;
        for(int i=0; i<N; i++){
            result[i]=A[i]*B[i];
            sum+=result[i];
        }
        System.out.print(sum);
    }
}
