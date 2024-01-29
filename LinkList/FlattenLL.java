import java.util.ArrayList;
import java.util.Collections;

class list {
    int data;
    list next;
    list bottom;

    list(int data){
        this.data = data;
    }
}

public class FlattenLL {
    static Node brutForce(list head){
        ArrayList <list> myList = new ArrayList<>();
        list curr = head;
        while (curr!=null){
            list btm = curr;
            while (btm!=null){
                myList.add(btm);
                btm = btm.bottom;
            }
            curr = curr.next;
        }
        // Collections.sort();
        Collections.sort(myList,(a,b)->a.data-b.data);
        Node new_head = new Node(myList.get(0).data);
        Node temp = new_head;
        for (int i=1;i<myList.size();i++){
            temp.next= new Node(myList.get(i).data);
            temp = temp.next;
        }
        return new_head;
    }
    public static void main(String[] args) {
        
        // create a sample list for the testing
        list head = new list(5);
        head.next = new list(10);
        head.next.next = new list(19);
        head.next.next.next = new list(28);
        head.bottom = new list(7);
        head.bottom.bottom = new list(8);
        head.bottom.bottom.bottom = new list(30);
        head.next.bottom = new list(20);
        head.next.next.bottom = new list(22);
        head.next.next.bottom.bottom = new list(50);
        head.next.next.next.bottom = new list(35);
        head.next.next.next.bottom.bottom = new list(40);
        head.next.next.next.bottom.bottom.bottom = new list(45);
        Node new_head = brutForce(head);
        Node curr = new_head;
        while (curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
        
    }
}
