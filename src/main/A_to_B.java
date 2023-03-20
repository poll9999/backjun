package main;

import java.util.Scanner;

public class A_to_B {
    private static long A, B;
    private static long data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        data = -1;
        A = sc.nextInt();
        B = sc.nextInt();
        bfs(A, B, 0);
        if (data == -1) {
            System.out.println(data);
        }
        else {
            System.out.println(data + 1);
        }
    }

    private static void bfs(long a, long b, long count) {
        if (a == b) {
            if (data == -1 || data > count) {
                data = count;
            }
            return;
        }

        if (2 * a <= b) {
            bfs(2 * a, b, count + 1);
        }

        if (10 * a + 1 <= b) {
            bfs(10 * a + 1, b, count + 1);
        }
    }
}