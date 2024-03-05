package CodeForces;

import java.util.ArrayList;
import java.util.Scanner;

public class fairDivison {
    static Scanner sc = new Scanner(System.in);
    static String getAns(ArrayList<Integer> myList){
        int two_g =0, one_g = 0;
        for (int i=0;i<myList.size();i++){
            if (myList.get(i)==1){
                one_g++;
            }else{
                two_g++;
            }
        }
        int tot =  two_g*2+one_g;
        if (tot%2 == 0){
            if (one_g%2==0 && two_g%2==0){
                return "YES";
            }
            if (two_g%2 != 0 && one_g>0){
                if (one_g%2==0){
                    return "YES";
                }else{
                    return "NO";
                }
            }else{
                return "NO";
            }
        }else{
            return "NO";
        }
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (t>0){
            t--;
            int n = sc.nextInt();
            ArrayList<Integer> myList = new ArrayList<>();
            for (int i=0;i<n;i++){
                myList.add(sc.nextInt());
            }
            list.add(myList);
        }

        for (int i=0;i<list.size();i++){
            System.out.println(getAns(list.get(i)));
        }
    }
}
