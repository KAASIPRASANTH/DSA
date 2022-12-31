import java.util.*;

public class AllPathsFromSourceToTarget797 {
    static int n;
    public static void DFS(List<List<Integer>> al,boolean[] visited,int curr,List<List<Integer>> res,List<Integer> temp){
        if(curr == n-1){
            temp.add(curr);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        visited[curr] = true;
        for(int i=0;i<al.get(curr).size();i++){
            int adj = al.get(curr).get(i);
            if(!visited[adj]){
                temp.add(curr);
                DFS(al,visited,adj,res,temp);
                temp.remove(temp.size()-1);
            }
        }
        visited[curr] = false;
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> al = new ArrayList<>();
        n=graph.length;
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
            for(int j=0;j<graph[i].length;j++){
                al.get(i).add(graph[i][j]);
            }
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        DFS(al,visited,0,res,temp);
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 1, 2 },
                { 3 },
                { 3 },
                {}
        };
        System.out.println(allPathsSourceTarget(graph));
    }
}
