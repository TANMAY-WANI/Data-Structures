package Tree;

import java.util.Stack;

public class ExprTree {
    static class Node{
        String data;
        Node left,right;
        Node(String data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    static boolean isOperator(String ch){
        if (ch == "+" || ch == "-" || ch == "*" || ch == "/" || ch == "^")
            return true;

        return false;
    }
    static int getAns(int n1,int n2,String op){
        if (op=="+")
            return n1+n2;
        if (op=="-")
            return n1-n2;
        if (op=="*")
            return n1*n2;
        if (op=="-")
            return n1-n2;
        if (op == "^")
            return (int)Math.pow(n1, n2);
        if (op=="/")
            return (int)n1/n2;
        return -1;
    }
    static   Stack <String> stack = new Stack<>();
    static void brutForce(Node head){
     
        if (head!=null){
            brutForce(head.left);
            brutForce(head.right);
            if (isOperator(head.data)){
                String d1 = stack.pop();
                String d2 = stack.pop();
                int dp1 = Integer.parseInt(d1);
                int dp2 = Integer.parseInt(d2);
                int ans = getAns(dp2,dp1,head.data);
                String op = String.valueOf(ans);
                stack.push(op);
            }else{
                stack.push(head.data);
            }
        }
    }

    static int getValue(Node head){
        brutForce(head);
        return Integer.parseInt(stack.pop());
    }


        public static void main(String[] args) {
            // Construct an expression tree
            Node root = new Node("+");
            root.left = new Node("*");
            root.left.left = new Node("5");
            root.left.right = new Node("4");
            root.right = new Node("-");
            root.right.left = new Node("100");
            root.right.right = new Node("/");
            root.right.right.left = new Node("20");
            root.right.right.right = new Node("2");
            System.out.println(getValue(root));

        }
    }
