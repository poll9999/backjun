package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class FindPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> a = new ArrayList<>();

        for(int i=0; i<2; i++){
          a.add(Integer.valueOf(st.nextToken()));
        }
        int N=a.get(0);
        int M=a.get(1);

        HashMap<String, String> map = new HashMap<>();
        List<String> key = new ArrayList<>();
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine(), " ");
            key = new ArrayList<>();
            for(int j=0; j<2; j++){
                key.add(st.nextToken());
            }
            map.put(key.get(0), key.get(1));
        }

        List<String> result = new ArrayList<>();
        for(int i=0; i<M; i++){
            result.add(br.readLine());
        }

        StringBuilder answer = new StringBuilder();
        for(int i=0; i<result.size(); i++){
            if(map.containsKey(result.get(i))){
                answer.append(map.get(result.get(i))).append("\n");
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
