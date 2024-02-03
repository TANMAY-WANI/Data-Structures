package Tree;

import java.util.ArrayList;

public class TreeHeight {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
    }

    static int getHeight(Node root){
        if (root == null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right)+1;
    }
    public static void main(String[] args) {
        // Creating a tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        System.out.println(getHeight(root));
    }

}
