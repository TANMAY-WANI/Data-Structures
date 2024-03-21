public class Sol1 {
    static String getAns(String[] strs){
        String commonPrefix = "";
        String minLen = "";
        int len = Integer.MAX_VALUE;
        for (int i=0;i<strs.length;i++){
            if (strs[i].length() < len){
                len = strs[i].length();
                minLen = strs[i];
            }
        }
        
        System.out.println(commonPrefix);

        return commonPrefix;
    }
    public static void main(String[] args) {
        String [] arr = {"flow","fl","hi"};
        System.out.println(getAns(arr));
    }
}
