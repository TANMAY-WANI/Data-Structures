package DP;
import java.util.*;
public class fibonacci {
    static int Fib(int n,int [] dp){
        if (n<=1){
            return n;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        int fib_n = Fib(n-1, dp) + Fib(n-2, dp);
        dp[n] = fib_n;
        return fib_n;
    }
    static int fib_tab(int n){
        int dp[] = new int [n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    
    static int fib_tab_opt(int n){
        int first = 0;
        int sec = 1;
        int third=0;
        for (int i=2;i<=n;i++){
            third = first+sec;
            first = sec;
            sec = third;
        }
        return third;
    }
    public static void main(String[] args) {
        int n = 10;
        int dp[] = new int[n+1];
        for (int i=0;i<=n;i++){
            dp[i] = -1;
        }
        // System.out.println(Fib(n,dp));
        // System.out.println(fib_tab(n));
        System.out.println(fib_tab_opt(n));

    }
}
