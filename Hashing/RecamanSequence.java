import java.util.ArrayList;

public class RecamanSequence{
    static ArrayList <Integer> optimisedApproach(int n){
        ArrayList<Integer> myLst = new ArrayList<>();
        int ans;
        // HashMap <Integer,Integer> myMap = new HashMap<>();
        for (int i=0;i<n;i++){
            if (i==0){
                myLst.add(0);
            }
            else{
                ans = myLst.get(i-1)-i;
                if (myLst.contains(ans) || ans <0){
                    myLst.add(myLst.get(i-1)+i);
                }
                else{
                    myLst.add(ans);
                }
            }
        }
        return myLst;
    }
    
    public static void main(String[] args) {
        int n = 6;
        System.out.println(optimisedApproach(n));
    }
}