import java.util.*;

public class FindTheTownJudge997 {
    public static int findJudge(int n, int[][] trust) {
        List<Integer> notJudge = new ArrayList<>();
        int[] inDeg = new int[n + 1];
        for (int[] t : trust) {
            notJudge.add(t[0]);
            inDeg[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == n - 1 && !notJudge.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {
                { 1, 3 },
                { 2, 3 }
        };
        System.out.println(findJudge(n, trust));
    }
}
