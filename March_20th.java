package Daily_Leetcode_Qs;

public class March_20th {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0 ,0,1};
        System.out.println(canPlaceFlowers(flowerbed,2));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for (int i=0;i<flowerbed.length && count<n;i++){
            if(flowerbed[i] == 0){
                int next = (i== flowerbed.length-1) ? 0:flowerbed[i+1];
                int prev = (i==0) ? 0:flowerbed[i-1];
                if(next==0 && prev == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count==0;
    }
}
