package main;

import java.util.Scanner;

public class NumberFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int d=sc.nextInt();
        int count=0;

        for(int i=1; i<=N; i++){
            String st = Integer.toString(i);
            for(int j=0; j<st.length(); j++){
                int x=st.charAt(j)-'0';
                if(x==d){
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
