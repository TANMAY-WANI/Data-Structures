package Hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;

public class hourglassSum {
    static int getAns(LinkedList<LinkedList<Integer>> arr){
        int maxSum = Integer.MIN_VALUE;
        for (int i=0;i<arr.size()-2;i++){
            // row selection
            // i,i+1,i+2
            // ArrayList<Integer> window = new ArrayList<>();
            for (int j=0;j<arr.get(i).size()-3;j++){
                System.out.println(arr.get(i).get(j));
            }

            
        }
        return maxSum;
    }
    public static void main(String[] args) {
        
    }
}
