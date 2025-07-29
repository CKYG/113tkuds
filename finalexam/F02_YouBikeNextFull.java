import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            times[i] = h * 60 + m;
        }

        String[] qparts = sc.nextLine().split(":");
        int q = Integer.parseInt(qparts[0]) * 60 + Integer.parseInt(qparts[1]);

        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > q) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No bike");
        } else {
            int h = times[ans] / 60;
            int m = times[ans] % 60;
            System.out.printf("%02d:%02d\n", h, m);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋在已排序的 n 個時間中找出第一個大於查詢時間的項目，
 * 搜尋過程只需 log₂n 次比較，因此時間複雜度為 O(log n)。
 */
