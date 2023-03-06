package Daily_Leetcode_Qs;

public class March6th {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(Q1539(arr,5));
    }

    private static int Q1539(int[] arr, int k) {
        int n = arr.length;
        int start = 0,end = n-1;
        int missing = compute(arr[n-1],n);
        while(start<=end) {
            int mid = start + (end - start) / 2;
            missing = compute(arr[mid], mid + 1);
            if (missing>=k) end = mid-1;
            else start = mid+1;
        }
        if (end == -1) return k;
        return arr[end] +k - compute(arr[end],end+1);

    }

    private static int compute(int i, int n) {
        return i-n;
    }
}
