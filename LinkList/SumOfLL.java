public class SumOfLL {
    static Node reverse(Node head){
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
    static int calcLen(Node head){
        int len = 0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
    static int stdApproach(Node head1,Node head2){
        Node revL1 = reverse(head1);
        Node revL2 = reverse(head2);

        int l1 = calcLen(head1);
        int l2 = calcLen(head2);
        int sum = 0;
        int int_sum;
        int i = 1;
        while (revL1!=null && revL2!=null){
            int_sum = revL1.data+revL2.data;
            sum = sum+(i*int_sum);
            i = i*10;
            l1--;
            l2--;
            revL1 = revL1.next;
            revL2 = revL2.next;
        }
        if (l1>0){
            while (revL1!=null){
                sum = sum+(i*revL1.data);
                i = i*10;
                l1--;
                revL1 = revL1.next;
            }
        }else{
            while (revL2!=null){
                sum = sum+(i*revL2.data);
                i = i*10;
                l2--;
                revL2 = revL2.next;
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        Node fisrt = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        fisrt.next = sec;
        sec.next = third;
        third.next = fourth;
        Node fisrt2 = new Node(1);
        Node sec2 = new Node(2);
        Node third2 = new Node(3);
        Node fourth2 = new Node(4);
        fisrt2.next = sec2;
        sec2.next = third2;
        third2.next = fourth2;
        System.out.println(stdApproach(fisrt,fisrt2));
    }

}
