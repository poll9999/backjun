package main;

import java.util.Scanner;

public class ElementaryMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        int[] a=new int[T];
        int[] b=new int[T];
        for(int i=0; i<T; i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
        }
        for(int i=0; i<T; i++){
            System.out.println(min(a[i], b[i])+" "+max(a[i], b[i]));
        }
    }

    public static int max(int a, int b){
        int result = 0;
        for(int i=1; i<=Math.min(a, b); i++){
            if(a%i==0&&b%i==0){
                result=i;
            }
        }
        return result;
    }

    public static int min(int a, int b){
        int result=0;
        int answer=max(a, b);
        result=answer*(a/answer)*(b/answer);
        return result;
    }
}
