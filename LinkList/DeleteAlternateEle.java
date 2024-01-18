public class DeleteAlternateEle {
    static void printLL(Node head){
        Node curr = head;
        while (curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    static void stdApproach(Node head){
        Node curr = head;
        int i=0;
        Node prev = null;
        while (curr!=null){
            i++;
            if (i%2 == 0){
                prev.next = curr.next;
                curr = prev;
            } 
            prev = curr;
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
        System.out.println("After deleting alternate elements");
        stdApproach(fisrt);
        printLL(fisrt);
    }
}
