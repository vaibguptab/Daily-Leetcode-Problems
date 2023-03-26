package Daily_Leetcode_Qs;

import java.util.HashMap;

public class March_26th {
    public static void main(String[] args) {
        int[] edges = {3,3,4,2,3};
        System.out.println(longestdistance(edges));
    }

    private static int longestdistance(int[] edges) {
        int res = -1;
        boolean[] vis = new boolean[edges.length]; // global visisted

        for(int i=0; i<edges.length; i++){
            if(vis[i]) continue;
            HashMap<Integer, Integer> x = new HashMap<>();  // local visited
            for (int idx=i, dist=0; idx!=-1; idx=edges[idx]){
                if(x.containsKey(idx)){
                    res = Math.max(res, dist-x.get(idx));
                    break;
                }
                if(vis[idx]) break;
                vis[idx] = true;
                x.put(idx, dist++);
            }
        }
        return res;
    }

}
