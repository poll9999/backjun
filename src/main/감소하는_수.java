package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는_수 {
    static List<Integer> data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        data = new ArrayList<>();

        if (N<=10){
            System.out.println(N);
        }
        else if (N>1022){
            System.out.println("-1");
        }
        else {
            for (int i=0; i<10; i++){
                dfs(i, 1);
            }
            Collections.sort(data);
            System.out.println(data.get(N));
        }

    }

    public static void dfs(int number, int index){
        if (index>10){
            return;
        }
        data.add(number);

        for (int i=0; i<10; i++){
            if (number%10 > i){
                dfs((number*10)+i, index+1);
            }
        }
        return;
    }
}