package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckDup {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    static int dupSub(Node root) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int[] ans = new int[1];
        solve(map, ans, root);
        return ans[0];
    }

    static String solve(Map<String, Integer> map, int[] ans, Node root) {
        if (root == null) {
            return "#";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.data);
        }
        String a = solve(map, ans, root.left) +','+ solve(map, ans, root.right) +','+ Integer.toString(root.data);
        map.put(a, map.getOrDefault(a, 0) + 1);
        if (map.getOrDefault(a, 0) > 1) {
            ans[0] = 1;
        }


        return a;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(2);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(5);
        System.out.println(dupSub(root));
    }
    
}
