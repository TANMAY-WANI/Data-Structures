public class nthEleFromLast {
    static int stdApproach(Node head,int n){
        Node curr = head;
    	int length = 0;
    	while (curr!=null){
    	    length++;
    	    curr = curr.next;
    	}
    	int reqNo = length-n;
    	int num = 0;
        Node curr2 = head;
        while (curr2!=null){
            if (num==reqNo){
                return curr2.data;
            }
            num++;
            curr2 = curr2.next;
        }
    	return -1;
    }
    public static void main(String[] args) {
        Node fisrt = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        fisrt.next = sec;
        sec.next = third;
        third.next = fourth;
        System.out.println(stdApproach(fisrt,2));
    }
}
