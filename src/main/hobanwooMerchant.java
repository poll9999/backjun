package main;

import java.util.Arrays;
import java.util.Scanner;

public class hobanwooMerchant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int example[] = new int[count];
        int answer = 0;

        for (int i = 0; i < count; i++) {
            example[i] = sc.nextInt();
        }

        Arrays.sort(example);

        /*
        입력받는 숫자들의 개수와, 입력받는 숫자들을 배열에 넣어 입력받았고,
        보기편하게 오름차순으로 sort시켰다.
        이제 총 숫자들의 합이 최대가 되게하는 호반우 알고리즘을 적용시키면 된다.
        여기서 문제, 어떻게 하면 최대가 할 수 있을까?
         */
        if (count % 2 == 0) {// count가 짝수이면
            for(int i=count/2; i<count; i++){
                answer+=example[i]*2;
            }
        /*
        호반우 알고리즘의 쟁점은 "중앙값 찾기"와 "어떤 묶음으로 묶을지"이다.
        묶음에 있는 숫자들의 개수가 짝수이거나 홀수일경우,
        count/2번째 숫자를 중앙값으로 두어 그 묶음에 있는 숫자들을 중앙값으로 통일시킨다.
        그렇다면 어떤 묶음으로 묶어야, 중앙값을 이용하여 최대값을 찾을수 있을까?
        여러가지 예시를 이용하여, 2개로 묶었을 경우, 3개, 4개 ..로 묶었을 경우 최대합이 나오는지 찾아보았다.
        결론은 2개로 묶엇을 때가 최대합이 가장 컸다.
        3개로 묶었을 경우, a<b<c가 있다고 가정해보자.
        이경우 b가 중앙값이 되므로 3b가 최대합이 된다.
        하지만, 이 3개의 숫자를 (a, c)묶음과 b 로 나누고 다시 최대합을 구해보면
        (a,c) 묶음의 중앙값은 c, 묶음의 합은 2c 이고 다시 b를 더하면 2c+b가 된다.
        여기서 3개로 묶었을 떄와 비교해보면 3b vs 2c+b가 된다.
        b를 좌항으로 넘겨보면 2b vs 2c, 위 조건에서 b<c 라고 하였으므로
        2b<2c가 된다.
        4개로 묶거나 5, 6, ... 개로 묶엇을 경우도 마찬가지다.
        따라서 2개로 묶는 것이 호반우 알고리즘에서 찾는 답이다.
        */

        } else {
            for (int i = count / 2 + 1; i < count; i++) {
                answer+=example[i]*2;
            }
            answer=answer+example[count/2];
        }
        System.out.print(answer);
        /*
        이 문제는 새로운 메소드 혹은 어노테이션을 알아야 하기보다는, 문제 자체를 이해 하고 어떤식으로 접근해야하는지가 관건이였다.
        문제에 대해 조금더 면밀하게 접근해 볼 필요가 있다고 느꼇다.
         */
    }
}
