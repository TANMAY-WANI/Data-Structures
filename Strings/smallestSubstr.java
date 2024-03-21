import java.util.ArrayList;

public class smallestSubstr {
    static int brutForce(String s,int n){
        ArrayList<String> substr = new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                // System.out.println(s.substring(i,j));
                if (!substr.contains(s.substring(i,j))){
                    substr.add(s.substring(i, j));
                }
            }
        }
        int minLen = Integer.MAX_VALUE;
        for (int i=0;i<substr.size();i++){
            String s1 = substr.get(i);
            if (s1.contains("0")&&s1.contains("1")&&s1.contains("2")){
                minLen = Math.min(minLen, s1.length());
            }
        }
        // System.out.println(substr);
        return minLen<Integer.MAX_VALUE ? minLen:-1;
    }

    static int optimisedApproach(String s,int n){
        int idx1 = -1,idx2 = -1,idx0 = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i=0;i<=n;i++){
            if (idx0!=-1 && idx1!=-1 && idx2!=-1){
                int minVal = Math.min(idx0,Math.min(idx1,idx2));
                int maxVal = Math.max(idx0, Math.max(idx1, idx2));
                int len = maxVal-minVal+1;
                minLen = Math.min(minLen, len);
            }
            if (i==n)break;
            if (s.charAt(i)=='0') idx0 = i;
            if (s.charAt(i)=='1')idx1 = i;
            if (s.charAt(i)=='2')idx2=i;
        }
        return minLen<Integer.MAX_VALUE ? minLen:-1;
    }
    public static void main(String[] args) {
        String s = "01122";
        // System.out.println(brutForce(s,s.length()));
        System.out.println(optimisedApproach(s, s.length()));
    }
}
