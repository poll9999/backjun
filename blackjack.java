package main;

import java.util.Arrays;
import java.util.Scanner;


public class blackjack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int result = sc.nextInt();
        int example[] = new int[count];
        int answer=0;

        for (int i = 0; i < count; i++) {
            example[i] = sc.nextInt();
        }
        Arrays.sort(example);

        /*
        입력받는 숫자들의 개수를 나타내는 변수, 총합, 입력받는 숫자들을 입력으로 받았고
        목표하는 값을 출력하기 위해 변수 하나를 따로 두었다.
        또한 이해하기 쉽게 오름차순으로 정렬하였다.
        이제 목표하는 값에 가까운 값, 혹은 목표값을 출력하기 위해 코딩해야한다.
        여기서 문제, 목표값과 같은값이 나오는 것은 어렵지 않다.
        하지만 "가까운" 값을 출력하기 위해 어떻게 해야할까?
         */
        for (int i = 0; i < count - 2; i++) {
            for (int j = i + 1; j < count - 1; j++) {
                for (int k = j + 1; k < count; k++) {
                    if (result < example[i] + example[j] + example[k]) {
                        continue;
                    } else {
                        answer=Math.max(answer, example[i] +example[j] + example[k]);
                    }
                }
            }
        }
        /*
        입력받는 숫자들 중 3개의 값의 합을 나타내기 위해 3중 for문을 작성하였다.
        조건에 맞지않는, 3개의 합이 목표값보다 클땐, 지나가게 하기 위해 continue 를 사용했고
        "가까운"값을 나타내기위해 max(a,b)를 사용하였다.
        원래 else구문에 break를 넣고 했었지만, 다시 생각해보니
        break를 넣어버리면 하나의 경우만 맞아도 loop를 빠져나가 버려 엉뚱한 값을 답으로 처리해버린다.
        따라서 모든 경우(brute force)를 돌기 위해 break를 뺴야한다.

        =>대학교 강의에서 배웠던 max(a,b)가 나왔다.
        기억은 하고 있었지만 이처럼 목표값과 가까운 값을 찾기 위해 사용한다는 것을 알았다.
         */

        System.out.print(answer);
    }
}
