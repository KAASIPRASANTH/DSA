import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero1466 {
    static int count;

    public static void DFS(List<List<Integer>> al1, List<List<Integer>> al2, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int i = 0; i < al1.get(curr).size(); i++) {
            if (visited[al1.get(curr).get(i)] == false) {
                count++;
                DFS(al1, al2, visited, al1.get(curr).get(i));
            }
        }
        for (int i = 0; i < al2.get(curr).size(); i++) {
            if (visited[al2.get(curr).get(i)] == false) {
                DFS(al1, al2, visited, al2.get(curr).get(i));
            }
        }
    }

    public static int minReorder(int n, int[][] connections) {
        count = 0;
        List<List<Integer>> al1 = new ArrayList<>();
        List<List<Integer>> al2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al1.add(new ArrayList<>());
            al2.add(new ArrayList<>());
        }
        for (int[] arr : connections) {
            int u = arr[0];
            int v = arr[1];
            al1.get(u).add(v);
            al2.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        DFS(al1, al2, visited, 0);
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {
                { 0, 1 },
                { 1, 3 },
                { 2, 3 },
                { 4, 0 },
                { 4, 5 }
        };
        System.out.println(minReorder(n, connections));
    }

}