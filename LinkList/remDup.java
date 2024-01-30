import java.util.ArrayList;

public class remDup {
    static class  Node {
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            next = null;
            prev = null;
        }
        
    }
    static Node stdApproach(Node head){
        ArrayList <Integer> myList = new ArrayList<>();
        Node curr = head;
        while (curr!=null){
            if (myList.contains(curr.data)){
                Node prev = curr.prev;
                prev.next = curr.next;
                curr.next.prev = prev;
            }
            else{
                myList.add(curr.data);
            }
            curr = curr.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node fisrt = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(2);
        Node fourth = new Node(4);
        fisrt.next = sec;
        sec.next = third;
        third.next = fourth;
        sec.prev = fisrt;
        third.prev = sec;
        fourth.prev = third;
        Node res = stdApproach(fisrt);
        Node curr = res;
        while (curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
