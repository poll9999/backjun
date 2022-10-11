package main;

import java.util.Scanner;

public class FindPrimaryNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[] M=new int[N];
        int count=0;
        for(int i=0; i<N; i++){
            M[i]=sc.nextInt();
            if(Prime(M[i]) == true){
                count++;
            }
        }

        System.out.print(count);
    }

    public static boolean Prime(int N){
        if(N==1){
            return false;
        }

        for(int i=2; i<N; i++){
            if(N%i==0)
                return false;
        }

        return true;
    }
}
