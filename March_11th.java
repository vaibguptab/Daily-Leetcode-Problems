package Daily_Leetcode_Qs;

public class March_11th {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(-10);
        Node<Integer> head1 = new Node<>(-3);
        Node<Integer> head2 = new Node<>(0);
        Node<Integer> head3 = new Node<>(5);
        Node<Integer> head4 = new Node<>(9);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = null;

        BinaryTreeNode<Integer> root = ListtoBST(head);
        printTreeDetailed(root);
    }

    static Node<Integer> temp;
    private static BinaryTreeNode<Integer> ListtoBST(Node<Integer> head) {
        temp = head;
        return buildBST(0,length(head)-1);
    }

    private static BinaryTreeNode<Integer> buildBST(int left, int right) {
        if (left>right) return null;

        int mid = left + (right-left)/2;
        BinaryTreeNode<Integer> leftnode = buildBST(left,mid-1);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(temp.data);
        temp = temp.next;

        root.left = leftnode;
        root.right = buildBST(mid+1,right);
        return root;
    }

    private static int length(Node<Integer> head) {
        int ans=0;
        while (head!=null){
            ans++;
            head = head.next;
        }
        return ans;
    }

    public static void printTreeDetailed(BinaryTreeNode root){

        //Preorder
        if(root==null){
            return;
        }
        System.out.print(root.data +":");
        if(root.left!=null){
            System.out.print("L"+root.left.data+",");
        }
        if(root.right!=null){
            System.out.print(" R"+ root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);

    }
}
