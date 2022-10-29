package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(error(pobi)==true || error(crong)==true){
            answer = -1;
        }
        else {
            if (myBiggest(pobi) < myBiggest(crong)) {
                answer = 2;
            } else if (myBiggest(pobi) > myBiggest(crong)) {
                answer = 1;
            } else
                answer = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(99, 102);
        List<Integer> crong= List.of(211, 212);
        System.out.println(solution(pobi, crong));

    }

    public static int add(int a){
        int result=a;
        int sum=0;
        while(result!=0){
            sum+=result%10;
            result/=10;
        }
        return sum;
    }
    public static int multi(int a){
        int result=a;
        int sum=1;
        while(result!=0){
            sum*=result%10;
            result/=10;
        }
        return sum;
    }
    public static int myBiggest(List<Integer> a){
        int result1=Math.max(add(a.get(0)), add(a.get(1)));
        int result2=Math.max(multi(a.get(0)), multi(a.get(1)));
        int result=Math.max(result1, result2);

        return result;
    }

    public static boolean error(List<Integer> a){
        if(a.get(0)!=a.get(1)-1){
            return true;
        }
        else return false;
    }
}