package main;

import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S=sc.nextLong();
        long count=-1;
        long sum=0;

        if(S==1){
            System.out.print(1);
            return;
        }

        for(long i=1; i<=S; i++){
            sum+=i;
            count++;
            if(S<sum)
                break;
        }
        System.out.print(count);
    }
}
