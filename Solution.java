class Solution {
    static boolean isSquare(int s1,int s2,int s3,int s4,int[] arr, int idx){
        if (idx == arr.length && s1==s2 && s1==s3 && s1==s4){
            return true;
        }
        if (idx==arr.length){
            return false;
        }
        return isSquare(s1+arr[idx], s2, s3, s4, arr, idx+1) || isSquare(s1, s2+arr[idx], s3, s4, arr, idx+1) || isSquare(s1, s2, s3+arr[idx], s4, arr, idx+1) || isSquare(s1, s2, s3, s4+arr[idx], arr, idx+1);
    }
    static boolean makesquare(int[] matchsticks) {

        // Handling corner cases
        if (matchsticks.length < 4){
            return false;
        }
        if (matchsticks.length == 4){
            int l1 = matchsticks[0];
            for (int i=1;i<4;i++){
                if (l1 != matchsticks[i]) return false;
            }
            return true;
        }
        if (isSquare(0, 0, 0, 0, matchsticks, 0)){
            return true;
        }else{
            return false;
        }


    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10,5,4,3,2,1};
        System.out.println(makesquare(arr));
    }
}