package onboarding;

import java.util.*;

public class Problem7 {
    private static List<String> y=new ArrayList<>();
    private static Set<String> set=new HashSet<String>(y);
    private static List<String> z=new ArrayList<String>(set);
    private static List<Integer> x=new ArrayList<>();
    private static String MemberName="";
    private static Member member;
    private static int MemberScore=0;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return rank(user,friends, visitors);
    }
    public static void main(String[] args) {
        String user="mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(findscore(user, friends, visitors));
    }

    public static List<String> orgainze(String user, List<List<String>> friends, List<String> visitors) {
        y.clear(); z.clear(); set.clear();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                y.add(friends.get(i).get(j));
            }
        }
        for(int i=0; i<visitors.size(); i++){
            y.add(visitors.get(i));
        }
        z.remove(user);
        Collections.sort(z);
        return z;
    }
    public static List<String> rank(String user, List<List<String>> friends, List<String> visitors){
        y.clear();
        String[][] t=finalfind(user, friends, visitors);
        for(int i=0; i<t.length; i++){
            y.add(t[i][1]);
        }
        return y;
    }
    public static String[][] finalfind(String user, List<List<String>> friends, List<String> visitors){
        y.clear(); x.clear();
        y=findMember(user, friends, visitors);
        String[][] t=new String[x.size()][2];
        for(int i=0; i<x.size(); i++) {
            t[i][1]= y.get(i);
            t[i][0]= String.valueOf(x.get(i));
        }
        Arrays.sort(t, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }
        });
        return t;
    }

    public static List<Integer> findscore(String user, List<List<String>> friends, List<String> visitors){
        x.clear();
        member=new Member();
        for(int i=0; i<orgainze(user, friends, visitors).size(); i++) {
            member=makeMember(user, friends, visitors, i);
            if(member.score!=0){
                x.add(member.score);
            }
        }
        return x;
    }

    public static List<String> findMember(String user, List<List<String>> friends, List<String> visitors){
        y.clear();
        member=new Member();
        for(int i=0; i<orgainze(user, friends, visitors).size(); i++) {
            member=makeMember(user, friends, visitors, i);
            if(member.score!=0){
                y.add(member.user);
            }
        }
        return y;
    }
    public static Member makeMember(String user, List<List<String>> friends, List<String> visitors, int number){
        y.clear(); z.clear(); set.clear();
        MemberName=orgainze(user, friends, visitors).get(number);

        for(int i=0; i<friends.size(); i++){
            if(MemberName == friends.get(i).get(0)){
                y.add(friends.get(i).get(1));
            }
            else if(MemberName == friends.get(i).get(1)) {
                y.add(friends.get(i).get(0));
            }
        }
        MemberScore+=z.size()*10;

        for(int i=0; i<visitors.size(); i++){
            if(MemberName==visitors.get(i)){
                MemberScore++;
            }
        }

        for(int i=0; i<y.size(); i++){
            if(y.get(i)==user){
                MemberScore=0;
            }
        }
        Member m=new Member(MemberName, y, MemberScore);
        return m;
    }

    public static class Member{
        private String user;
        private List<String> friends;
        private int visit;
        private int score;
        public Member(){

        }
        public Member(String user, List<String> friends, int score){
            this.user=user;
            this.friends=friends;
            this.visit=visit;
            this.score=score;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public List<String> getFriends() {
            return friends;
        }

        public void setFriends(List<String> friends) {
            this.friends = friends;
        }

        public int getVisit() {
            return visit;
        }

        public void setVisit(int visit) {
            this.visit = visit;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
