public class revLLuptoK {
    // class Node{
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data = data;
    //     }
    // }
    static Node stdApproach(Node node,int k){
        Node prev = null;
        Node prev2 = null;
        Node curr = node;
        Node fwd = node.next;
        while (curr!=null){
            if (k>0){
                fwd = curr.next;
                curr.next = prev;
                prev = curr;
                curr = fwd;
                k--;
            }else if (k<=0){
                fwd = curr.next;
                curr.next = prev2;
                prev2 = curr;
                curr = fwd;
                k--;
            }
        }
        Node ptr = prev;
        while (ptr.next!=null)
            ptr = ptr.next;
        ptr.next = prev2;
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
        Node third = new Node(3);
        Node fourth = new Node(4);
        fisrt.next = sec;
        sec.next = third;
        third.next = fourth;
        printLL(fisrt);
        System.out.println("After reversing");
        Node rev = stdApproach(fisrt,3);
        printLL(rev);
    }
}
