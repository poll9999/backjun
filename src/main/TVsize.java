package main;

import java.util.Scanner;

public class TVsize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        double d;

        double e=  Math.pow(b, 2);
        double f=  Math.pow(c, 2);
        d= (a/Math.sqrt(e+f));

        int result1= (int) (b*d);
        int result2= (int) (c*d);

        System.out.print(result1+" "+result2);
    }
}
