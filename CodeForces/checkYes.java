package CodeForces;

import java.util.ArrayList;
import java.util.Scanner;

public class checkYes {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);

        int size = sc.nextInt();
        ArrayList<String> myList= new ArrayList<>();
        for (int i=0;i<size;i++){
            myList.add(sc.next());
        }
        for (int i=0;i<size;i++){
            if (myList.get(i).equalsIgnoreCase("yes")){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
