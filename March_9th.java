package Daily_Leetcode_Qs;

public class March_9th {
    public static void main(String[] args) {

   }
   private static Node<Integer> Q142(Node<Integer> head) {
       Node<Integer> slow = head,fast = head,entry=head;
       while(fast!=null&&fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;
           if (slow==fast){
               while (slow!=entry){
                   slow= slow.next;
                   entry = entry.next;
               }
               return entry;
           }
       }

       return null;
    }
}
