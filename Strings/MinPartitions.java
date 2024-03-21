public class MinPartitions {
    static int getPartitions(String s,int n,int target){
        int curr = Integer.parseInt(Character.toString(s.charAt(0)));
        // System.out.println(curr);
        int partitions = 0;
        for (int i=1;i<n;i++){
            int temp =  Integer.parseInt(Character.toString(s.charAt(i)));
            if (curr*10 + temp > target){
                partitions++;
                curr =temp;
                // System.out.println(curr);
            }else{
                curr = curr*10+temp;
                // System.out.println(curr);
            }
        }
        return partitions;
    }
    public static void main(String[] args) {
        String s = "3456";
        int k = 45;
        // System.out.println(getPartitions(i, j, s, 45));
        // System.out.println(count);
        System.out.println(getPartitions(s,s.length(), k));
    }
}
