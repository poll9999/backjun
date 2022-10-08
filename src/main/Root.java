package main;

import java.util.Scanner;

public class Root {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true) {
            double B = sc.nextDouble();
            double N = sc.nextDouble();

            if (B == 0 && N == 0) {
                break;
            }

            int A = 1;
            while((int)Math.abs((B - (int)Math.pow(A, N))) > (int)Math.abs(B - (int)Math.pow(A + 1, N))) {
               A++;
            }
            sb.append(A).append("\n");
        }
        System.out.println(sb);
    }
}

