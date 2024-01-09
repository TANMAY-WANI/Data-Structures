import java.util.HashMap;

public class PalindromeStr {
    static boolean brutForce(String str, int left, int right) {
        int mid = left + (right - left) / 2;
        for (int i = left, j = right; i < mid && j >= mid; i++, j--) {
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    static boolean optimisedApproach(String str,int left,int right){
        HashMap <Integer,Character> myMap = new HashMap<>();
        int mid = left + (right - left) / 2;
        int const_mid = mid;
        int ptr;
        if ((right-left+1)%2==0){
            ptr=0;
        }else{
            ptr = 1;
        }
        for (int i=left;i<=right;i++){
            if (i>const_mid){
                if (str.charAt(i)!=myMap.get(mid-ptr)){
                    return false;
                }
                ptr++;
            }else{
                myMap.put(i,str.charAt(i));
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String str = "abaaabaaaba";
        int left = 5;
        int right = 8;
        // System.out.println(brutForce(str, left, right));
        System.out.println(optimisedApproach(str, left, right));
    }
}
