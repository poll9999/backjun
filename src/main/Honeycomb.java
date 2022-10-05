package main;

import java.util.Scanner;

public class Honeycomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int answer= 2;
        int count= 1;

        if(N==1){
            System.out.print(1);
        }
        else {
            while (answer <= N) {
                answer = answer + (6 * count);
                count++;
            }
            System.out.print(count);
        }
    }
}
