package CodeForces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Staright {

    static int getMinAdded(int sum,int goal,int n){
        int count = 0;
        int avg = Math.round((float)sum/(float)n);

        while (avg!=goal) {
            sum+=goal;
            n++;
            count++;
            avg = Math.round((float)sum/(float)n);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        int goal = sc.nextInt();
        int sum =0;
        for (int i=0;i<n;i++){
            sum+=sc.nextInt();
        }
        System.out.println(getMinAdded(sum, goal, n));
    }


}