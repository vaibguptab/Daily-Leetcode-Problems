package Daily_Leetcode_Qs;

import java.util.ArrayList;

public class MArch_23rd {
    public static void main(String[] args) {

    }
    public int dfs(int element , int[][] graph, boolean[] visited){
        if (visited[element]) return 0;
        visited[element] = true;
        for (int e: graph[element])
            dfs(e,graph,visited);
        return 1;
    }
    public static int makeConnected(int n,int[][] connections){
        if (connections.length<n-1) return -1;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i=0;i<n;i++) graph[i] = new ArrayList<>();
        for (int[] c: connections){
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++){
            components += dfs(i,graph,visited);
        }
        return components-1;
    }


}
