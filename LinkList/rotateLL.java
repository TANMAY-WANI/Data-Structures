public class rotateLL {
    static int calcLength(Node head){
        Node curr = head;
        int length = 0;
        while (curr!=null){
            length++;
            curr = curr.next;
        }
        return length;
    }
 static Node stdApproach(Node head ,int k){
    Node curr = head;
    Node start = head;
    Node new_head = null;
    Node prev = null;
    int len = calcLength(head);
    if (k == len){
        return head;
    }
    while (curr!=null){
        if (k==0){
            prev.next = null;
            new_head = curr;
        }
        k--;
        prev = curr;
        curr = curr.next;
    }
    prev.next = start;
    return new_head;
 }   
 public static void main(String[] args) {
        Node fisrt = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        fisrt.next = sec;
        sec.next = third;
        third.next = fourth;
        Node rev = stdApproach(fisrt,4);
        Node curr = rev;
        while (curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
 }
}
