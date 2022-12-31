import java.util.*;

public class AllAncestorsOfANodeInADirectedAcyclicGraph2192 {
    static List<List<Integer>> res;
    static Set<Integer> set;

    public static void DFS(List<List<Integer>> al, int curr) {
        for (int i = 0; i < al.get(curr).size(); i++) {
            int ancestor = al.get(curr).get(i);
            if (res.get(ancestor).size() > 0) {
                set.add(ancestor);
                set.addAll(res.get(ancestor));
            } else if (!set.contains(ancestor)) {
                set.add(ancestor);
                DFS(al, ancestor);
            }
        }
    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        res = new ArrayList<>();
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            al.get(arr[1]).add(arr[0]);
        }
        for (int i = 0; i < n; i++) {
            set = new HashSet<>();
            DFS(al, i);
            res.get(i).addAll(new ArrayList<>(set));
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] edgeList = { { 0, 3 }, { 0, 4 }, { 1, 3 }, { 2, 4 }, { 2, 7 }, { 3, 5 }, { 3, 6 }, { 3, 7 }, { 4, 6 } };
        System.out.println(getAncestors(n, edgeList));
    }
}
