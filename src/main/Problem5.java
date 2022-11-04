package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return Arrays.asList(greedyCoin(money));
    }

    public static void main(String[] args) {
        int n=50237;
        List<Integer> result=solution(n);
        System.out.println(result);
    }

    public static Integer[] greedyCoin(int n){
        int [] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        Integer [] result=new Integer[9];
        for(int i=0; i<coins.length; i++){
            result[i]=n/coins[i];
            n %= coins[i];
        }
        return result;
    }
}