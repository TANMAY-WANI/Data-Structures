package Tree;
import java.util.*;

public class BTtoBST {
    static int minSwaps(int n, int[] A) {
        // code here
        ArrayList<Integer> in=new ArrayList<>();
        findInorder(n,A,in,0);
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for (int i=0;i<n;i++){
            myMap.put(i,in.get(i));
        }
        Collections.sort(in);

        int count = 0;
        for (int i=0;i<n;i++){
            if (in.get(i)!=myMap.get(i)){
                count++;
                int idx = in.indexOf(myMap.get(i));
                Collections.swap(in, i, idx);
            }
        }
        return count;
    }
    public static void findInorder(int n, int[] A,ArrayList<Integer> in,int i){
        if(i>=A.length){
            return;
        }
        findInorder(n,A,in,2*i+1);
        in.add(A[i]);
        findInorder(n,A,in,2*i+2);
    }
    public static void main(String[] args) {
        int nodes[] = {5,6,7,8,9,10,11};
        minSwaps(nodes.length,nodes);
    }
}
