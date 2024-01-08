import java.util.HashMap;

public class longestIncSubSeq {
    static int brutForce(int arr[],int n){
        int maxLen = 0;
        for (int i=0;i<n;i++){
            int ctr = 1;
            int lenCount = 1;
            for (int j=i+1;j<n;j++){
                if (arr[j] ==(arr[i]+ctr)){
                    ctr++;
                    lenCount++;
                }
                // Else skip the element
            }
            maxLen = Math.max(maxLen,lenCount);
        }
        return maxLen;
    }

    static int optimisedApproach(int arr[],int n){
        int maxLen = 0;
        HashMap<Integer,Integer> myMap = new HashMap<>();
        // Concept: we would assume that a given element arr[i] is a part of subsequence and store the length of the subsequence for that element
        // If a new element if found, we would get length of its left sub-part and right sub-part from the map
        // Using these, we would calculate the length of new subsequence by adding this element and store the same into the map
        for (int i=0;i<n;i++){
            if (myMap.containsKey(arr[i])){
                continue;
            }
            int left_part = myMap.getOrDefault(arr[i]-1, 0);
            int right_part = myMap.getOrDefault(arr[i]+1, 0);
            int cur_leng = left_part+right_part+1;
            maxLen = Math.max(maxLen,cur_leng);
            myMap.put(arr[i],cur_leng);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int a[] = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12};
        // int a[] = {6, 7, 8, 3, 4, 5, 9, 10} ;
        // int a[] = {1,3,5,4,7};
        int n = a.length;
        // System.out.println(brutForce(a, n));
        System.out.println(optimisedApproach(a, n));
    }
}
