package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer=what(number);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10000));
    }
    public static int what(int n){
        int sum=0;
        for(int i=0; i<=n; i++){
            sum+=how(i);
        }
        return sum;
    }
    public static int how(int n){
        int count=0;
        while(n!=0) {
            if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) {
                count++;
            }
            n/=10;
        }
        return count;
    }
}

