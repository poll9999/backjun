package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BestSeller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        int data = Collections.max(map.values());
        List<String> result = new ArrayList<>();

        for(String key : map.keySet()){
            if (map.get(key)==data){
                result.add(key);
            }
        }
        Collections.sort(result);

        System.out.println(result.get(0));
    }
}
