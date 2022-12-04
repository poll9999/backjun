package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberCardTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        st= new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< M; i++){
            int key = Integer.parseInt(st.nextToken());
            stringBuilder.append(map.getOrDefault(key, 0)).append(' ');
        }

        System.out.println(stringBuilder);


    }
}
