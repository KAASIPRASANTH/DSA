import java.util.*;

public class NumberOfProvinces547 {
    public static void DFS(List<List<Integer>> al, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int i = 0; i < al.get(curr).size(); i++) {
            if (visited[al.get(curr).get(i)] == false) {
                DFS(al, visited, al.get(curr).get(i));
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, count = 0;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    al.get(i + 1).add(j + 1);
                }
            }
        }
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                count++;
                DFS(al, visited, i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println(findCircleNum(isConnected));
    }
}