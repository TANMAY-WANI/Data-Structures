import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class node{
    int data;
    node next;
    node arb;
    node(int data){
        this.data = data;
    }
}

class CopyLL{

    static node createNode(int data){
        return new node(data);
    }

    static node optimisedApproach(node head){
        for (node i = head; i!=null ; i = i.next.next){
            node n = new node(i.data);
            n.next = i.next;
            i.next = n;
        }
        for (node i = head; i!=null ; i=i.next.next){
            node arb = i.arb;
            if (arb!=null){
                i.next.arb = arb.next;
            }
        }
        node head2 = head.next;
        for (node i = head;i!=null;i=i.next){
            node n = i.next;
            node n2 = i.next.next;
            n.next = (n2!=null)?n2.next:null;
            i.next = n2; //Breaking the connection
        }
        return head2;
    }
    static node brutForce(node head){
        HashMap<Integer,node> myMap = new HashMap<>();
        node curr = head;
        while (curr!=null){
            myMap.put(curr.data, curr.arb);
            curr = curr.next;
        }
        ArrayList<node> myList = new ArrayList<>();
        Iterator mapIterator = myMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            HashMap.Entry mapElement
                = (HashMap.Entry)mapIterator.next();
            
            myList.add(createNode((int)mapElement.getKey()));
        }
        Iterator mapIterator2 = myMap.entrySet().iterator();
        while (mapIterator2.hasNext()) {
            HashMap.Entry mapElement
                = (HashMap.Entry)mapIterator2.next();
            // myList.add(createNode((int)mapElement.getKey()));
            for (int i=0;i<myList.size();i++){
                if (myList.get(i).data == (int)mapElement.getKey()){
                    myList.get(i).arb = (node)mapElement.getValue();
                }
            }
        }
        for (int i=0;i<myList.size()-1;i++){
            myList.get(i).next = myList.get(i+1);
        }
        return myList.get(0);
    }
    public static void main(String[] args) {
        // give a sample link list
        node first = createNode(1);
        node sec = createNode(2);
        node third = createNode(3);
        node fourth = createNode(4);
        node fifth = createNode(5);
        first.next = sec;
        sec.next = third;
        third.next = fourth;
        fourth.next = fifth;
        first.arb = third;
        sec.arb = first;
        third.arb = fifth;
        fourth.arb = sec;
        fifth.arb = fourth;
        node head = brutForce(first);
        while (head!=null){
            System.out.print(head.data+" ");
            System.out.println(head.arb.data);
            head = head.next;
        }
    }
}