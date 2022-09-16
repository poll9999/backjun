package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UnitSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int index[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str=br.readLine();
            for (int j = 0; j < M; j++) {
                index[i][j]=str.charAt(j)-'0';
            }
        }

        /*
        2개의 숫자를 입력받아(N과 M), N행 M열의 배열을 입력받고,
        배열내에 꼭짓점에 쓰여있는 수가 모두 같은 정사각형의 크기를 찾는 프로그램이다.
        띄어쓰기 없이 입력을 받아야 하므로, Buffer로 입력을받고, 문자열을 분리하기 위해 StringTokenizer을 사용하였다.
        마지막으로 한줄씩 string 으로 받은다음 문자 '0'을 빼서 int형으로 반환후 배열에 집어넣었다.
        이제 크기가 최대인 정사각형을 찾고, 정사각형의 크기를 출력해야한다.
        여기서 문제, 최대인 정사각형을 어떻게 찾을 것인가?
         */
        int min = Math.min(N, M);

        if(N==1){
            System.out.print("1");
            return;
        }

        while (min > -1) {
            for (int i = 0; i < N-min; i++) {
                for (int j = 0; j < M-min; j++) {
                    int result=index[i][j];
                    if(result==index[i+min][j]&&result==index[i][j+min]&&result==index[i+min][j+min]){
                        System.out.print((min+1)*(min+1));
                        return;
                    }
                }
            }
            min--;
        }

        /*
        N과 M이 주어졌을때, 정사각형은 N과 M중 최솟값보다 길이가 클수가없다. 따라서
        둘중 최솟값을 min이란 변수에 집어넣어 반복문을 돌떄마다 min의 값을 줄였다.
        꼭짓점에 있는 숫자들이 같으면, 정사각형이라 한다 라는 조건을 이용하여
        기준점을 정하고, 기준점에서 min 만큼 차이나는 점들과 기준점이 같은 값을 가지고 있는지 비교하여
        정사각형의 넓이를 출력하였다.
        예외로, N이 1일땐 배열 한가지만 들어오기 때문에, 1을 출력하도록 하였다.

        =>알고리즘을 구현하는 것은 오래 걸리지 않았지만,
        for (int i = 0; i < N; i++) {
            String str=br.readLine();
            for (int j = 0; j < M; j++) {
                index[i][j]=str.charAt(j)-'0';
            }
        }
        문자열로 받은것을, 0을 뺴어 다시 Int형으로 만들어주는 과정을 몰라 애먹었다.
        띄어쓰기가 없는 숫자들을 구분하여 볼때, StringTokenizer, index=str.charAt()-'0'을
        기억해야 겠다.
        */
    }
}
