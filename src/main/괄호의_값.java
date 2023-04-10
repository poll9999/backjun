package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의_값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();

        int result = 0;
        int count = 1;
        Stack<Character> stack = new Stack<>();

        if (!checkString(data)) {
            System.out.println(0);
            System.exit(0);
        } else {
            for (int i = 0; i < data.length(); i++) {
                char c = data.charAt(i);
                if (c == '(') {
                    stack.push(c);
                    count *= 2;
                } else if (c == '[') {
                    stack.push(c);
                    count *= 3;
                } else {
                    if (c == ')') {
                        if (data.charAt(i - 1) == '(') {
                            result += count;
                        }
                        stack.pop();
                        count /= 2;
                    } else if (c == ']') {
                        if (data.charAt(i - 1) == '[') {
                            result += count;
                        }
                        stack.pop();
                        count /= 3;
                    }
                }
            }
        }

        System.out.print(result);
    }


    private static boolean checkString(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack[top] == '(') {
                    top--;
                } else {
                    return false;
                }
            }
            if (c == ']') {
                if (stack[top] == '[') {
                    top--;
                } else {
                    return false;
                }
            }
            if ((c == '(') || (c == '[')) {
                stack[++top] = c;
            }
        }
        return true;
    }
}
