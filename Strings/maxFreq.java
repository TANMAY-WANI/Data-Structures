import java.util.ArrayList;

public class maxFreq {
    static char brutForce(String s,int n,char x,char y){
        // System.out.println(x);
        // System.out.println(y);
        ArrayList<String> substr = new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=i+1;j<=n;j++){
                if (!substr.contains(s.substring(i,j)))substr.add(s.substring( i,j));
            }
        }
        // System.out.println(substr);
        int count_x = 0,count_y = 0;
        for (int i=0;i<substr.size();i++){
            
            String str = substr.get(i);
            boolean isValid = true;
            // System.out.println(str);
            // System.out.println((char)x);
            for (int k=0;k<str.length();k++){
                if (str.charAt(k)!=x&& str.charAt(k)!=y){
                    isValid = false;
                    break;
                }
            }
            // System.out.println(isValid);
            if (isValid && str.contains(String.valueOf(x)))count_x++;
            if (isValid && str.contains(String.valueOf(y)))count_y++;
        }
        // System.out.println(count_x);
        // System.out.println(count_y);
        return count_x>=count_y ? x:y;
    }
    // optimised approach
    static char optimisedApproach(String s,char x,char y){
        int count_x = 0,count_y = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==x)count_x++;
            if (s.charAt(i)==y)count_y++;
        }
        return count_x>count_y?x:y;
    }
    public static void main(String[] args) {
        String s = "4894799";
        char x = '4';
        char y = '9';
        // System.out.println(brutForce(s, s.length(), x, y));
        System.out.println(optimisedApproach(s, x, y));
    }
}
