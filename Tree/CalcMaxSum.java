package Tree;

import java.util.*;

public class CalcMaxSum {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
    }

    static HashMap<Integer, ArrayList<Integer>> myList = new HashMap<>();
    static void preOrder(Node root,Node prev){
        if (root == null){
            return;
        }

        ArrayList<Integer> curList = new ArrayList<>();
        if (root.right !=null){

            curList.add(root.right.data);
        }
        if(root.left!=null){
            curList.add(root.left.data);
        }
        if (prev!=null){
            curList.add(prev.data);
        }
        myList.put(root.data, curList);
        preOrder(root.left,root);
        preOrder(root.right,root);
    }
    static int getSum(Node root){
        return -1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        preOrder(root,null);
        System.out.println(myList);
    }
}
