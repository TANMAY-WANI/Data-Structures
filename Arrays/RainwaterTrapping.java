public class RainwaterTrapping {

    static int getMaxVol(int[] height){
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = 0;
        rightMax[n-1] = 0;
        for (int i=0, j=1;i<n-1;i++,j++){
            leftMax[j] = Math.max(height[i],leftMax[i]);
        }
        for (int i=n-1,j=n-2;i>0;i--,j--){
            rightMax[j] = Math.max(height[i],rightMax[i]);
        }
        for (int i=0;i<leftMax.length;i++){
            System.out.print(leftMax[i]+" ");
        }
        System.out.println();
        for (int i=0;i<rightMax.length;i++){
            System.out.print(rightMax[i]+" ");
        }
        System.out.println();
        for (int i=0;i<height.length;i++){
            System.out.print(height[i]+" ");
        }
        System.out.println();
        int volume = 0;
        for (int i=0;i<n;i++){
            int factor = Math.min(leftMax[i],rightMax[i]);
            if (height[i]>factor){
                continue;
            }else{
                volume+=factor-height[i];
            }

        }
        return volume;
    }
    static int getMaxOptimised(int height[]){
        int n= height.length;
        int maxIdx = -1;
        int maxH= Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            if (maxH<height[i]){
                maxH = height[i];
                maxIdx = i;
            }
        }
        int leftMax = 0,rightMax =0;
        int vol = 0;
        for (int i=0;i<=maxIdx;i++){
            if (height[i]<=leftMax){
                vol+=leftMax-height[i];
            }
            if (height[i]>leftMax){
                leftMax=height[i];
            }
        }
        for (int i=n-1;i>=maxIdx+1;i--){
            if (height[i]<=rightMax){
                vol+=rightMax-height[i];
            }
            if (height[i]>rightMax){
                rightMax=height[i];
            }
        }
        return vol;
    }
    public static void main(String[] args) {
        // int heights[] = {3,2,1,4,5};
        int heights[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        // getMaxVol(heights);
        // System.out.println(getMaxVol(heights));
        System.out.println(getMaxOptimised(heights));
    }
}