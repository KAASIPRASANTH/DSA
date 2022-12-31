import java.util.*;
public class KeysAndRooms841 {
    public static void DFS(List<List<Integer>> al,boolean[] visited,int curr){
        visited[curr] = true;
        for(int i=0;i<al.get(curr).size();i++){
            if(visited[al.get(curr).get(i)] == false){
                DFS(al, visited, al.get(curr).get(i));
            }
        }
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<List<Integer>> al = new ArrayList<>();
        int n = rooms.size();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<rooms.get(i).size();j++){
                al.get(i).add(rooms.get(i).get(j));
            }
        }
        boolean[] visited = new boolean[n];
        DFS(al,visited,0);
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());
        System.out.println(canVisitAllRooms(rooms));
    }
}
