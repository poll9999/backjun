package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹_단어_체커 {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] data = new String[N];

        for (int i = 0; i < N; i++) {
            data[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            if (checker(data[i])) {
                count++;
            }
        }

        System.out.print(count);
    }

    private static boolean checker(String s) {
        boolean[] visit = new boolean[26];
        char before = 0;
        char after;

        for (int i = 0; i < s.length(); i++) {
            after = s.charAt(i);
            if (before != after) {
                if (!visit[after - 'a']) {
                    visit[after - 'a'] = true;
                    before = after;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
