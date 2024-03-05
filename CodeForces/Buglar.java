package CodeForces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Buglar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        // ArrayList<Integer> matches = new ArrayList<>();

        // HashMap<Integer,Integer> matches = new HashMap<>();
        TreeMap<Integer,Integer> myMap = new TreeMap<>();
        for (int i=0;i<m;i++){
            // myMap.put(sc.nextInt(),sc.nextInt());
            int key = sc.nextInt();
            int value = sc.nextInt();
            myMap.put(value,key);
        }
        Map<Integer,Integer> map = myMap.descendingMap();
        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int no_of_matches = entry.getKey();
            int no_of_boxes = entry.getValue();
            if (n==0){
                break;
            }
            if (n>=no_of_boxes){
                n-=no_of_boxes;
                answer += (no_of_matches*no_of_boxes);
            }else{
                answer += (no_of_matches*n);
                n = 0;
            }
        }
        System.out.println(answer);
        

    }
}
