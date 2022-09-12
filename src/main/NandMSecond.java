package main;

import java.util.Scanner;

public class NandMSecond {
    static int N, M;
    static int[] result;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        used = new boolean[N + 1];
        result = new int[M+1];

        recur(0);
    }
    /*
    2개의 숫자를 입력받아, 중복되지 않는 순열을 오름차순으로 정렬하여 출력하는 문제이다.
    NandMFirst문제를 활용한 문제로, 다중 for문을 활용할수 있지만, 백트래킹을 활용하여 문제를 풀 생각이다.
    입력을 받고 생각해보니, NandMFirst를 풀었던 코드에서
    중간에 if 문만 삽입해주면 될것 같다고 생각했다.
    여기서 문제, 이 if문을 어디에다 넣을 것인가?
     */

    public static void recur(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i]) {
                continue;
            }
            if (index == 0 || result[index - 1] < i) {
                used[i] = true;
                result[index] = i;
                recur(index + 1);
                used[i] = false;
            }
        }
        /*
        NandMFirst 에선 백트래킹에 대해 알려주었다면,
        NandMSecond 는 First에서 풀었던 코드가 어떻게 작동 되고 있는지에 대해서 물어보는 것 같았다.
        그래서 직접 코드가 어떻게 작동 되는지 관찰하였고, 어떻게 해야 오름차순으로 정렬된 배열들만
        출력할수 있을지 고민해 보았다.
        index==0 일떄는, result[0]의 값이 무조건 1이 나와, 그 다음 숫자들은 무조건 1보다 큰 숫자가 들어오게 된다.
        따라서 index==0일땐 무조건 성립한다.
        그리고 코드를 보니 result[index]의 값은 무조건 i를 넣기 때문에,
        result[index]의 전의 값이 i보다 작으면 오름차순으로 정렬된 배열 만 나오게 된다.
        이 조건들을 recur 메소드 중간쯤에 넣어 해결했다.

        => 직접 코드가 어떻게 작동 되고 있는지를 생각해보니, 상당히 쉬운문제였다.
        이해가 안될떈 코드가 어떻게 구현되었는지도 중요하지만, 어떻게 작동되어있는가도 생각해볼 필요가 있다고 느꼇다.
         */
    }
}

