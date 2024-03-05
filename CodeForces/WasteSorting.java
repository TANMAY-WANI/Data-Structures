package CodeForces;

import java.util.*;

public class WasteSorting {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            t--;
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            int c3 = sc.nextInt();
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int a3 =  sc.nextInt();
            int a4 = sc.nextInt();
            int a5 = sc.nextInt();
            if (c1>=a1 && c2>=a2 && c3>=a3){
                c1-=a1;
                a1 = 0;
                c2-=a2;
                a2 = 0;
                c3-=a3;
                a3 = 0;
            }
            if (c1>0){
                // Accomodate a4 all inside c1
                if (c1>=a4){
                    // All of it is in c1
                    c1-=a4;
                    a4 = 0;
                }else{
                    a4-=c1;
                    c1 = 0;
                }
            }
            if (c2>0){
                // Accomodate a5 all inside c2
                if (c2>=a5){
                    // All of it is in c2
                    c2-=a5;
                    a5 = 0;
                }else{
                    a5-=c2;
                    c2 = 0;
                }
            }
            if (a4 >0 && c3>0){
                if (c3>=a4){
                    a4 = 0;
                    c3-=a4;
                }else{
                    c3 = 0;
                    a4-=c3;
                }
            }
            if (a5>0 && c3>0){
                if (c3>=a5){
                    a5 = 0;
                    c3-=a5;
                }else{
                    c3 = 0;
                    a5-=c3;
                }
            }

            if (a1==0 && a2 == 0 && a3==0 && a4==0 && a5==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

    }
}
