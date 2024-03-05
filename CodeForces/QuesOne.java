package CodeForces;

import java.util.Scanner;

public class QuesOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int text_cases = sc.nextInt();
        while(text_cases>0){
            text_cases--;
            String str = sc.next();
            int count_A = 0,count_B=0;
            for (int i=0;i<5;i++){
                if (str.charAt(i) == 'A'){
                    count_A++;
                }else{
                    count_B++;
                }
            }
            if (count_A>count_B){
                System.out.println("A");
            }else{
                System.out.println("B");
            }
        }
    }
}