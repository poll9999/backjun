package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호_만들기 {
    private static int L;
    private static int C;
    private static char[] data;
    private static char[] result;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        data = new char[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            data[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(data);
        dfs(0, 0);

        System.out.println(sb);
    }

    private static void dfs(int index, int start) {
        if (index == L) {
            if (validString()) {
                String s = String.valueOf(result);
                sb.append(s).append("\n");
            }
            return;
        }

        for (int i=start; i<C; i++) {
            result[index] = data[i];
            dfs(index+1, i+1);
        }
    }

    private static boolean validString() {
        int vowelsCount = 0;
        int consonantsCount = 0;

        for(char c : result) {
            if (c == 'a'|| c == 'e'|| c == 'i'|| c == 'o'|| c == 'u') {
                vowelsCount ++;
            }
            else{
                consonantsCount ++;
            }
        }

        return vowelsCount > 0 && consonantsCount > 1;
    }
}