package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandMFourth {
    static StringBuilder sb;
    static int N, M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb=new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M+1];

        recur(0);
        System.out.print(sb.toString());
    }

    /*
    2개의 숫자를 입력받아 중복이 가능한 순열을 비내림차순으로 출력하는 문제이다.
    비내림차순=Ai<=Ai+1<= ...
    N과 M 1번이나 2번, 3번과 마찬가지로 다중 for문을 활용할수 있지만, 백트래킹을 활용하여 문제를 풀것이고,
    입력을 받고 생각해보니, NandMSecond와 NandMThrid를 짬뽕 시킨 문제라고 생각이 들었다.
     */

    public static void recur(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(index==0||result[index-1]<=i) {
                result[index] = i;
                recur(index + 1);
            }
        }
    }
    /*
    생각했던것이 맞아떨여져서 BufferReader, StringTokenizer, StringBuilder 개념을
    보지 않고 코드를 다시 작성해보았다.
    Scanner만 써서 낯설긴하지만 계속쓰다보면 능숙해질것같다.
     */
}
