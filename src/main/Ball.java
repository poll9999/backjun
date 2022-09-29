package main;

import java.util.Scanner;

public class Ball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int cup = 1;

        for(int i=0; i<N; i++) {
            int X = scan.nextInt();
            int Y = scan.nextInt();

            if(cup == X)
                cup = Y;
            else if(cup == Y)
                cup = X;
        }
        System.out.print(cup);
    }
}
