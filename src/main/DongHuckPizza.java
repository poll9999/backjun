package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DongHuckPizza {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int count=1;
        while(true){
            st=new StringTokenizer(br.readLine());

            if(st.countTokens()==1){
                break;
            }
            int r=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            int l=Integer.parseInt(st.nextToken());

            double result = Math.sqrt(Math.pow(w, 2) + Math.pow(l, 2));

            if(2*r>=result){
                sb.append("Pizza ").append(count).append(" fits on the table.").append("\n");
            }
            else {
                sb.append("Pizza ").append(count).append(" does not fit on the table.").append("\n");
            }
            count++;
        }
        System.out.println(sb);
    }
}