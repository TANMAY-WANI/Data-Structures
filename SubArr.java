import java.util.ArrayList;

public class SubArr {
    
    static int getAns (int nums[],int k,int p){
        ArrayList<ArrayList<Integer>> myList = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                // System.out.print(nums[j]);
                ArrayList<Integer> subarr = new ArrayList<>();
                for (int m = i;m<=j;m++){
                    subarr.add(nums[m]);
                }
                if (myList.contains(subarr)){
                    continue;
                }else{
                    myList.add(subarr);
                }

            }
        }
        // System.out.println();
        int ans = 0;
        for (int i=0;i<myList.size();i++){
            // System.out.println(myList.get(i));
            int count = 0;
            ArrayList subList = myList.get(i);
            for (int j=0;j<subList.size();j++){
                if ((int)subList.get(j)%p==0){
                    count++;
                }
            }
            if (count<=k){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // int arr[] = {1,2,3,4};
        int arr[] = {52,70,21,67,49,74,97,66,15,79,42,30,64,83,23,36,30,81,31,37,3,82,54,4,21,88,33,44,13,21,47,11,59,35,55,40,97,64,57,40,44,79,31,26,97,18,17,53,66,10,11,40,23,28,97,80,47,96,59,90,74,88,37,70,81,61,34,42,43,3,77,5,19,11,12,42,9,20,20,59,86,92,88,83,76,76,45,51,80,26,98,31,18,43,9,2,44,96,14,58,85,56,63,100,49,59,48,5,26,39,87,27,49,96,77,13,14,15,59,11,32,85,95,38,61,98,38,49};
        System.out.println(getAns(arr, 127, 23));
    }
}
