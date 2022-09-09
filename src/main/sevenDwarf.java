package main;

import java.util.Arrays;
import java.util.Scanner;

public class sevenDwarf {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int index[]=new int[9];
        int result=0;
        int a=0, b=0;

        for(int i=0; i<9; i++){
            index[i]=sc.nextInt();
            result+=index[i];
        }
        Arrays.sort(index);

        /*
        9개의 숫자를 입력받아, 2개를 제외한 7개의 숫자들의 합이 100이 되어야 하는 문제이다.
        입력받은 모든 숫자를 모두 더해 result에 넣고, 오름차순으로 sort 시켰다.
        이제 2개를 제외하여 100을 만들어야한다.
        여기서 문제, 2개를 어떻게 제외할것인가?
         */
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++) {
                if (result - index[i] - index[j] == 100) {
                    a=i;
                    b=j;
                    break;
                }
            }
            /*
            2개를 제외하기 위해, result-index[i]-index[i+1]로 두고 해볼려하니
            오름차순으로 정렬된 배열에서, 이웃된 숫자만 빼진다는 것을 알아
            for문을 하나 더 만들었다.
            처음엔 너무 당연하게 for(int i=0; i<9){      for(int j=0; j<9)
            라고 썻었지만, 조합(Combination)으로 생각해보니
            9개의 숫자중 2개를 뽑는 과정이므로 9C2(=36), 즉 1+2+3+4+5+6+7+8=36번 반복하게 해야함을 알았다.
            따라서 for(int i=0; i<8;){     for(int j=i+1; j<9; 로 반복해야한다.
            그 후, 해당하는 i와 j를 찾으면, 다른 변수에 저장하고 loop문을 종료한다.
             */
        }

        for(int i=0; i<9; i++){
            if(i==a||i==b)
                continue;
            System.out.print(index[i]);
            System.out.print("\n");
        }
        /*
        배열을 출력할떄 2개를 제외하고 출력하는 방법이 기억이 안나다가,
        어제 파이썬에서 배웠던 continue가 떠올랐다.
        continue는 if문에서 조건이 달린 부분을 건너뛰고 계속 실행한다 라는 것을 까먹지 말아야겠다.
         */
    }
}
