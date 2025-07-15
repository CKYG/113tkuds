import java.util.*;

public class Q3_NightMarketRanking {
    private static boolean isValidScore(String s) {
        return s.matches("((1|2|3|4)(\\.[0-9])?|5(\\.0)?)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        if (n < 1 || n > 1000) return;

        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine().trim();
            if (!isValidScore(str)) return;
            scores[i] = Double.parseDouble(str);
        }
        sc.close();

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) maxIdx = j;
            }
            double tmp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = tmp;
        }

        int limit = Math.min(5, n);
        for (int i = 0; i < limit; i++) {
            System.out.printf("%.1f%n", scores[i]);
        }
    }
}

/*
 * Time Complexity: O(n²)
 * 說明：選擇排序需比較 n(n‑1)/2 次，故為 O(n²)；格式驗證與輸出皆 O(n)。
 */
