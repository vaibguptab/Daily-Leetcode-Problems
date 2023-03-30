package Daily_Leetcode_Qs;

public class March_30th {
    public static void main(String[] args) {
        System.out.println(isScramble("great","rgeat"));
    }
    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;

        if (s1.length() != s2.length()) return false;

        return helper(s1, s2);
    }
    public static boolean helper(String a,String b){

        if(a.equals(b) == true) return true;

        if(a.length() <= 1) return false;   // as we can't compare 1 character

        int n = a.length();
        boolean check = false;

        for(int i = 1; i < n; i++)
        {
            boolean swap = helper(a.substring(0, i), b.substring(n - i)) && helper(a.substring(i), b.substring(0, n - i));
            boolean unswap = helper(a.substring(0,i), b.substring(0,i)) && helper(a.substring(i), b.substring(i));

            if(swap || unswap){
                check = true;
                break;
            }
        }

        return check;
    }
}
