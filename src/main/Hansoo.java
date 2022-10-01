package main;

import java.util.Scanner;

public class Hansoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count=99;

        if(N<100){
            System.out.print(N);
        }
        else{
            for(int i=100; i<=N; i++){
                int a=i/100;
                int b=(i/10)%10;
                int c=i%10;
                if((a-b)==(b-c)){
                    count++;
                }
            }
            System.out.print(count);
        }
    }
}
