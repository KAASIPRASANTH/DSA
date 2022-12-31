import java.util.*;
public class IsGraphBipartite785 {
    public static boolean isTwoColorable(List<List<Integer>> al,int[] colors,int curr){
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        colors[curr] = 0;
        while(!q.isEmpty()){
            int adj = q.poll();
            for(int i=0;i<al.get(adj).size();i++){
                int child = al.get(adj).get(i);
                if(colors[child] == colors[adj]){
                    return false;
                }
                if(colors[child] == -1){
                    colors[child] = 1-colors[adj];
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                al.get(i).add(graph[i][j]);
                al.get(graph[i][j]).add(i);
            }
        }
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int i=0;i<n;i++){
            if(colors[i] == -1){
                if(!isTwoColorable(al,colors,i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(graph));
    }
}