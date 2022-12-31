import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodes1557 {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        int[] inDeg = new int[n];
        for(int i=0;i<edges.size();i++){
            int v = edges.get(i).get(1);
            inDeg[v]++;
        }
        for(int i=0;i<n;i++){
            if(inDeg[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
        
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0,1));
        edges.add(Arrays.asList(0,2));
        edges.add(Arrays.asList(2,5));
        edges.add(Arrays.asList(3,4));
        edges.add(Arrays.asList(4,2));
        int n=6;
        System.out.println(findSmallestSetOfVertices(n, edges));
    }
}
