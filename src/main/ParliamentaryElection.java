package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParliamentaryElection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];

        int b = 0;
        int c = 0;
        int index = 0;

        for (int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        /*
        숫자 한개를 입력받고, 그 숫자만큼의 크기를 가진 배열을 입력으로 받는다.
        그 배열의 첫번째 값이, 그 배열에 있는 값들보다 크게 만들고 싶어한다.
        그 배열의 MAX 값이 첫번째 값과 다르다면, MAX의 값을 1 줄이고,
        첫번째 값의 크기를 늘릴 예정이다.
        이를 풀기 위해서 정렬(Sort)를 시켜 첫번째 값이 배열의 몇번째인지 기억해야 한다.
        이렇게 풀라면, 배열의 몇번째인지 어떻게 기억해야할까?
         */
        if (N == 1) {
            System.out.print(0);
            return;
        }


        b = result[0];
        Arrays.sort(result);
        for (int i = 0; i < N; i++) {
            if (result[i] == b) {
                c = i;
                break;
            }
        }

        /*
        미리 첫번쨰 값을 저장해두고, for 문을 돌려 찾자마자 반복을 끝내, 몇번쨰인지 반환하게 하였다.
        그리고 반복문(while)을 돌려, 첫번째(=c)값이 오른쪽(=c+1) 값보다 작거나 같다면,
        c번째에 있는 값을 늘리고, 맨 끝에 있는 값을 줄이고 다시 소트시킨다.
        그리고 다시 몇번째인지 저장해두고, 몇번째인지 찾아내게 만들었다.

        while (true) {
            Arrays.sort(arr);
            if (dasom <= arr[n - 2]) {
                arr[n - 2]--;
                dasom++;
                ans++;
            } else {
                break;
            }
        }
        아니면 이처럼 첫번째 값을 따로 빼놓은 다음에 비교하면서 값을 증가시킬수도 있었다.
        문제에 배열이 주어지고, 기준치가 정해진다면 그 기준치를 따로 뺴놓고
        풀 수도 있다 라는 사실을 알게 되었다.

         */
        while (c < N - 1) {
            if (result[c] <= result[c + 1]) {
                result[c]++;
                result[N - 1]--;
                index++;
                int y = result[c];
                Arrays.sort(result);
                for (int i = 0; i < N; i++) {
                    if (result[i] == y) {
                        c = i;
                        break;
                    }
                }
            }
        }
        System.out.print(index);
    }
}