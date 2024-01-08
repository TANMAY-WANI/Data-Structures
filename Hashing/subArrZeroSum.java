import java.util.HashMap;

public class subArrZeroSum {
    static int brutForce(int arr[],int n){
        int maxLen = 0;
        for (int i=0;i<n;i++){
            int sum = 0;
            for (int j=i;j<n;j++){
                sum+=arr[j];
                if (sum == 0){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }

    static int optimisedApproach(int arr[],int n){
        int maxLen = 0;
        HashMap<Integer,Integer> myMap = new HashMap<>();
        int sum = 0;
        myMap.put(0,0);
        // Key is the sum and the value is the first index of sum occurence
        for (int i=1;i<=n;i++){
            sum+=arr[i-1];
            if (myMap.containsKey(sum)){
                maxLen = Math.max(maxLen,i-myMap.get(sum));
            }else{
                myMap.put(sum,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int A[] = {15,-2,2,-8,1,7,10,23};
        // int A[] = {-1,1,-1,1};
        int n = A.length;
        // System.out.println(brutForce(A, n));
        System.out.println(optimisedApproach(A, n));
    }
}
