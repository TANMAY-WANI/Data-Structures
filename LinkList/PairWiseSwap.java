public class PairWiseSwap {
    static Node stdApproach(Node head){
        Node curr = head;
        Node prev = null;
        
        while (curr != null && curr.next != null) {
            Node first = curr;
            Node second = curr.next;
        
            if (prev == null) {
                head = second;
            } else {
                prev.next = second;
            }
        
            first.next = second.next;
            second.next = first;
        
            prev = first;
            curr = first.next;
        }
        
        return head;
        
    }
    public static void main(String[] args) {
        Node fisrt = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        fisrt.next = sec;
        sec.next = third;
        third.next = fourth;
        Node rev = stdApproach(fisrt);
        Node curr = rev;
        while (curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
