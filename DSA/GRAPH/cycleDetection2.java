import java.util.*;

public class cycleDetection2 {
    public static boolean DFS(List<List<Integer>> al, int[] visited, int curr) {
        if (visited[curr] == 2) {
            System.out.println(curr);
            return true;
        }
        visited[curr] = 2;
        for (int i = 0; i < al.get(curr).size(); i++) {
            int adj = al.get(curr).get(i);
            if (visited[adj] != 1 && DFS(al, visited, adj)) {
                return true;
            }
        }
        visited[curr] = 1;
        return false;
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
       // al.get(4).add(2);
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1 && DFS(al,visited,i)) {
                System.out.println("Cycle");
                return;
            }
        }
        System.out.println("No Cycle");
    }
}
