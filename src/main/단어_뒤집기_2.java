package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어_뒤집기_2 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> data = new Stack<>();
        String s = br.readLine();
        boolean check = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                while (!data.isEmpty()) {
                    sb.append(data.pop());
                }
                check = true;
            } else if (s.charAt(i) == '>') {
                check = false;
                sb.append(s.charAt(i));
                continue;
            }

            if (check) {
                sb.append(s.charAt(i));
            } else {
                if (s.charAt(i) == ' ') {
                    while (!data.isEmpty()) {
                        sb.append(data.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    data.push(s.charAt(i));
                }
            }

            if (i == s.length() - 1) {
                while (!data.isEmpty()) {
                    sb.append(data.pop());
                }
            }
        }

        System.out.println(sb);
    }
}
