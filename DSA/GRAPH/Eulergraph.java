import java.util.*;

public class Eulergraph {
    public static void DFS(List<List<Integer>> al, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int i = 0; i < al.get(curr).size(); i++) {
            int adj = al.get(curr).get(i);
            if (visited[adj] == false) {
                DFS(al, visited, adj);
            }
        }
    }

    public static boolean isSingleComponent(List<List<Integer>> al, int n) {
        int vertex = -1;
        for (int i = 0; i < n; i++) {
            if (al.get(i).size() > 0) {
                vertex = i;
                break;
            }
        }
        if (vertex == -1) {
            return true;
        }
        boolean[] visited = new boolean[n];
        DFS(al, visited, vertex);
        for (int i = 0; i < n; i++) {
            if (visited[i] == false && al.get(i).size() > 0) {
                return false;
            }
        }
        return true;
    }

    public static int findEuler(List<List<Integer>> al, int n) {
        boolean isConnected = isSingleComponent(al, n);
        if (isConnected == false) {
            return 0;
        }
        int oddDegCount = 0;
        for (int i = 0; i < n; i++) {
            int deg = al.get(i).size();
            if (deg % 2 == 1) {
                oddDegCount++;
            }
        }
        if (oddDegCount > 2) {
            return 0;
        }
        return (oddDegCount == 0) ? 2 : 1;
    }

    public static void typeOfEulerGraph(List<List<Integer>> al, int n) {
        int res = findEuler(al, n);
        if (res == 0)
            System.out.println("Not a Euler Graph");
        else if (res == 1)
            System.out.println("Semi-Euler Graph");
        else if (res == 2)
            System.out.println("Euler Graph");
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        al.get(0).add(1);
        al.get(0).add(2);

        al.get(1).add(0);
        al.get(1).add(2);

        al.get(2).add(0);
        al.get(2).add(1);
        al.get(2).add(3);
        al.get(2).add(4);

        al.get(3).add(2);
        al.get(3).add(4);

        al.get(4).add(2);
        al.get(4).add(3);

        typeOfEulerGraph(al, n);
    }
}