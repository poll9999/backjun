package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이전_순열 {
    private static int N;
    private static int[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        if (backList(data)) {
            for (int i = 0; i < N; i++) {
                System.out.print(data[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean backList(int[] list) {
        int a = list.length - 1;
        while (a > 0 && list[a] >= list[a - 1]) {
            a--;
        }
        if (a <= 0) {
            return false;
        }

        int b = list.length - 1;
        while (list[a - 1] <= list[b]) {
            b--;
        }

        int c = list[a - 1];
        list[a - 1] = list[b];
        list[b] = c;
        b = list.length - 1;
        while (a < b) {
            c = list[a];
            list[a] = list[b];
            list[b] = c;
            a++;
            b--;
        }

        return true;
    }
}
