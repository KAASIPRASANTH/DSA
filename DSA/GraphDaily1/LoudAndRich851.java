import java.util.*;

public class LoudAndRich851 {
    static int[] res;

    public static void DFS(List<List<Integer>> al, boolean[] visited, int curr,int[] quiet) {
        visited[curr] = true;
        for (int i = 0; i < al.get(curr).size(); i++) {
            int richer = al.get(curr).get(i);
            if (visited[richer] == false) {
                DFS(al, visited, richer,quiet);
            }
            if(quiet[res[curr]]>=quiet[res[richer]]){
                res[curr] = res[richer];
            }
        }
    }

    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        res = new int[n];
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res[i] = i;
            al.add(new ArrayList<>());
        }
        for (int[] arr : richer) {
            al.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                DFS(al, visited, i,quiet);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] richer = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } };
        int[] quiet = { 3, 2, 5, 4, 6, 1, 7, 0 };
        int[] res = loudAndRich(richer, quiet);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
