package main;

import java.util.Scanner;

public class Decomposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int answer=0;
        for(int i=0; i<N; i++){
            if(Decompose(i)==N){
                answer=i;
                break;
            }
        }
        System.out.print(answer);

    }

    public static int Decompose(int n){
        int result=0;
        String str = Integer.toString(n);
        for(int i=0; i<str.length(); i++){
            result=result+(str.charAt(i)-'0');
        }
        result=result+n;
        return result;
    }
}
