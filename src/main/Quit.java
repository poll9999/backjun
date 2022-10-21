package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quit{
    public static void main(String[] args) throws IOException {
        //14501
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] T = new int[n];
        int[] P = new int[n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n+1];

        for (int i=0; i<n; i++) {
            if (i + T[i] <= n) {

                result[i + T[i]] = Math.max(result[i + T[i]], result[i] + P[i]);
            }

            result[i+1] = Math.max(result[i+1], result[i]);
        }
        System.out.println(result[n]);

    }
}
