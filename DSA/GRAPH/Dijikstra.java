import java.util.*;

public class Dijikstra {
    public static int getMinDistanceVertex(int[] distance, boolean[] processed) {
        int minDistance = Integer.MAX_VALUE, vertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (processed[i] == false && distance[i] < minDistance) {
                minDistance = distance[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public static void shortestPath(int[][] cost, int n) {
        int[] distance = new int[n];
        boolean[] processed = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        for (int i = 0; i < n; i++) {
            int vertex = getMinDistanceVertex(distance, processed);
            if (vertex != -1) {
                processed[vertex] = true;
                for (int j = 0; j < n; j++) {
                    if (!processed[j] && cost[vertex][j]!=0 && distance[vertex] + cost[vertex][j] < distance[j]) {
                        parent[j] = vertex;
                        distance[j] = distance[vertex] + cost[vertex][j];
                    }
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(parent[i] + " " + i + " " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] cost = {
                { 0, 1, 4, 0, 0, 0 },
                { 1, 0, 4, 2, 7, 0 },
                { 4, 4, 0, 3, 5, 0 },
                { 0, 2, 3, 0, 4, 6 },
                { 0, 7, 5, 4, 0, 7 },
                { 0, 0, 0, 6, 7, 0 }
        };
        shortestPath(cost, n);
    }
}
