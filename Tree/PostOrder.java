package Tree;

public class PostOrder {
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

    // inorder traversal

    static void inOrder(Node root){
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    static void preOrder(Node root){
        if (root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        
        // Create a small tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        postOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        preOrder(root);
    }
}
