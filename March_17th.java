package Daily_Leetcode_Qs;

public class March_17th {
    class Trie {

        char data;
        boolean isTerminating;
        Trie[] children;

        public  Trie(char data) {
            this.data = data;
            isTerminating = false;
            children = new Trie[26];
        }

        private Trie root;

        public Trie(){
            root = new Trie('\0');
        }

        public void insertwithroot(Trie root,String word) {
            if (word.length()==0){
                root.isTerminating=true;
                return;
            }
            int childindex = word.charAt(0) - 'a';
            Trie child = root.children[childindex];
            if (child==null){
                child = new Trie(word.charAt(0));
                root.children[childindex] = child;
            }
            insertwithroot(child,word.substring(1));
        }
        public void insert(String word){
            int childindex = word.charAt(0) - 'a';
            Trie child = root.children[childindex];
            if (child==null) {
                child = new Trie(word.charAt(0));
                root.children[childindex] = child;
            }
            insertwithroot(child,word.substring(1));
        }

        public boolean search(String word) {
            return searchwithroot(root,word);
        }
        private boolean searchwithroot(Trie root, String word) {
            if (word.length()==0) return root.isTerminating;

            int childindex = word.charAt(0) -'a';
            Trie child = root.children[childindex];
            if (child==null) return false;
            return searchwithroot(child,word.substring(1));
        }

        public boolean startsWith(String word) {
            return startswithroot(root,word);
        }
        private boolean startswithroot(Trie root, String word) {
            if (word.length()==0) return true;
            int childindex = word.charAt(0) - 'a';
            Trie child = root.children[childindex];
            if (child==null) return false;
            return startswithroot(child,word.substring(1));
        }
    }
}
