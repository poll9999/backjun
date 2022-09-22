package main;

import java.util.Scanner;

public class DifferenceFiveandSix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int a=max(A);
        int b=min(A);
        int c=max(B);
        int d=min(B);

        System.out.print(b+d);
        System.out.print(" ");
        System.out.print(a+c);
    }

    public static int min(int N) {
        String str = String.valueOf(N);
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '6') {
                sb.setCharAt(i, '5');
                str = sb.toString();
            }
        }
        int a = Integer.parseInt(str);
        return a;
    }

    public static int max(int N) {
        String str = String.valueOf(N);
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '5') {
                sb.setCharAt(i, '6');
                str = sb.toString();
            }
        }
        int a = Integer.parseInt(str);
        return a;
    }
}