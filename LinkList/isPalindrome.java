import java.util.HashMap;

class List{
    List next;
    Character chr;

    List(Character chr){
        this.chr = chr;
    }

}

public class isPalindrome {

    static int calcLen(List head){
        int length = 0;
        while (head!=null){
            length++;
            head = head.next;
        }
        return length;
    }

    static boolean brutForce(List head){
        HashMap<Integer,Character> myMap = new HashMap<>();
        List curr = head;
        int len = calcLen(head);
        int flag = 1;
        // System.out.println(len);
        if (len == 1 || len == 0){
            return true;
        }
        if (len%2 == 0){
            // Even lenght
            flag = 0;
        }
        for (int i=1;i<=len/2;i++){
            myMap.put(i,curr.chr);
            curr = curr.next;
        }
        if (flag == 0){
            for (int i=len/2;i>=0;i--){
                if (curr == null){
                    return true;
                }
                Character ch = curr.chr ;
                if (!ch.equals(myMap.get(i))){
                    return false;
                }
                curr = curr.next;
            }
        }else{
            curr = curr.next;
            for (int i=len/2;i>=0;i--){
                if (curr == null){
                    return true;
                }
                Character ch = curr.chr;
                if (!ch.equals(myMap.get(i))){
                    return false;
                }
                curr = curr.next;
            }

        }
        return true;
    }

    // To check if  list is palindrome we shall compare the elements of the left half of the list to the reversed right part

    static Node revLL(Node head){
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

    static boolean optimisedApproach(Node head){
        Node slow,fast = null;
        Node curr = head;
        slow = curr.next;
        if (curr.next == null){
            return true;
        }
        fast = curr.next.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // as slow ptr moves at half the pase of the fast pointer, 
        // when fast pointer reaches the end of the list, slow pointer will be at the middle of the list
        Node mid = revLL(slow);
        while (head!=null && mid!=null){
            if (head.data != mid.data){
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;

    }


    public static void main(String[] args) {
        List first = new List('a');
        List sec = new List('b');
        List third = new List('c');
        List fourth = new List('b');
        List fifth = new List('a');
        first.next = sec;
        sec.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // System.out.println(brutForce(first));

        Node fisrt = new Node(1);
        Node sec1 = new Node(2);
        Node third1 = new Node(2);
        Node fourth1 = new Node(1);
        fisrt.next = sec1;
        sec1.next = third1;
        third1.next = fourth1;
        System.out.println(optimisedApproach(fisrt));
        
    }
}