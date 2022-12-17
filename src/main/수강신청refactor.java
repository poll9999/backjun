package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수강신청refactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<String> count = new ArrayList<>();
        for(int i=0; i<2; i++){
            count.add((st.nextToken()));
        }
        String aCount = count.get(0);
        String bCount = count.get(1);

        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Integer.parseInt(aCount); i++){
            A.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Integer.parseInt(bCount); i++){
            B.add(st.nextToken());
        }

        int result=0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<A.size(); i++){
            if(!B.contains(A.get(i))){
                result++;
                stringBuilder.append(A.get(i)).append(" ");
            }
        }
        System.out.println(result);
        if(result!=0) {
            System.out.print(stringBuilder);
        }
    }
}
