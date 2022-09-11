package main;

import java.util.Scanner;

public class multiplication {
    public static long C;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long A=sc.nextLong();
        long B=sc.nextLong();
        C=sc.nextLong();

        System.out.print(mod(A, B, C));
    }
    /*
    세 개의 숫자를 입력으로 받고(A, B, C)
    A^B%C를 계산하는 프로그램을 만든다.
    여기서 https://www.youtube.com/watch?v=8vDDJm5EewM 에서 배웠던
    재귀 라는 알고리즘을 이용하여 A^1%C를 알면, A^2k%C, A^(2k+1)%C를 알수있다
    라는 명제를 가지고 문제를 풀 것이다.
    여기서 문제, 지수가 짝수(2k)일때와 홀수(2k+1)일 때 어떻게 다른가?

    */
    public static long mod(long A, long B, long C){

        if(B==1){
            return A%C;
        }

        long result=mod(A, B/2, C);

        if(B%2==0){
            return (result*result%C);
        }

        else{
            return ((result*result%C)*A%C);
        }
    }
    /*
    이 재귀 method에서 base condition은 B==1일때, A%C를 리턴한다는 것이다.
    base condition은 메소드가 재귀할때 메소드 밖으로 나갈수있게 해주는 부분을 말한다.
    1일때의 나갈 수 있게 되었으니, 지수(B)가 짝수일때와 홀수일때만을 고려하여 메소드를 맞춰주면 된다.
    짝수일때를 B=2일때로 생각해보면, 10*10 % 12=> (10%12)*(10%12) %12로 바꿀 수 있다.
    즉, result라는 변수를 (10, 1(=2/2), 12) 라고 두면(result=10%12),
    (10, 2, 12)=result*result%12가 된다.
    이는 지수(B)가 4일때 마찬가지로 (10, 4, 12)=(10, 2, 12) *(10, 2, 12)%12로 쓸 수 있으며, 짝수일땐 모두 성립한다.
    반대로 홀수일땐, B=3으로 예를들면
    10^3%12=(10^2%12)*(10^1%12) 로 둘수있다.
    즉, result를 똑같이 (A, B/2, C)로 둔다고 가정했을때
    (10, 3, 12)=result*result*A%C라고 둘 수 있으며, 홀수일땐 모두 성립한다.

    =>여기서 홀수 일때 return(result*result*A%C) 라고 두면 overflow가 발생한다.
    long*long*long 이 출력할 수 있는 범위를 넘어서기 때문이다.
    이 때, mod 의 특징을 활용하여 ((result*result%C)*A%C)라고 고쳐줄수있다.
    C로 한번더 나눈다고 값이 변하지 않는 성질을 이용한것이다.

    물론 이 방법 외에도 출력을 Biginteger이나 string 형식으로 바꾸고 출력할 수도 있겠지만,
    문제에 주어진 mod의 성질을 이용하여 풀 수 있다는 것을 알았다.

    그 외로 데이터 자료형에 따라, 왜 overflow가 되는지 조금더 면밀히 알아 볼 필요가 있다 라는 것을 느꼇다.
     */
}
