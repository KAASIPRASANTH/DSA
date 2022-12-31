import java.util.*;

public class FindEventualSafeStates802 {
    static List<Integer> res;

    public static void topo(List<List<Integer>> al, int[] outDeg) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < outDeg.length; i++) {
            if (outDeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int terminate = q.poll();
            for (int i = 0; i < al.get(terminate).size(); i++) {
                outDeg[al.get(terminate).get(i)]--;
                if (outDeg[al.get(terminate).get(i)] == 0) {
                    q.add(al.get(terminate).get(i));
                }
            }
            res.add(terminate);
        }
        Collections.sort(res);
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        res = new ArrayList<>();
        List<List<Integer>> al = new ArrayList<>();
        int n = graph.length;
        int[] outDeg = new int[n];
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
            outDeg[i] = graph[i].length;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                al.get(graph[i][j]).add(i);
            }
        }
        topo(al, outDeg);
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println(eventualSafeNodes(graph));
    }
}
