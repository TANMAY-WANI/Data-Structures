
class Node {

    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

public class revLL {

    static Node stdApproach(Node head){
                // code here
                Node prev = null;
                Node curr = head;
                Node fwd = head.next;
                while (curr!=null){
                    fwd = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = fwd;
                }
                return prev;
    }
    static void printLL(Node head){
        Node curr = head;
        while (curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Node fisrt = new Node(1);
        Node sec = new Node(2);
        fisrt.next = sec;
        printLL(fisrt);
        System.out.println("After reversing");
        Node rev = stdApproach(fisrt);
        printLL(rev);
    }
}