import java.util.*;

public class ArticulationPoint {
    static int[] disc, low, parent, children;
    static boolean[] isArticulationPoint;
    static int time;

    private static void DFS(List<List<Integer>> al, int u) {
        disc[u] = low[u] = time++;
        for (int i = 0; i < al.get(u).size(); i++) {
            int v = al.get(u).get(i);
            if (disc[v] == -1) {
                children[u]++;
                parent[v] = u;
                DFS(al, v);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children[u] > 1) {
                    isArticulationPoint[u] = true;
                }
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    isArticulationPoint[u] = true;
                }
            } else if (parent[u] != v) {
                low[u] = Math.min(low[v], disc[u]);
            }
        }
    }

    public static void articulationPoint(List<List<Integer>> al, int n) {
        time = 0;
        disc = new int[n + 1];
        low = new int[n + 1];
        parent = new int[n + 1];
        children = new int[n + 1];
        isArticulationPoint = new boolean[n + 1];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        for (int i = 0; i <= n; i++) {
            if (disc[i] == -1) {
                DFS(al, i);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (isArticulationPoint[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }

        /*
         * al.get(0).add(1);
         * al.get(0).add(2);
         * al.get(0).add(3);
         * 
         * al.get(1).add(0);
         * al.get(1).add(2);
         * 
         * al.get(2).add(0);
         * al.get(2).add(1);
         * 
         * al.get(3).add(4);
         * al.get(3).add(5);
         * 
         * al.get(4).add(3);
         * 
         * al.get(5).add(3);
         */

        al.get(0).add(1);
        al.get(0).add(2);

        al.get(1).add(0);
        al.get(1).add(2);
        al.get(1).add(3);
        al.get(1).add(4);

        al.get(2).add(0);
        al.get(2).add(1);
        al.get(2).add(3);

        al.get(3).add(1);
        al.get(3).add(2);

        al.get(4).add(1);

        articulationPoint(al, n);
    }
}