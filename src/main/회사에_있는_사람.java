package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 회사에_있는_사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            List<String> key = new ArrayList<>();
            for(int j=0; j<2; j++){
                key.add(st.nextToken());
            }
            map.put(key.get(0), key.get(1));
        }

        List<String> answer = new ArrayList<>();
        for(String key : map.keySet()){
            if (!map.get(key).equals("leave")){
                answer.add(key);
            }
        }
        Collections.sort(answer, Collections.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<answer.size(); i++){
            stringBuilder.append(answer.get(i)).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(stringBuilder));
        bw.flush();
        bw.close();
    }
}
