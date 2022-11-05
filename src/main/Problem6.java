package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return realcheck(forms);
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이엠슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(realcheck(forms));
    }
    public static List<String> realcheck(List<List<String>> x){
        List<String> y = new ArrayList<>();
        y.add(firstchecksum(x));
        for(int i=0; i<x.size(); i++){
            y.add(middlechecksum(x, i));
        }
        y.removeAll(Arrays.asList("", null));
        Collections.sort(y);
        return y;
    }
    public static String firstchecksum(List<List<String>> x){
        String data=new String();
        String result="";
        data=x.get(0).get(1);
        for(int i=0; i<x.size(); i++){
            if(check(data, x.get(i).get(1))) {
                result=x.get(0).get(0);
                break;
            }
        }
        return result;
    }

    public static String middlechecksum(List<List<String>> x, int k){
        String data=new String();
        String result="";
        data=x.get(k).get(1);
        for(int i=0; i<x.size()&i!=k; i++){
            if(check(data, x.get(i).get(1))) {
                result=x.get(k).get(0);
                break;
            }
        }
        return result;
    }

    public static boolean check(String x, String s){
        String data=new String();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<x.length()-1; i++){
            sb.append(x.charAt(i)).append(x.charAt(i+1));
            data=sb.toString();
            sb.setLength(0);
            if(s.contains(data)) {
                data=null;
                return true;
            }
        }
        return false;
    }
}