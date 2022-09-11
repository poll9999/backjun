package main;

import java.util.Scanner;

public class NandMFirst {

    static int N, M;
    static int[] result;
    static boolean[] used;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        used = new boolean[N+1];
        result = new int[M+1];

        recur(0);
    }
    /*
    2개의 숫자를 입력받아, 중복되지 않는 순열을 출력하는 문제이다.
    예를들어 3 1이 입력이면, 3개중 1개를 뽑고 나열하고( 1, 2, 3)
    4 2가 입력이면 개중 2개를 뽑고 나열(4P2=12, (1, 2), (1, 3) ...)

    다중 for문을 사용해서 풀수 있는 문제이긴 하지만, 백트래킹을 활용하여 접근할려고한다.
    여기서 문제, 백트래킹을 어떻게 활용할것인가?
     */

    public static void recur(int index){
        if(index == M){
            for(int i=0; i<M; i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            result[index] = i;
            recur(index + 1);
            used[i] = false;
        }
    }
    /*
    재귀하는 이 백트래킹 method는 복잡할것 같지만, 계속 고민해보니 생각보다 간단했다.
    먼저 어떤값도 집어 넣지 않았기 떄문에, used[]와 result[]의 값은 전부 false이거나 0이다. (N=4, M=2로 가정)
    index에 0을 집어넣고 loop와 if문을 돌려보면 used[1]=false이므로 if문 아래에 있는 코드들을 동작한다.
    used[1]를 true로 바꾸고 result[0]=1 다시 메소드 recur[1]을 호출한다.
    recur[1]에서 index=1 이므로 상단에있는 if문에 걸리지 않는다.
    for문으로 돌아와 i=1일떄, used[1]은 이미 true로 바뀌었으므로 continue 시켜 pass시킨다.
    i=2일떄, used[2]=false이므로 used[2]를 true로 바꾸고 result[1]=2, recur[2]를 호출한다.
    recur[2]에서 index==2로 바뀌었으므로 result[] 에있는 {1, 2}를 출력하고 리턴시킨다.
    다시 for문으로 돌아와 used[2]=false, used[1]=false를 하여 used[] 에있는 원소들을 전부 false로 바꾼후,
    result[]={1,2}를 가지고 다시 recur method로 돌아가서 {1,3}, {1,4} 를 출력하는 방식이다.

    => 이코드에서 if(used[i]){continue}와 used[i] 만 빼면 중복 가능한 순열도 출력할 수 있다는 사실을 깨달았다.
    백트래킹이 처음이라, 이해하기 상당히 까다로웠지만 다중for문을 대체한다고 생각하고 다시 들여다 보니 접근을 조금 더 쉽게 할수 있었다.

     */
}
