package Tree;

import java.util.ArrayList;

public class TreeToDLL {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static Node constructDoubleLL(ArrayList<Node> myList){
        myList.get(0).left = null;
        for (int i=1;i<myList.size();i++){
            myList.get(i-1).right = myList.get(i);
            myList.get(i).left = myList.get(i-1);
        }
        return myList.get(0);
    }
    static void inOrder(Node root,ArrayList<Node> myList){
        if (root == null)
            return;
        inOrder(root.left,myList);
        myList.add(root);
        inOrder(root.right,myList);
    }
    public static void main(String[] args) {
        ArrayList<Node> myList = new ArrayList<>();
        Node root =  new Node(10);
        root.left = new Node(12);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right = new Node(15);
        root.right.left = new Node(36);
        inOrder(root,myList);
        // System.out.println(myList);
        Node head = constructDoubleLL(myList);
        // Print the double ll

        Node curr = head;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
    }
}
