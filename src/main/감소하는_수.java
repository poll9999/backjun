package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는_수 {
    private static final List<Long> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
            return;
        } else if (N > 1022) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            dfs(i);
        }
        Collections.sort(data);
        System.out.println(data.get(N));
    }


    public static void dfs(long number) {
        data.add(number);
        long depth = number % 10;

        if (depth == 0) {
            return;
        }

        for (long i = depth - 1; i >= 0; i--) {
            dfs(depth + i);
        }
    }
}