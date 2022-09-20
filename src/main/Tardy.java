package main;

import java.util.Scanner;

public class Tardy {
    static int answer=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result=new int[T];

        for(int i=0; i<T; i++){
            result[i]=sc.nextInt();
            int answer=0;
            while(answer*answer+answer<=result[i]){
                answer++;
            }
            System.out.println(answer-1);
        }
    }
}
