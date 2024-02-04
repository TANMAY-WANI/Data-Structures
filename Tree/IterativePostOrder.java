package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class IterativePostOrder {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
    }

    static void postOrder(Node root){
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    static ArrayList<Integer> getPostOrder(Node root){
        ArrayList<Integer> myList = new ArrayList<>();

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()){
            Node curr = stack.pop();
            myList.add(curr.data);
            if (curr.left!=null){
                stack.push(curr.left);
            }
            if (curr.right!=null){
                stack.push(curr.right);
            }
        }
        Collections.reverse(myList);
        return myList;

    }
    public static void main(String[] args) {
        // create a tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(getPostOrder(root));
        postOrder(root);

    }
}
