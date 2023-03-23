package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {
    private static int N;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int[] data;
    private static int[] operator = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, data[0]);

        System.out.println(max);
        System.out.print(min);
    }

    private static void dfs(int index, int dataNumber) {
        if(index==N) {
            max = Math.max(max, dataNumber);
            min = Math.min(min, dataNumber);
            return;
        }

        for(int i=0; i<4; i++) {
            if (operator[i]>0) {
                operator[i]--;
                if (i==0) {
                    dfs(index+1, dataNumber+data[index]);
                }
                if (i==1) {
                    dfs(index+1, dataNumber-data[index]);
                }
                if (i==2) {
                    dfs(index+1, dataNumber*data[index]);
                }
                if (i==3) {
                    dfs(index+1, dataNumber/data[index]);
                }
                operator[i]++;
            }
        }
    }
}
