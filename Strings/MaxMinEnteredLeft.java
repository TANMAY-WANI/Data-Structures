import java.util.Scanner;

public class MaxMinEnteredLeft{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binStr = sc.nextLine();
        int n = binStr.length();
        int left = 0;
        int entered = 0;
        int unique = 0;
        for (int i=0;i<n;i++){
            Character b = binStr.charAt(i);
            if (b.equals('1')){
                if (left==0){
                    unique++;
                    entered++;
                }else{
                    left--;
                    entered++;
                }
            }else if (b.equals('0')){
                if (entered!=0){
                    left++;
                    entered--;
                }else{
                    left++;
                    unique++;
                }
            }
        }
        System.out.println("Minimum Persons: "+unique);
        System.out.println("Maximum Persons: "+n);
        sc.close();
    }
}