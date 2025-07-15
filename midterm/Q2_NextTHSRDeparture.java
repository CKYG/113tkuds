import java.util.*;

public class Q2_NextTHSRDeparture {

    private static int toMinutes(String hhmm) {
        if (!hhmm.matches("\\d{2}:\\d{2}")) return -1;
        int h = Integer.parseInt(hhmm.substring(0, 2));
        int m = Integer.parseInt(hhmm.substring(3));
        return h * 60 + m;
    }

    private static String toHHmm(int minutes) {
        int h = minutes / 60, m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀 n，並檢查 1 ≤ n ≤ 80
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        if (n < 1 || n > 80) {
            System.out.println("No train");
            return;
        }

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String timeStr = sc.nextLine().trim();
            int min = toMinutes(timeStr);
            if (min < 0) {
                System.out.println("No train");
                return;
            }
            times[i] = min;
        }

        String queryStr = sc.nextLine().trim();
        int queryMin = toMinutes(queryStr);
        if (queryMin < 0) {
            System.out.println("No train");
            return;
        }
        sc.close();

        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (times[mid] > queryMin) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == n) {
            System.out.println("No train");
        } else {
            System.out.println(toHHmm(times[left]));
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：已排序陣列上做二分搜尋，每次折半，故 O(log n)；
 *       轉字串與格式驗證皆 O(1)。
 */
