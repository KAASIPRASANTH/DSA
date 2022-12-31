public class NetworkDelayTime743 {
    /*
     * static int max;
     * 
     * public static void BFS(List<List<Pair<Integer, Integer>>> al, int n, int k) {
     * Queue<Pair<Integer, Integer>> q = new LinkedList<>();
     * int[] distance = new int[n + 1];
     * Arrays.fill(distance, Integer.MAX_VALUE);
     * distance[k] = 0;
     * q.add(new Pair<>(k,0));
     * while (!q.isEmpty()) {
     * Pair<Integer, Integer> P = q.poll();
     * int parent = P.getKey();
     * int parentWeight = P.getValue();
     * for (Pair<Integer, Integer> C : al.get(parent)) {
     * int child = C.getKey();
     * int childWight = C.getValue();
     * if (distance[parent] + childWight < distance[child]) {
     * distance[child] = distance[parent] + childWight;
     * q.add(new Pair<>(child, distance[child]));
     * }
     * }
     * }
     * for (int i = 1; i <= n; i++) {
     * if (distance[i] == Integer.MAX_VALUE) {
     * max = -1;
     * break;
     * }
     * max = Math.max(max, distance[i]);
     * }
     * }
     * 
     * public static int networkDelayTime(int[][] times, int n, int k) {
     * max = 0;
     * List<List<Pair<Integer, Integer>>> al = new ArrayList<>();
     * for (int i = 0; i <= n; i++) {
     * al.add(new ArrayList<>());
     * }
     * for (int[] arr : times) {
     * al.get(arr[0]).add(new Pair<>(arr[1], arr[2]));
     * }
     * BFS(al, n, k);
     * return max;
     * }
     * 
     * public static void main(String[] args) {
     * int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
     * int n = 4, k = 2;
     * System.out.println(networkDelayTime(times, n, k));
     * }
     */
}
