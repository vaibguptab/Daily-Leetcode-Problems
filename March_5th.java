package Daily_Leetcode_Qs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class March_5th {
    public static void main(String[] args) {
        int[] arr ={100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(Q1345(arr));
    }

    private static int Q1345(int[] arr) {
        int n = arr.length;
        HashMap<Integer, ArrayList<Integer>> indicesOfValue = new HashMap<>();
        for (int i = 0; i < n; i++)
            indicesOfValue.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        boolean[] visited = new boolean[n]; visited[0] = true;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int i = q.poll();
                if (i == n - 1) return step; // Reached to last index
                ArrayList<Integer> next = indicesOfValue.get(arr[i]);
                next.add(i - 1); next.add(i + 1);
                for (int j : next) {
                    if (j >= 0 && j < n && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                next.clear(); // avoid later lookup indicesOfValue arr[i]
            }
            step++;
        }
        return 0;
    }
}
