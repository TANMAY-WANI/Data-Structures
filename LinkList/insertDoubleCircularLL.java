public class insertDoubleCircularLL {
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    static Node insertStart(Node head,int data){
        Node new_head = new Node(data);
        new_head.next = head;
        head.prev = new_head;
        Node curr = head;
        while (curr.next!=head){
            curr = curr.next;
        }
        curr.next = new_head;
        return new_head;
    }
    static void insertBetween(Node head,int after,int data){
        Node curr = head;
        while (curr.data!=after){
            curr = curr.next;
        }
        Node temp = new Node(data);
        temp.next = curr.next;
        temp.prev = curr;
        curr.next.prev = temp;
        curr.next = temp;

    }

    static void insertEnd(Node head,int data){
        Node curr = head;
        while (curr.next!=head){
            curr = curr.next;
        }
        Node tail = new Node(data);
        tail.next = head;
        tail.prev = curr;
        curr.next = tail;
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
        // implement insertBetween
        System.out.println("inserting between");
        insertBetween(first,2,10);
        Node curr = first;
        while (curr.next!=first){
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println(curr.data);

        System.out.println("inserting at end");
        // implement insertEnd
        insertEnd(first,4);
        curr = first;
        while (curr.next!=first){
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println(curr.data);

        // implement insertStart

        Node cur = first;
        while (cur.next!=first){
            System.out.println(cur.data);
            cur = cur.next;
        }
        System.out.println(cur.data);
        System.out.println("After inserting at start");
        Node new_head = insertStart(first,4);
        cur = new_head;
        while (cur.next!=new_head){
            System.out.println(cur.data);
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
}
