package main;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[] result= new int[N];
        int sum=0;
        int answer=0;

        for(int i=0; i<N; i++) {
            result[i] = sc.nextInt();
        }
        Arrays.sort(result);

        for(int i=0; i<N; i++){
            sum=sum+result[i];
            answer=sum+answer;
        }
        System.out.print(answer);
    }
}
