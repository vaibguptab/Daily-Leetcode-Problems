package Daily_Leetcode_Qs;

public class March_7th {
    public static void main(String[] args) {
        int[] time = {1,2,3};
        System.out.println(MinimumtimetocompleteTrips(time,5));
    }

    private static int MinimumtimetocompleteTrips(int[] time, int totaltrips) {
        int start = 0,end=0;
        for (int e:time) end+=e;
        while (start<end){
            int mid = start + (end-start)/2;
            if (isValid(time, time.length,totaltrips,mid)<totaltrips) start = mid+1;
            else end = mid;
        }
        return start;
    }

    private static int isValid(int[] time, int length, int totaltrips, int mid) {
//        int trips=0;
        int sum = 0;
        for (int t : time) sum += mid / t;
//            if (sum>totaltrips){
//                trips++;
//                sum = time[i];
//            }
//        }
        return sum;
    }
}
