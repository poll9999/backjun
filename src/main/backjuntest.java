package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class backjuntest {
    public static void main(String[] args) throws IOException {
        char[] UCPC = {'U', 'C', 'P', 'C'};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();  //int 형일경우 int result = Integer.parseInt(br.readLine());

        int index=0;

        for(int i=0; i<str.length(); i++){
            if(UCPC[index] == str.charAt(i)){
                index++;
            }
            if(index == 4) {
                System.out.println("I love UCPC");
                return; //return은 main함수를 종료, break는 for문을 종료
            }
        }
        System.out.println("I hate UCPC");

    }
}
