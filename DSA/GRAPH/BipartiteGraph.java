import java.util.*;

public class BipartiteGraph {
    public static boolean isBipartite(List<List<Integer>> al, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        q.add(0);
        colors[0] = 1;
        while (!q.isEmpty()) {
            int pop = q.poll();
            for (int i = 0; i < al.get(pop).size(); i++) {
                int adj = al.get(pop).get(i);
                if (colors[adj] == colors[pop]) {
                    return false;
                }
                if (colors[adj] == -1) {
                    colors[adj] = 1 - colors[pop];
                    q.add(adj);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        // even length
        al.get(0).add(1);
        al.get(1).add(0);

        al.get(1).add(2);
        al.get(2).add(1);

        al.get(2).add(3);
        al.get(3).add(2);

        al.get(3).add(0);
        al.get(0).add(3);
        
        // odd length
        /* 
        al.get(0).add(1);
        al.get(1).add(0);

        al.get(1).add(2);
        al.get(2).add(1);

        al.get(2).add(3);
        al.get(3).add(2);

        al.get(3).add(4);
        al.get(4).add(3);

        al.get(4).add(0);
        al.get(0).add(4);
        */
        if (isBipartite(al, n)) {
            System.out.println("Bipartite");
        } else {
            System.out.print("Not Bipartite");
        }
    }
}
