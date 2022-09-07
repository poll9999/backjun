package main;

import java.util.Scanner;

public class movieDirectorShom {
    public static void main(String[] args){
/*
result라는 변수를 두고
result는 665부터 시작
1씩 증가시킴
만약 연속된 숫자 666이 있으면
index[]라는 배열에 보냄.
입력을 받으면
그 입력에 해당하는 숫자+1 번째 index의 출력값을 리턴시킴

여기서 오류발생. 666연속되는건 상관없지만 66?6이 나오면 안됨
어케 해결해야할까
 */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력받는 N번째 영화제목

        int result = 665; //초기숫자

        while (N > 0) {
            result++;
            String s = Integer.toString(result);

            if (s.contains("666")) {
                N--;
            }
        } /* N이 음수면 종료되는 while문.
        666이 들어가는 숫자를 찾기위해 1씩 계속 증가시키고, 숫자를 찾으면 N의 값을 1씩 줄임으로써
        몇번째 종말의 숫자인지 찾는 코드

        =>1. 몇 번째의 숫자라는 문제를 굳이 배열에 넣을려고 하지말고,
        배열보다 조금더 효율적인 방식이 있나 찾아보는 연습이 필요하다.

        2. 이 문제처럼 "숫자"를 포함하는 것을 검출하라 라는 식의 문제는
        숫자(정수)를 String으로 바꾼 후, contains이란 method를 활용하여
        포함하는를 검출한다.
        이 경우, method가 어떤것이 있고, 그 method가 어떤 기능을 하는지에 대해 알아야 한다.

        */
        System.out.println(result);
    }
}
