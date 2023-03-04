package Daily_Leetcode_Qs;

public class March_3rd {
    public static void main(String[] args) {
        String haystack = "sadbhutsad";
        String needle = "sad";
        System.out.println(Q28(haystack,needle));
    }
    private static int Q28(String haystack, String needle) {
        for (int i=0;i< haystack.length()- needle.length()+1 ;i++){
            if (haystack.charAt(i)==needle.charAt(0)){
                if (haystack.substring(i,i+ needle.length()).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
