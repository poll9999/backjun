package main;

import java.util.Scanner;

public class AmazingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(self(N));
    }
    public static int self(int N) {
        int result=0;
        int count=0;
        for(int i=1; i<=N; i++){
            result=i;
            int b=0;
            while(true){
                if(result==0) {
                    break;
                }
                int a=result%10;
                result=result/10;
                b=b+a;
            }
            if(i%b==0) {
                count++;
            }
        }
        return count;
    }
}