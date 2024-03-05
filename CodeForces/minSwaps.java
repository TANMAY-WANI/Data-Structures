package CodeForces;

import java.util.Scanner;

public class minSwaps {
    static int findIndex(int arr[],int val){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==val){
                return i;
            }
        }
        return -1;
    }
    static int findminIndex(int arr[],int val){
        for (int i=arr.length-1;i>=0;i--){
            if (arr[i]==val){
                return i;
            }
        }
        return -1;
    }
    static int calcMinSwaps(int arr[]){
        int max = Integer.MIN_VALUE;
        int min  = Integer.MAX_VALUE;

        for (int i=0;i<arr.length;i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int idx_min = findminIndex(arr, min);
        int idx_max = findIndex(arr, max);


        int count_swaps = idx_max+arr.length-1-idx_min;
        if(idx_max>idx_min){
            return count_swaps-1;
        }
        return count_swaps;
    }
    static int[] inputArr(int n){
        int arr[] = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    
        int size = sc.nextInt();
        int arr[] = inputArr(size);
        System.out.println(calcMinSwaps(arr));
    }
}
