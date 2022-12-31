import java.util.*;

public class BridgeInGraph {
    static int[] desc, low, parent;
    static int time;
    static List<List<Integer>> res;

    public static void DFS(List<List<Integer>> al, int u) {
        desc[u] = low[u] = time++;
        for (int i = 0; i < al.get(u).size(); i++) {
            int v = al.get(u).get(i);
            if (desc[v] == -1) {
                parent[v] = u;
                DFS(al, v);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > desc[u]) {
                    res.add(Arrays.asList(u, v));
                }
            } else if (parent[u] != v) {
                low[u] = Math.min(low[u], desc[v]);
            }
        }
    }

    public static void findBridge(List<List<Integer>> al, int n) {
        time = 0;
        res = new ArrayList<>();
        desc = new int[n + 1];
        low = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(desc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        for (int i = 0; i <= n; i++) {
            if (desc[i] == -1) {
                DFS(al, i);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        al.get(0).add(1);
        al.get(0).add(2);
        al.get(0).add(3);

        al.get(1).add(0);
        al.get(1).add(2);

        al.get(2).add(0);
        al.get(2).add(1);

        al.get(3).add(4);

        al.get(4).add(3);

        findBridge(al, n);
    }
}