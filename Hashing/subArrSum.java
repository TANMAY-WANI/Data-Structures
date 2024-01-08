import java.util.HashMap;

public class subArrSum {
    static int brutForce(int arr[],int k){
        int count = 0;
        for (int i=0;i<arr.length;i++){
            int sum = 0;
            for (int j = i;j<arr.length;j++){
                sum+=arr[j];
                System.out.print(arr[j]+" ");
                if (sum%k == 0){
                    count++;
                }
            }
            System.out.println();
        }
        return count;
    }
    static int optimisedApproach(int nums[],int k){
        int count = 0;
        int sum = 0;
        // Concept: if the remainder gets repeted, we have added the quantity which is already divisible by the divisor
        HashMap<Integer,Integer> myMap = new HashMap<>();
        // Initialize the map for remainder = 0
        myMap.put(0, 1);
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            int temp = sum%k ;
            if (temp<0) temp+=k;
                // check if this remainder is already present in the map
                // if it is present from the point it has occured till this point is one such subarray whose sum is divisible by k
            if (myMap.containsKey(temp)){
                count+=myMap.get(temp);
                    // We have not done count++ because we have to consider all the points where the remainder had occured previously
            }
            // Increment the remainder count
            myMap.put(temp,myMap.getOrDefault(temp, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,0,-2,-3,1};
        int k = 5;
        // System.out.println(brutForce(arr, k));
        System.out.println(optimisedApproach(arr, k));
    }
}

