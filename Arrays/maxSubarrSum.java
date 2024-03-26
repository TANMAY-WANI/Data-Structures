public class maxSubarrSum {
    static int getMaxSum(int arr[]){
        int n = arr.length;
        // if (n==1)return arr[0];
        // checking if all elements are negative
        boolean flag = true;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            if (arr[i]>=0)flag = false;
            max = Math.max(max,arr[i]);
        }
        if (flag){
            return max;
        }
        int maxSum  = 0;
        int curSum = 0;
        for (int i=0; i<n;i++){
            curSum+=arr[i];
            if (curSum<0){
                curSum=0;
            }
            
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {-4,-5,-18,-8,-9};
        System.out.println(getMaxSum(arr));
    }
}
