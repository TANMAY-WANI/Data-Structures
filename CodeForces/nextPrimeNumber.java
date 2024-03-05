package CodeForces;

import java.util.ArrayList;
import java.util.Scanner;

public class nextPrimeNumber {
    // Write a code to get a list of prime numbers upto n

    static int getNextPrime(int num){
        int iter = num+1;
        while (true){
            if (isPrime(iter)){
                return iter;
            }
            iter++;
        }
    }
    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    static boolean checkNext(int num1,int num2){
        int next_prime= getNextPrime(num1);
        if (next_prime==num2)return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int  num2 = sc.nextInt();
        if (checkNext(num1, num2)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
