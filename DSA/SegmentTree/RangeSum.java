import java.util.*;

public class RangeSum {
    static int[] segmentTree;

    public static int createSegmentTree(int[] nums, int SI, int sl, int sr) {
        if (sl == sr) {
            return (segmentTree[SI] = nums[SI]);
        }
        int mid = sl + (sr - sl) / 2;
        int left = createSegmentTree(nums, SI * 2 + 1, sl, mid);
        int right = createSegmentTree(nums, SI * 2 + 2, mid + 1, sr);
        segmentTree[SI] = left + right;
        return segmentTree[SI];
    }

    public static int getRangeSum(int SI, int sl, int sr, int left, int right) {
        if (right < sl || sr < left) { //partially overlap
            return 0;
        }
        if (left <= sl && sr <= right) { // total overlap
            return segmentTree[SI];
        }
        //System.err.println("1");
        int mid = sl + (sr - sl) / 2;
        int leftSide = getRangeSum(SI * 2 + 1, sl, mid, left, right);
        int rightSide = getRangeSum(SI * 2 + 2, mid + 1, sr, left, right);
        return leftSide + rightSide;
    }

    public static void updateSegmentTree(int SI, int pos, int sl, int sr, int newVal) {
        if (sl > pos || pos > sr) {
            return;
        }
        if (sl == sr) {
            segmentTree[SI] = newVal;
            return;
        }
        int mid = sl + (sr - sl) / 2;
        updateSegmentTree(SI * 2 + 1, pos, sl, mid, newVal);
        updateSegmentTree(SI * 2 + 2, pos, mid + 1, sr, newVal);
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int height = (int) Math.ceil(Math.log10(n) / Math.log10(2)) + 1;
        int size = (1 << height);
        segmentTree = new int[size];
        int sum = createSegmentTree(nums, 0, 0, n - 1);
        System.out.println(sum);
        int left = 0, right = n - 1;
        int res = getRangeSum(0, 0, n - 1, left, right);
        sc.close();
        System.out.println(res);
    }
}