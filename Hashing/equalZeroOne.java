import java.util.HashMap;

public class equalZeroOne {
    static int brutForce(int arr[],int n){
        int maxLen = 0;
        for (int i=0;i<n;i++){
            int count_0 = 0;
            int count_1 = 0;
            for (int j = i;j<n;j++){
                if (arr[j] == 1){
                    count_1++;
                }
                if (arr[j] == 0){
                        count_0++;
                }
                if (count_0==count_1){
                    int curLen = j-i+1;
                    maxLen = Math.max(maxLen, curLen);
                }
            }
        }
        return maxLen;
    }

    static int optimisedApproach(int arr[],int n){
        int maxLen = 0;
        HashMap <Integer,Integer> myMap = new HashMap<>();
        for (int i=0;i<n;i++){
            if (arr[i]==0){
                arr[i] = -1;
            }
        }
        int sum = 0;
        for (int i=0;i<n;i++){
            sum+=arr[i];
            if (sum == 0){
                maxLen=i+1;
            }
            else{
                if (myMap.containsKey(sum)){
                    // The sum is obtained first.
                    // This means that from prev index till i the sum = 0
                    maxLen = Math.max(maxLen, i-myMap.get(sum));
                }else{
                    myMap.put(sum,i);
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] =  {0,0,1,0,0};
        // int arr[] = {0,1,0,1};
        int n = arr.length;
        // System.out.println(brutForce(arr, n));
        System.out.println(optimisedApproach(arr, n));
    }
}
