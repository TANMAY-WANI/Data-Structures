import java.util.ArrayList;

public class revLLwithoutActuallyReversing {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static void stdApproach(Node head){
        ArrayList <Integer> myList = new ArrayList<>();
        Node curr = head;
        while (curr!=null){
            myList.add(curr.data);
            curr = curr.next;
        }
        for (int i=myList.size()-1;i>=0;i--){
            System.out.print(myList.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        revLLwithoutActuallyReversing obj = new revLLwithoutActuallyReversing();
        Node fisrt = obj.new Node(1);
        Node sec = obj.new Node(2);
        Node third = obj.new Node(3);
        Node fourth = obj.new Node(4);
        fisrt.next = sec;
        sec.next = third;
        third.next = fourth;
        stdApproach(fisrt);
    }
}
