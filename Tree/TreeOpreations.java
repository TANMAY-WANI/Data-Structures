package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public interface TreeOpreations {
    static class Node{
        int data;
        Node right,left;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node getTree(int nodes[]){
            idx++;
            if (nodes[idx]==-1){
                return null;
            }
            // root
            Node newNode = new Node(nodes[idx]);
            // left
            newNode.left  =  getTree(nodes);
            newNode.right = getTree(nodes);

            return newNode;

        }
    }

    static void preOrder(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node currNode = queue.remove();
            // For adding next line
            if (currNode == null){
                System.out.println();
                if (queue.isEmpty()){
                    break;
                }else{
                    queue.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if (currNode.left!=null){
                    queue.add(currNode.left);
                }
                if (currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
        }
    }

    static int countNodes(Node root){
        if (root == null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    static int sumNodes(Node root){
        if (root == null){
            return 0;
        }
        return  sumNodes(root.left)+sumNodes(root.right)+root.data;
    }
    static int height(Node root){
        if (root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

    static int diameter(Node root){

        if (root == null){
            return 0;
        }
        // Left subtree diameter
        int diam1 = diameter(root.left);
        // Right subtree diameter
        int diam2 = diameter(root.left);
        // Diameter which contains the root
        int diam3 = height(root.left)+height(root.right)+1;

        return Math.max(Math.max(diam2, diam3),diam1);
    }

    static class TreeInfo{
        int ht;
        int dia;
        TreeInfo(int ht,int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }

    static TreeInfo diameter2(Node root){
        if (root == null){
            return new TreeInfo(0, 0);
        }

        // For left subtree
        TreeInfo left = diameter2(root.left);

        // For right subtree
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht,right.ht)+1;
        int myDia = Math.max(Math.max(left.dia,right.dia),left.ht+right.ht+1);

        return new TreeInfo(myHeight,myDia);

    }
    static boolean isIdentical(Node root,Node subroot){
        if (root == null && subroot == null){
            return true;
        }
        if (root == null || subroot == null){
            return false;
        }
        if (root.data == subroot.data){
            return isIdentical(root.left,subroot.left) && isIdentical(root.right,subroot.right);
        }
        return false;
    }
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if(S == null){
            return true;
        }
        if (T == null){
            return false;
        }
        if (T.data == S.data){
            if (isIdentical(T,S)){
                return true;
            }
        }
        
        return isSubtree(T.left,S) || isSubtree(T.right,S);
    }

    static int kLevelSum(Node root,int k){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;
        int sum = 0;
        while(!queue.isEmpty()){
            Node currNode = queue.remove();
            if (level == k){
                if (currNode!=null){
                    sum+=currNode.data;
                }
            }
            if (currNode == null){
                level++;
                if (queue.isEmpty()){
                    break;
                }else{
                    queue.add(null);
                }
            }else{
                if (currNode.left!=null){
                    queue.add(currNode.left);
                }
                if (currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
        }
        return sum;
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
    public static void main(String[] args) {
        int nodes []= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.getTree(nodes);
        // preOrder(root);
        // postOrder(root);
        // inOrder(root);
        // levelOrder(root);
        // System.out.println(countNodes(root));
        // System.out.println(sumNodes(root));
        // System.out.println(height(root));
        // System.out.println(diameter2(root).dia);
        // System.out.println(kLevelSum(root, 3));
        stdApproach(root);
    }
}
