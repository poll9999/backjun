package main;

import java.util.Scanner;

public class CountOfZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int result = 0;

            /*
            배열을 몇개 받을지의 개수, 시작값, 끝값을 입력으로 받고
            시작값과 끝값 사이에 있는 값들 중 0의 개수를 출력하는 코드를 짤려고한다.

            원래는 Builder를 사용해 문자열로 받고
            그 문자열을 나열하여 0이 있으면 result 값을 증가하는 코드를 짤려고했지만,
            Builder에 익숙치 않아, 10으로 나눈 나머지가 0인가 아닌가로 해보았다.
             */
            for (int j = N; j < M + 1; j++) {
                int k=j;
                if (k == 0) {
                    result++;
                    continue;
                }
                while (k>=10) {
                    if (k % 10 == 0) {
                        result++;
                    }
                    k /= 10;
                }
            }
            System.out.println(result);
        }
    }
}

/*
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = 0;

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int j = N; j <= M; j++) {

                String str = String.valueOf(j);

                for (int k = 0; k < str.length(); k++) {

                    if (str.charAt(k) == '0') {

                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}

내가 할려고했던 코드를 가져와봤다.
입력은 똑같이 받고, StringTokenizer을 사용하여 한줄씩 받게하였고,
배열에 존재하는 값들을  str=String.valueof(j)를 사용하여 문자열로 바꾸었다.
그리고 반복문을 두어 문자열에 문자 0이 존재하면, result 를 늘려 출력시키게 하였다.
처음엔 나도 Builder를 사용하여 String st=String.valueof(index[j])까지 해봤는데
출력이 잘안나와서 포기했었다.
다시 생각해보니 배열을 굳이 두지 말고 반복문으로 시작값과 끝값을 두고, 찾는게 훨씬 편한 방법임을
느꼇다.
*/
