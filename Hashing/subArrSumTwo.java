import java.util.HashMap;

public class subArrSumTwo {
    static int brutForce(int arr[],int n,int target){
        int count = 0;
        for (int i=0;i<n;i++){
            int sum = 0;
            for (int j=i;j<n;j++){
                sum+=arr[j];
                if (sum == target){
                    count++;
                }
            }
        }
        return count;
    }

    static int optimisedApproach(int arr[],int n,int sum){
        HashMap <Integer,Integer> myMap = new HashMap<>();
        int count = 0;
        int s = 0;
        for (int i=0;i<n;i++){
            s+=arr[i];
            if (sum ==0){
                if (myMap.containsKey(s)){
                    count++;
                }
            }else{
                if (myMap.containsKey(s)){
                    // Required sum is not zero and we have added up to the same sum means that the subsequence in between is of zero sum
                    continue;
                }else{
                    System.out.println(s-sum);
                    if (myMap.containsKey(s-sum)){
                        // System.out.println("hello");
                        count++;
                    }
                    myMap.put(s,1);
                    System.out.println(myMap);
                }
            }
        }
        return count;
    }   
    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        int n = arr.length;
        int target = -10;
        // System.out.println(brutForce(arr, n, target));
        System.out.println(optimisedApproach(arr, n, target));
    }
}
