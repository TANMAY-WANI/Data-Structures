import java.util.ArrayList;
import java.util.HashMap;

public class InsersectionOfLL {
    static Node stdApproach(Node head1,Node head2){
        HashMap<Integer,Integer> myMap = new HashMap<>();
        ArrayList <Node> nodes = new ArrayList<>();
        Node curr = head1;
        while (curr!=null){
            myMap.put(curr.data,myMap.getOrDefault(curr.data, 0)+1);
            curr = curr.next;
        }
        // System.out.println(myMap);
        curr = head2;
        while ( curr!=null) {
            if (myMap.containsKey(curr.data) && myMap.get(curr.data)>0){
                myMap.put(curr.data, myMap.get(curr.data)-1);
                nodes.add(curr);
            }
            curr = curr.next;
        }
        if (nodes.size() == 0){
            return null;
        }
        for (int i=0;i<nodes.size()-1;i++){
            nodes.get(i).next = nodes.get(i+1);
        }
        return nodes.get(0);
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
