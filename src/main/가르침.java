package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침 {
    private static int N;
    private static int K;
    private static int maxCount = Integer.MIN_VALUE;
    private static String[] data;
    private static final boolean[] visit = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new String[N];

        if (K < 5) {
            System.out.print(0);
        } else if (K == 26) {
            System.out.print(N);
        } else {
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                data[i] = s.substring(4, s.length() - 4);
            }
            visit[0] = true;
            visit['c' - 'a'] = true;
            visit['i' - 'a'] = true;
            visit['n' - 'a'] = true;
            visit['t' - 'a'] = true; //a c i n t
        }

        dfs(0, 0);
        System.out.println(maxCount);
    }

    private static void dfs(int index, int start) {
        if (index == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean check = true;
                for (int j = 0; j < data[i].length(); j++) {
                    if (!visit[data[i].charAt(j) - 'a']) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
            return;
        }

        for (int i = index + 5; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(index + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}