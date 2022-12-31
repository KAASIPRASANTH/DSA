import java.util.*;

public class TopologicalSort1 {
    public static void DFS(List<List<Integer>> al, boolean[] visited, int curr, Stack<Integer> stk) {
        visited[curr] = true;
        for (int i = 0; i < al.get(curr).size(); i++) {
            if (visited[al.get(curr).get(i)] == false) {
                DFS(al, visited, al.get(curr).get(i), stk);
            }
        }
        stk.push(curr);
    }

    public static void topo(List<List<Integer>> al, int n) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                DFS(al, visited, i, stk);
            }
        }
        while(!stk.isEmpty()){
            System.out.print(stk.pop()+" ");
        }
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        al.get(0).add(2);
        al.get(0).add(3);

        al.get(3).add(1);

        al.get(4).add(1);
        al.get(4).add(2);

        al.get(5).add(0);
        al.get(5).add(2);

        topo(al, n);
    }
}
