package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {
        String X = "I Love1234 you";
        System.out.println(reversebigchar(X));
    }

    public static String reversebigchar(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 91 && s.charAt(i) >64) {
                char x = (char) ('A' + 'Z' - s.charAt(i));
                sb.append(x);
            }
            else if (s.charAt(i)<123 && s.charAt(i)>96){
                char x = (char) ('a' + 'z' - s.charAt(i));
                sb.append(x);
            }
            else{
                char x=s.charAt(i);
                sb.append(x);
            }
        }
        String x = sb.toString();
        return x;
    }

    public static String stringsplit(String s){
        String[] array=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<array.length; i++){
            sb.append(reversebigchar(array[i])).append(" ");
        }
        String x=sb.toString();
        return x;
    }
}