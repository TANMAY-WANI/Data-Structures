package Tree;
import java.util.*;

public class BTtoBST {

    static Integer getKeyFromValue(HashMap<Integer, Integer> map, Integer value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null; // Value not found in the HashMap
    }
    static int minSwaps(int n, int[] A) {
        // code here
        ArrayList<Integer> in=new ArrayList<>();
        findInorder(n,A,in,0);
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for (int i=0;i<n;i++){
            myMap.put(i,in.get(i));
        }
        System.out.println(in);
        System.out.println(myMap);
        Collections.sort(in);
        System.out.println(in);
        int count = 0;
        for (int i=0;i<n;i++){
            if (in.get(i)!=myMap.get(i)){
                count++;
                int idx = in.indexOf(myMap.get(i));
                Collections.swap(in, i, idx);
            }
        }
        System.out.println(in);
        System.out.println(count);
        // for (int i=0;i<n;i++){
        //     if (in _orig.get(i)!=in.get(i)){
        //         count++;
        //         Collections.swap(in,in _orig.get(i),in.get(i));
        //     }
        // }
        return -1;
        
        
        
        // TreeMap<Integer,Integer> tree=new TreeMap<>();
        // for(int i=0;i<in.size();i++){
        //     tree.put(in.get(i),i);
        // }
        // int count=0;
        // int i=0;
        // for(Map.Entry<Integer,Integer> entry : tree.entrySet()) {
        
        //     if(entry.getKey()!=i)
        //     count++;
        //     i++;
        // }

        // return count/2;
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
