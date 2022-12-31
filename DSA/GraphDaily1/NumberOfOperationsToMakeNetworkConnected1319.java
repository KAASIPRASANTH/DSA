import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected1319 {
    static int totEdges;

    public static void DFS(List<List<Integer>> al, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int i = 0; i < al.get(curr).size(); i++) {
            if (visited[al.get(curr).get(i)] == false) {
                totEdges--;
                DFS(al, visited, al.get(curr).get(i));
            }
        }
    }

    public static int makeConnected(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        totEdges = connections.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int[] arr : connections) {
            al.get(arr[0]).add(arr[1]);
            al.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                count++;
                DFS(al, visited, i);
            }
        }
        return (totEdges >= count - 1) ? count - 1 : -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(makeConnected(n, connections));
    }
}
