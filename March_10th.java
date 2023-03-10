package Daily_Leetcode_Qs;

import java.util.Random;

public class March_10th {

    public class Solution {
        static Random random;
        static int length=0;
        static Node<Integer> headnode;
        public Solution(Node<Integer> head){
            rnd = new Random();
            this.head = head;
            length = 0;
            ListNode tmp = head;
            while (tmp != null) {
                tmp = tmp.next;
                length++;
            }
        }
        public static int getrandom(){
            int index = rnd.nextInt(0, length);
            ListNode tmp = head;
            while (index > 0) {
                tmp = tmp.next;
                index--;
            }
            return tmp.val;
        }
    }
}
