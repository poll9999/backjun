package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {
    static int[] data;
    static int N;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];

        dfs(0);
        System.out.print(count);
    }

    public static void dfs(int row){
        if (row==N){
            count++;
            return;
        }

        for (int i=0; i<N; i++){
            data[row] = i;
            if (check(row)){
                dfs(row+1);
            }
        }
    }

    public static boolean check(int column){
        for (int i=0; i<column; i++){
            if (data[column]==data[i]){
                return false;
            }
            else if (Math.abs(column-i)==Math.abs(data[column]-data[i])){
                return false;
            }
        }

        return true;
    }
}
