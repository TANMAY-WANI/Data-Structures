public class CircularLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static int getLen(Node head){
        Node curr = head.next;
        int len = 1;
        while (curr!=head){
            len++;
            curr = curr.next;
        }
        return len;
    }

    static void printLL(Node head){
        Node curr = head.next;
        System.out.print(head.data+" ");
        while (curr!=head){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    static void stdApproach(Node head) {
        int len = getLen(head);
        int mid;
        if (len % 2 == 0)
            mid = len / 2;
        else
            mid = len / 2 + 1;
    
        Node head1 = head;
        Node head2;
    
        Node curr = head;
        Node c = head1;
        curr = curr.next;
        int i = 1;
        while (i<mid){
            Node n = new Node(curr.data);
            curr = curr.next;
            c.next = n;
            c = c.next;
            i++;
        }
        head2 = curr;
        Node c2 = head2;
        // System.out.println(i);
        while (curr.next!=null){
            curr = curr.next;
            Node n = new Node(curr.data);
            c2.next = n;
            c2 = c2.next;
        }
        c.next = head1;
        c2.next = head2;
        printLL(head1);
        System.out.println();
        printLL(head2);
    }
    

    public static void main(String[] args) {
        // Create a circular linked list
        Node head = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        // Node fourth = new Node(4);
        head.next = sec;
        sec.next = third;
        third.next = head;
        // fourth.next = head;
        // System.out.println(getLen(head));
        // printLL(head);
        stdApproach(head);
    }
}
