package main;

import java.util.Scanner;

public class dateCalculation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int G = sc.nextInt();
        int M = sc.nextInt();

          /*
        숫자 3개를 입력받아 년도로 바꾸는 코드
        1 1 1을 초기값으로 두고(=1)
        숫자 3개모두 1씩 증가함.
        첫번째는 MAX값이 15, 두번째는 28, 세번째는 19
        MAX값에 도달하면 다음 숫자는 1
        index라는 변수를 계속 1씩 증가시켜, 입력받은 숫자에 도달할떄까지
        while문 혹은 for문을 계속 반복시킨다.
         */

        int index=0;
        int n=0;
        int g=0;
        int m=0;
        while(true) {
            index++;
            n++;
            g++;
            m++;
            if(n==16) n=1;
            if(g==29) g=1;
            if(m==20) m=1;
            if(n==N&&g==G&&m==M) break;
            /*
            조건을 달성하기 위해 입력을 받는 세 변수들 이외에, 그 변수들에 해당하는 변수들을 만들었고
            그 변수들이 loop를 돌수있게 max 값에 도달하면 다시 1로 변하게 하여 최종적으로 입력값에 도달하면 index 값을 출력하게 하였다


             */
        }
        System.out.print(index);

   }
}

/*
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int G = sc.nextInt();
        int M = sc.nextInt();


        int index=0;
        while(N==1&&G==1&&M==1) {
            index++;
            if(N==1) N=15;
            if(G==1) G=28;
            if(M==1) M=19;
            N--;
            G--;
            M--;
        }
        System.out.print(index);
       => 이 코드의 경우, 입력값을 1씩 감소시켜 역순으로 index의 값을 구할려했으나,
       알고리즘이 너무 복잡하고
       while문이 한번 돌면 끝나는 오류가 발생한다.(index=0)
       while문의 종료조건은 if문을 활용하여 if문 내에 종료조건을 달아주는게 좋다는 것을 알았다.
    }*/


/*
  public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int e = scan.nextInt(), s = scan.nextInt(), m = scan.nextInt();

        int year = 0;
        while (true) {
            year++;
            if ((year - e) % 15 == 0 && (year - s) % 28 == 0 && (year - m) % 19 == 0) break;
        }
        System.out.print(year);
    }
}

    => 이 문제의 중요한점인 "루프"가 나올때 쓰는 방법으로 %(나머지)를 사용하여, 루프를 도는것 처럼 할 수 있다.
    간결하게, 핵심을 파악하여 코드를 조금더 효율적으로 짤수 있다.
 */
