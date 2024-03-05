package CodeForces;

import java.util.Scanner;

public class QuesTwo {
    static boolean isSquare(int[][] matrix,int size){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if (matrix[i][j] == 1){
                    // if (matrix[i][j+1] == 1){
                    //     return true;
                    // }else{
                    //     return false;
                    // }
                    
                }
            }
        }
        return false;
    }

    static int[][] takeMatrix(int n){
        int [][] matrix = new int[n][n];
        for (int i=0;i<n;i++){
            String s= sc.next();
            for (int j=0;j<n;j++){
                matrix[i][j] = Integer.valueOf(s.charAt(j))-48;
                // System.out.println(s);
                // System.out.println(matrix[i][j]);
            }
        }
        return matrix;
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int test_cases= sc.nextInt();
        while (test_cases>0){
            test_cases--;
            int n = sc.nextInt();
            int [][] matrix = takeMatrix(n);
    
            // for (int i=0;i<n;i++){

            //     for (int j=0;j<n;j++){
            //         System.out.print(matrix[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            if (isSquare(matrix,n)){
                System.out.println("SQUARE");
            }else{
                System.out.println("TRIANGLE");
            }
        }

    }
}
