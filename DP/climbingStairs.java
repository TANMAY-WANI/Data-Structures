public class climbingStairs {
    static int countWays(int n,int [] dp){
        if (n==2){
            return 2;
        }
        if (n==1){
            return 1;
        }
        if (n<=0){
            return 0;
        }
        if (dp[n]!=-1){
            return dp[n];
        }

        return dp[n] = countWays(n-1,dp)+countWays(n-2,dp);
    }
    public static void main(String[] args) {
        int n = 20;
        int dp[] = new int[n+1];
        for (int i=0;i<=n;i++){
            dp[i] = -1;
        }
        System.out.println(countWays(n,dp));
    }
}
