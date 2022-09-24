package main;

import java.util.Scanner;

public class ThreeSixNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(count(N));
    }
    public static int count(int N){
        int result;
        int count=0;
        for(int i=0; i<=N; i++) {
            result = i;
            while(result>0) {
                if(result%10 == 3 || result%10 == 6 || result%10 == 9) {
                    count++;
                }
                result=result/10;
            }
        }
        return count;
    }
}
