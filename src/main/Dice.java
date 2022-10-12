package main;

import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S1 = sc.nextInt();
        int S2 = sc.nextInt();
        int S3 = sc.nextInt();

        int[] result = new int[S1 + S2 + S3 - 2];
        int answer = 0;

        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    result[i + j + k - 3]++;
                    answer = Math.max(answer, result[i+j+k-3]);
                }
            }
        }
        int a = 0;
        for (int i = 0; i < S1 + S2 + S3 - 2; i++) {
            if (result[i] == answer) {
                a = i + 3;
                break;
            }
        }
        System.out.print(a);
    }
}
