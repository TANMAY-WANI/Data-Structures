import java.util.ArrayList;
import java.util.Collections;

public class MergeLL {
    static Node stdApproach(Node head1,Node head2){
        ArrayList <Integer> nodes = new ArrayList<>();

        Node curr = head1;
        while (curr!=null){
            if (!nodes.contains(curr.data)){
                nodes.add(curr.data);
            }
            curr = curr.next;
        }
        curr = head2;
        while (curr!=null){
            if (!nodes.contains(curr.data)){
                nodes.add(curr.data);
            }
            curr = curr.next;
        }
        Collections.sort(nodes);
        ArrayList <Node> n1 = new ArrayList<>();
        for (int i=0;i<nodes.size();i++){
            n1.add(new Node(nodes.get(i)));
        }
        if (n1.size()==0){
            return null;
        }
        for (int i=0;i<n1.size()-1;i++){
            n1.get(i).next = n1.get(i+1);
        }
        return n1.get(0);
    }
    public static void main(String[] args) {
        Node fisrt = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(2);
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
        // stdApproach(fisrt,fisrt2);
        System.out.println(stdApproach(fisrt, fisrt2));
    }
}
