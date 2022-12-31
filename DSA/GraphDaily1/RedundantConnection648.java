import java.util.*;

public class RedundantConnection648 {
    public static boolean DFS(List<List<Integer>> al, boolean[] visited, int curr, int parent) {
        visited[curr] = true;
        for (int i = 0; i < al.get(curr).size(); i++) {
            int child = al.get(curr).get(i);
            if (visited[child] == false) {
                DFS(al, visited, child, curr);
            } else if (visited[child]) {
                if (child != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            al.get(u).add(v);
            al.get(v).add(u);
            boolean[] visited = new boolean[n+1];
            if (DFS(al, visited, u, -1)) {
                return new int[] { u, v };
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] res = findRedundantConnection(edges);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
