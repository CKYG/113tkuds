import java.util.*;

public class Q5_CPB​LPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        if (n < 1 || n > 144) return;

        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            ps[i] = ps[i - 1] + x;
        }

        int k = sc.nextInt();
        sc.close();
        if (k < 1 || k > n) return;

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：建立前綴和需走訪 n 次；查詢與輸出前 k 項再走訪 k 次，
 *       最壞 k = n，總計 O(n)。其餘操作皆 O(1)。
 */
