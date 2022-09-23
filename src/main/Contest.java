package main;

import java.util.Scanner;

public class Contest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();

        int A;
        int B;
        int C;
        int count=0;

        for(A=2; A<N; A=A+2){
            for(B=1; B<N; B++){
                for(C=1; C<N; C++){
                    if(C>=B+2 && N==A+B+C){
                        count++;
                    }
                }
            }
        }
        System.out.print(count);
    }
}
