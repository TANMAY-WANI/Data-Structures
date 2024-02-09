package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBinarytree {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    static boolean isCompleteBT(Node root)
    {
          //add code here.
        //   Leaf Node
          if (root.left == null && root.right == null){
              return true;
          }
          if (root.left == null || root.right == null){
              return false;
          }
          return isCompleteBT(root.left) && isCompleteBT(root.right);
	} 

    static boolean iterativeApproach(Node root){
        if (root == null){
            // Empty tree is a binary tree
            return true;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            Node curr = queue.remove();
            if (curr.left == null && curr.right == null){
                // leaf node
                continue;
            }else if (curr.left == null || curr.right == null){
                return false;
            }
            else{
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        // Constructing the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // System.out.println(isCompleteBT(root));
        System.out.println(iterativeApproach(root));

        
    }

}
