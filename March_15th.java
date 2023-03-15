package Daily_Leetcode_Qs;

import java.util.LinkedList;
import java.util.Queue;

public class March_15th {
    public static void main(String[] args) {

    }
    private static boolean CompleteBinaryTree(BinaryTreeNode<Integer> root) {
        boolean end = false;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryTreeNode<Integer> cur = queue.poll();
            if(cur == null) end = true;
            else{
                if(end) return false;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return true;
    }
}
