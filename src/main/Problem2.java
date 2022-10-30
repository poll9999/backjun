package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decrypt(cryptogram);
        while(true){
            answer=decrypt(answer);
            if(answer.length()==decrypt(answer).length()||decrypt(answer).length()==0){
                break;
            }
        }
        answer=decrypt(answer);
        return answer;
    }

    public static void main(String[] args) {
        String s = "zyelleyz";
        System.out.println(solution(s));
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(usedMemory+"bytes");
    }
    public static String decrypt(String s){
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0)!=s.charAt(1)){
            sb.append(s.charAt(0));
        }// 첫번째
        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)||s.charAt(i-1)==s.charAt(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }//중간
        if(s.charAt(s.length()-2)!=s.charAt(s.length()-1)){
            sb.append(s.charAt(s.length()-1));
        } //마지막
        String result=sb.toString();
        return result;
    }
}