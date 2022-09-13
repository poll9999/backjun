package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandMThird {
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

    2개의 숫자를 입력받아, 중복 가능한 순열을 출력하는 문제이다.
    고민을 해보니, NandMFirst 문제에서 if(used[i]){continue;}만 빼면
    중복 가능한 순열을 출력할수 있다고 생각하여 해봤지만, 자꾸 시간초과가 떠서
    어떻게 해볼지 고민하다 BufferReader,StringTokenizer,StringBuilder을 사용해보았다.
    BufferReader 는 Scanner 대신 사용
    StringTokenbizer는 BufferReader의 메서드로 입력을 읽을때
    문자열을 나누고 싶으면 사용하는 것이고,
    StringBuilder는 많은 출력을 할때 그 문자열들을 전부 하나로 엮어버려
    print하는 횟수를 줄이는 곳에 사용한다

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
            result[index] = i;
            recur(index + 1);
        }
    }
     /*
    StringBuilder sb의 메서드 중 sb.append는 StringBuilder 가 문자열을 나누므로
    그 나눈 부분을 말해준다.
    append(1).append(2) 에서 2는 1과 똑같은 기능을 한다.

    =>여태껏 Scanner만쓰다가 BufferReader라던가 StringTokenizer, StringBuilder 을 사용하니 어색했다.
    반복문에 출력을 넣어버리면, 시간이 오래걸려 Builder을 써서 문자열로 엮어 버려야 한다는 점,
    BufferReader을 이용하여 시간을 단축시킬 수 있다는 점,
    StringTokenizer로 문자열을 나눌수 있다는 점을 알았다.
     */

    /*
    마찬가지로
    전역번수에 static boolean[] used를 선언하고
    아래 recur 메소드를
    public static void recur(int index) {

      if (index == M) {
         for (int i = 0; i < M; i++) {
            sb.append(result[i]).append(" ");
         }
         sb.append("\n");
         return;
      }

      for (int i = 1; i <= N; i++) {

         used[i] = true;
         result[index] = i;
         recur(index + 1);
         used[i] = false;
      }
   }
   로 바꿔도 성공했다.
     */
}