package main;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        int[] N=new int[T];
        for(int i=0; i<T; i++){
            N[i]=sc.nextInt();
            if(sum(N[i])==N[i]){
                System.out.println("Perfect");
            }
            else if(sum(N[i])>N[i]){
                System.out.println("Abundant");
            }
            else
                System.out.println("Deficient");
        }
    }
    public static int sum(int N){
        int result=0;
        for(int i=1; i<N; i++){
            if(N%i==0){
                result=result+i;
            }
        }
        return result;
    }
}
