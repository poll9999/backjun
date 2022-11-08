package main;

import java.util.Scanner;

public class aToK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();

        System.out.println(increase(N, M));
    }

    public static int increase(int N, int M){
        int count=0;
        while(N!=M) {
            if (M % 2 == 0) {
                if(M/2>=N){
                    M=M/2;
                    count++;
                }
                else{
                    M=M-1;
                    count++;
                }
            } else {
                M = M - 1;
                count++;
            }

        }
        return count;
    }
}