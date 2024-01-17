import java.util.ArrayList;

public class insersectPt {
    static int brutForce(Node head1,Node head2){
        ArrayList<Integer> myList = new ArrayList<>();
        Node curr1 = head1;
        while (curr1!=null){
            myList.add(curr1.data);
            curr1 = curr1.next;
        }
        Node curr2 = head2;
        while (curr2!=null){
            if (myList.contains(curr2.data)){
                return curr2.data;
            }
            curr2 = curr2.next;
        }
        return -1;
    }

    static int calcLen(Node head){
        int length = 0;
        while (head!=null){
            length++;
            head = head.next;
        }
        return length;
    }
    static int optimisedApproach(Node head1, Node head2) {
        int len1 = calcLen(head1);
        int len2 = calcLen(head2);
        int d;
        Node curr1 = head1;
        Node curr2 = head2;
    
        if (len1 > len2) {
            d = len1 - len2;
            for (int i = 0; i < d; i++) {
                curr1 = curr1.next;
            }
        } else if (len2 > len1) {
            d = len2 - len1;
            for (int i = 0; i < d; i++) {
                curr2 = curr2.next;
            }
        }
    
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {  // Compare node references, not data
                return curr1.data;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
    
        return -1;
    }
    
    public static void main(String[] args) {
        // Create an intersected linked list
        Node fisrt = new Node(1);
        Node sec = new Node(2);

        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        
        Node seventh = new Node(7);
        Node eighth = new Node(8);
        Node ninth = new Node(9);
        Node tenth = new Node(10);

        fisrt.next = sec;
        sec.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        seventh.next = eighth;
        eighth.next = ninth;
        ninth.next = tenth;
        tenth.next = third;

        // System.out.println(brutForce(fisrt,seventh));
        System.out.println(optimisedApproach(fisrt, seventh));

    }
}
