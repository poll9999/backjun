package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfNumbers2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();

        List<Integer> standard=new ArrayList<>();
        for(int i=0; i<N; i++){
            standard.add(sc.nextInt());
        }

        int count=0;
        int start=0;
        int end=0;
        int length=standard.size();
        int sum=0;

        while(end<length){
            if(sum>=M){
                start++;
                sum-=standard.get(start);
            }
            else{
                end++;
                sum+=standard.get(end);
            }
            if(sum==M){
                count++;
            }
        }

        System.out.print(count);
    }

}
