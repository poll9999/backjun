package main;

public class SelfNumber {
    public static void main(String[] args) {

        int index = 10000;
        boolean[] nums = new boolean[index];

        for(int i=0; i<nums.length; i++) {
            if(self(i+1) < index+1)
                nums[self(i+1)-1] = true;
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == false)
                System.out.println(i+1);
        }
    }

    public static int self(int N) {

        String str = Integer.toString(N);

        for(int i=0; i<str.length(); i++) {
            N += Integer.parseInt(str.substring(i, i+1));
        }

        return N;
    }
}