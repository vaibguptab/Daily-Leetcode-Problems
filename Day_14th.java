package Daily_Leetcode_Qs;

public class Day_14th {
    public static void main(String[] args) {

    }
    private static int SumtoLeaf(BinaryTreeNode<Integer> root) {
        return Sum(root,0);
    }

    private static int Sum(BinaryTreeNode<Integer> root, int s) {
        if (root==null) return 0;
        if (root.right==null && root.left==null) return s*10 + root.data;
        return Sum(root.left,s*10+ root.data) + Sum(root.right,s*10+root.data);
    }
}
