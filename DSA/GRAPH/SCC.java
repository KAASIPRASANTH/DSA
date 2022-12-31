import java.util.*;

public class SCC {
    static int time;
    static int[] disc, low;

    public static void DFS(List<List<Integer>> al, Stack<Integer> stk, int u, boolean[] visited) {
        disc[u] = low[u] = time++;
        stk.push(u);
        visited[u] = true;
        for (int i = 0; i < al.get(u).size(); i++) {
            int v = al.get(u).get(i);
            if (disc[v] == -1) {
                DFS(al, stk, v, visited);
                low[u] = Math.min(low[u], low[v]);
            } else if (visited[v] == true) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (disc[u] == u ) {
            List<Integer> res = new ArrayList<>();
            while (stk.peek() != u) {
                int popped = stk.pop();
                visited[popped] = false;
                res.add(popped);
            }
            visited[stk.peek()] = false;
            res.add(stk.pop());
            System.out.println("SCC " + res);
        }
        visited[u] = false;
    }

    public static void StronglyConnectedComponent(List<List<Integer>> al, int n) {
        disc = new int[n + 1];
        low = new int[n + 1];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        time = 0;
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i <= n; i++) {
            if (disc[i] == -1) {
                DFS(al, stk, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        al.get(0).add(1);

        al.get(1).add(2);
        al.get(1).add(3);

        al.get(3).add(4);

        al.get(4).add(0);
        al.get(4).add(5);
        al.get(4).add(6);

        al.get(5).add(2);
        al.get(5).add(6);

        al.get(6).add(5);

        StronglyConnectedComponent(al, n);
    }
}