package main;

import java.util.Scanner;

public class OvenClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h=sc.nextInt();
        int m=sc.nextInt();
        int p=sc.nextInt();

        int answer=m+p;

        while(answer>59){
            h++;
            if(h>23){
                h=0;
            }
            answer=answer-60;
        }

        System.out.print(h+" "+answer);
    }
}
