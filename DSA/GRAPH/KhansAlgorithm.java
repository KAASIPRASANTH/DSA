import java.util.*;

public class KhansAlgorithm {
    public static void topo(List<List<Integer>> al, int[] inDeg, int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int pop = q.poll();
            for (int i = 0; i < al.get(pop).size(); i++) {
                if (--inDeg[al.get(pop).get(i)] == 0) {
                    q.add(al.get(pop).get(i));
                }
            }
            res.add(pop);
        }
        // System.out.println(res);
        if (res.size() == n + 1) {
            System.out.println(res);
        } else {
            System.out.println("Not Directed Acyclic Graph");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }

        al.get(2).add(1);

        al.get(3).add(0);
        al.get(3).add(2);

        al.get(4).add(0);
        al.get(4).add(1);

        al.get(5).add(0);
        al.get(5).add(3);

        int[] inDeg = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                inDeg[al.get(i).get(j)]++;
            }
        }
        topo(al, inDeg, n);
    }
}
