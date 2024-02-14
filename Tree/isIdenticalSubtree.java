package Tree;

public class isIdenticalSubtree {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static boolean isSubtreeIdentical(Node root,Node subroot){
        if (root == null && subroot == null){
            return true;
        }
        if (root == null || subroot == null){
            return false;
        }
        if (root.data == subroot.data){
            return isSubtreeIdentical(root.left, subroot.left) && isSubtreeIdentical(root.right, subroot.right);
        }
        return false;
    }
    static boolean isIdentical(Node T,Node S){
        if (S==null){
            return true;
        }
        if (T==null){
            return false;
        }

        if (T.data == S.data){
            if (isSubtreeIdentical(T,S)){
                return true;
            }
        }
        return isIdentical(T.left, S) || isIdentical(T.right, S);
    }
}
