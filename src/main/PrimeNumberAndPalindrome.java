package main;

import java.util.Scanner;

public class PrimeNumberAndPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();

        int answer=N;

        if(N==1){
            System.out.print(2);
            return;
        }

        while(N<=answer) {
            if (answer <= 1003001) {
                if (palin(answer) == 1 && prime(answer) == 1) {
                    break;
                }
                answer++;
            }
        }
        System.out.print(answer);
    }
    public static int palin(int A){
        String str=String.valueOf(A);
        int a=0;
        int b=str.length()-1;
        int result=1;
        while(a<=b) {
            if (str.charAt(a) != str.charAt(b)) {
                result=0;
            }
            a++;
            b--;
        }
        return result;
    }

    public static int prime(int A) {
        int result=1;
        for(int i=2; i<A; i++){
            if(A%i==0){
                result=0;
                break;
            }
        }
        return result;
    }
}