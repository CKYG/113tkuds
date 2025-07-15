import java.util.*;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) { sc.close(); return; }
        int n = sc.nextInt();

        if (n < 1 || n > 12) {
            System.out.println("Invalid");
            sc.close();
            return;
        }

        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
            if (stops[i].length() != 3) {
                System.out.println("Invalid");
                sc.close();
                return;
            }
        }

        String start = sc.next();
        String end   = sc.next();
        sc.close();

        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) startIdx = i;
            if (stops[i].equals(end))   endIdx   = i;
            if (startIdx != -1 && endIdx != -1) break;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            int count = Math.abs(startIdx - endIdx) + 1;
            System.out.println(count);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：僅需一次線性走訪長度 n 的陣列以尋找 start、end 之索引，
 *       其餘皆為 O(1)，故總時間複雜度為 O(n)。
 */
