import java.util.*;

public class ReachableNodesWithRestrictions2368 {
    static int count;
    public static void DFS(List<List<Integer>> al,boolean[] visited,int curr){
        visited[curr] = true;
        count++;
        for(int i=0;i<al.get(curr).size();i++){
            if(visited[al.get(curr).get(i)] == false){
                DFS(al, visited, al.get(curr).get(i));
            }
        }
    }
    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        count = 0;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            al.get(arr[0]).add(arr[1]);
            al.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[n];
        for(int i=0;i<restricted.length;i++){
            visited[restricted[i]] = true;
        }
        DFS(al,visited,0);
        return count;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 0 }, { 0, 5 }, { 5, 6 } };
        int[] restricted = { 4, 5 };
        System.out.println(reachableNodes(n, edges, restricted));
    }
}
