package main;

import java.util.Scanner;

public class Divisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int F=sc.nextInt();

        int a=N-N%100;
        int b=a+100;

        for(int i=a; i<b; i++){
            if(i%F==0){
                if((i%100)<10){
                    System.out.print("0"+i%100);
                    break;
                }
                else {
                    System.out.print(i % 100);
                    break;
                }
            }
        }
    }
}
