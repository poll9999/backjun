package main;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        /*N=운동을 N분동안할려함, 못하면 -1출력
        m=최소 맥박
        M=최대 맥박
        T=운동선택하면 이만큼 증가
        R=휴식선택하면 이만큼 감소
         */

        /*
        5분동안할려함.
        최소 맥박 70 최대맥박 120
        70+25*5=195-15*5
         */

        /*
        100분할려함
        최소 맥박 50 최대 맥박 100
        증가량 5 감소량 200
        50+5*10=100-200 == 50   =>11분소비
        50+5*10=100-200 == 50    ==>11분소비

...
99분소비할떄쯤
 90분 운동
 10 분운동 더하면
 109분
         */

        /*
        1분할려함
        최소 60 최대 70
        증가량 11
        감소량 11
         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();

        int answer=0;
        int count=0;
        int result=m;
        while (count != N) {
            answer++;
            if (m + T <= M) {
                m += T;
                count++;
            } else {
                m -= R;
                if (m < result) {
                    m = result;
                }
            }
            if ((m + T > M) && (m == result))
                break;
        }
        if (count != N)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}
