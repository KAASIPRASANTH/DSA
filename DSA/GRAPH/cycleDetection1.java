import java.util.*;

public class cycleDetection1 {
    public static boolean DFS(List<List<Integer>> al, boolean[] visited, int curr) {
        if (visited[curr] == true) {
            visited[curr] = false;
            return true;
        }
        visited[curr] = true;
        for (int i = 0; i < al.get(curr).size(); i++) {
            int adj = al.get(curr).get(i);
            if (DFS(al, visited, adj)) {
                return true;
            }
        }
        visited[curr] = false;
        return false;
    }

    public static void isCycle(List<List<Integer>> al, int n) {
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            if (DFS(al, visited, i)) {
                System.out.println("Cycle");
                return;
            }
        }
        System.out.println("No Cycle");
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        // cycle
        al.get(0).add(1);

        al.get(2).add(1);
        al.get(2).add(3);

        al.get(3).add(4);

        al.get(4).add(0);
        al.get(4).add(2);
        isCycle(al, n);
    }
}