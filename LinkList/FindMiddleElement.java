public class FindMiddleElement {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static int stdApproach(Node head){
             // Your code here.
             int length = 0;
             Node curr = head;
             while (curr!=null){
                 length++;
                 curr = curr.next;
             }
            float middle = (float)length/2;
            int mid = (int)Math.ceil(middle);
    
             if (length%2==0){
                //  The length is even
                mid = mid+1;
             }
             int ptr = 0;
             Node curr2 = head;
             while (curr2!=null){
                 ptr++;
                 if (ptr == mid){
                     return curr2.data;
                 }
                 curr2 = curr2.next;
             }
             return -1;
             

    }
    
}