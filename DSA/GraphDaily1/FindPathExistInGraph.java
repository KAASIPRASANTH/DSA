import java.util.*;
public class FindPathExistInGraph{
    public static boolean dfs(List<List<Integer>> al,boolean[] visited,int curr,int destination){
        if(curr == destination){
            return true;
        }
        visited[curr] = true;
        for(int i=0;i<al.get(curr).size();i++){
            if(visited[al.get(curr).get(i)] == false){
                if(dfs(al, visited, al.get(curr).get(i), destination)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] edges ={
            {0,1},
            {1,2},
            {2,0}
        };
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0],v = edge[1];
            al.get(u).add(v);
            al.get(v).add(u);
        }
        int source = 0,destination = 2;
        System.out.println(dfs(al,new boolean[n], source, destination));
    }
}