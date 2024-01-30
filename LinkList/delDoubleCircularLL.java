public class delDoubleCircularLL {
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }

    static Node deleteStart(Node head){
        Node temp = head.next;
        Node curr = head;
        while (curr.next!=head){
            curr = curr.next;
        }
        temp.prev = curr;
        curr.next = temp;
        return temp;
    }
    static void deleteBetween(Node head,int data){
        Node curr = head;
        while (curr.data != data){
            curr = curr.next;
        }
        Node prev = curr.prev;
        prev.next = curr.next;
        curr.next.prev = prev;
    }
    static void deleteEnd(Node head){
        Node curr = head;
        while (curr.next!=head){
            curr = curr.next;
        }
        Node prev = curr.prev;
        prev.next = head;
        head.prev = prev;
    }
    public static void main(String[] args) {
        Node first = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        first.next = sec;
        sec.next = third;
        third.next = first;
        first.prev = third;
        sec.prev = first;
        third.prev = sec;
        // System.out.println("deleting start");
        // Node new_head = deleteStart(first);
        // Node curr = new_head;
        // while (curr.next!=new_head){
        //     System.out.println(curr.data);
        //     curr = curr.next;
        // }
        // System.out.println(curr.data);

        // Implement deleteBetween
        // System.out.println("deleting between");
        // deleteBetween(first,2);
        // Node curr = first;
        // while (curr.next!=first){
        //     System.out.println(curr.data);
        //     curr = curr.next;
        // }
        // System.out.println(curr.data);

        // Implement deleteEnd
        System.out.println("deleting end");
        deleteEnd(first);
        Node curr = first;
        while (curr.next!=first){
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println(curr.data);
    }
}
