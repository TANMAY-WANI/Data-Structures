package CodeForces;

import java.util.Scanner;

public class holiday {
    static int[] inputArr(int n){
        int arr[] = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        int size= sc.nextInt();
        int arr[] = inputArr(size);
        int max = Integer.MIN_VALUE;
        for (int i=0;i<size;i++){
            max = Math.max(max, arr[i]);
        }
        int welfare_count = 0;
        for (int i=0;i<size;i++){
            welfare_count+=max-arr[i];
        }
        System.out.println(welfare_count);
    }
}
