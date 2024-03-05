package CodeForces;

import java.util.Scanner;

public class QuesFour {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            t--;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int c = 1;
            boolean flag = true;
            int m = 1;
            while (flag){
                int x = 1;

                for (int i=1*m;i<=n;i=m*(2*x+1),x++){
                    if (flag){
                        if (k == c){
                            // System.out.println(i);
                            flag =false;
                        }else{
                            c++;
                        }
                    }
                }
                System.out.println(c);
                m++;
            }
            // System.out.println(c);
// 1
// 3
// 5
// 7
// 2
// 6
// 3
// 1
// 27
// 37
// 666666660


        }
    }
}
