package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {
    static class  Node {
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
        
    }
    static void stdApproach(Node root){
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        boolean leftToRight = true;

        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            level++;
            for (int i = 0; i < levelSize; i++) {
                Node currNode = queue.poll();

                if (leftToRight) {
                    System.out.print(currNode.data + " ");
                } else {
                    stack.push(currNode);
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop().data + " ");
            }

            if (level % 2 == 0){
                leftToRight = !leftToRight;
            }
            System.out.println();
        }
    }
    // give a simple level order traversal of a binary tree that returns arraylist as outpu
    

    public static void main(String[] args) {
        // Build a tree

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        stdApproach(root);
        
    }
}
