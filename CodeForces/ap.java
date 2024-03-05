package CodeForces;

import java.util.Scanner;

public class ap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k  =sc.nextInt();
        int n= sc.nextInt();
        int w = sc.nextInt();
        int tot_cost = ((w*(w+1))/2)*k;
        // System.out.println(tot_cost-n);
        if (tot_cost >=n){
            System.out.println(tot_cost-n);
        }else{
            System.out.println(0);
        }
    }
}
