public class sample {
    static void diagonals(int arr[][],int n){
        System.out.println("Diagonal 1");
        for (int i=0;i<n;i++){
            System.out.print(arr[i][i]*arr[i][i]+" ");
        }
        System.out.println();

        System.out.println("Diagonal 2");
        int j=n-1;
        for (int i=0;i<n;i++){
            System.out.print(arr[i][j]*arr[i][j]+" ");
            j--;
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{2,3,4},{3,4,5}};
        diagonals(arr, 3);
    }
}
