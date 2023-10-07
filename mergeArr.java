import java.util.Scanner;

public class mergeArr{

    public static Scanner sc = new Scanner(System.in);

    static void inputArr(int arr[]){
        for (int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
    }
    static int[] mergeSortedArrays(int arr1[],int m,int arr2[],int n){
        int newArr[] = new int[m+n];
        int iter = 0;
        int i1 = 0;
        int i2 = 0;
        while (iter < (m+n)){
            if (i1>= m){
                newArr[iter++] = arr2[i2++];
                continue;
            }
            if (i2 >= n){
                newArr[iter++] = arr1[i1++];
            }
            if (arr1[i1]>arr2[i2]){
                newArr[iter++] = arr2[i2++];
            }else{
                newArr[iter++] = arr1[i1++];
            }
        }
        for (int i=0;i<(m+n);i++){
            System.out.println(newArr[i]);
        }
        return newArr;
    }
    public static void main(String[] args) {
        int m = sc.nextInt();
        int arr1[] = new int[m];
        int  n = sc.nextInt();
        int arr2[] = new int[n];
        inputArr(arr1);
        inputArr(arr2);
        int mergedArray[] = mergeSortedArrays(arr1,m,arr2,n);
    }
}