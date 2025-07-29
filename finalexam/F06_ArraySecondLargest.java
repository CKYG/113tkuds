import java.util.*;

public class F06_ArraySecondLargest {
    static class Pair {
        int max, second;
        Pair(int max, int second) { this.max = max; this.second = second; }
    }
    static Pair solve(int[] a, int l, int r) {
        if (l + 1 == r) {
            int x = a[l], y = a[r];
            return x >= y ? new Pair(x, y) : new Pair(y, x);
        }
        if (l == r) return new Pair(a[l], Integer.MIN_VALUE);
        int m = (l + r) >>> 1;
        Pair p1 = solve(a, l, m);
        Pair p2 = solve(a, m + 1, r);
        if (p1.max >= p2.max) {
            int second = Math.max(p1.second, p2.max);
            return new Pair(p1.max, second);
        } else {
            int second = Math.max(p2.second, p1.max);
            return new Pair(p2.max, second);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Pair ans = solve(a, 0, n - 1);
        System.out.println("SecondMax: " + ans.second);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：遞迴分治使每個元素只被比較常數次，總計線性時間；合併步驟為常數成本，
 *       因此整體時間複雜度為 O(n)。
 */
