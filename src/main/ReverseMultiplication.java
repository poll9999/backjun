package main;

import java.util.Scanner;

public class ReverseMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        int max=Integer.MIN_VALUE;

        for(int i=1; i<=K; i++){
            int result=N*i;
            String s=String.valueOf(result);
            StringBuilder sb=new StringBuilder();
            for(int j=s.length()-1; j>=0; j--){
                sb.append(s.charAt(j));
            }
            max=Math.max(max,Integer.parseInt(sb.toString()));
        }

        System.out.print(max);
    }
}
