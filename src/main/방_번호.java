package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방_번호 {
    private static int max = Integer.MIN_VALUE;
    private static final int[] result = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] data = br.readLine().toCharArray();

        for (char c : data) {
            int number = c - 48;
            if (number == 6) {
                result[9]++;
            } else {
                result[number]++;
            }
        }

        for (int i = 0; i < result.length - 1; i++) {
            max = Math.max(max, result[i]);
        }

        int ninthIndex = result[9] / 2;
        if (result[9] % 2 == 1) {
            ninthIndex++;
        }
        max = Math.max(max, ninthIndex);
        System.out.print(max);
    }
}
