package CodeForces;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimizeNos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t>0){
            t--;
            int curr = sc.nextInt();
            int i = curr;
            System.out.println(2);
            for (int j=curr-1;j>0;j--){
                System.out.println(i+" "+j);
                i = (i+j+1)/2;
            }
        }
    }
}
