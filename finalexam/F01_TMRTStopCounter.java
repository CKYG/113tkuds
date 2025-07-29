import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        String start = sc.next();
        String end = sc.next();

        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                idx1 = i;
            }
            if (stops[i].equals(end)) {
                idx2 = i;
            }
        }

        if (idx1 == -1 || idx2 == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(idx1 - idx2) + 1);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：透過一次 for 迴圈線性掃描 n 個站點來找出起點與終點的索引位置，因此時間複雜度為 O(n)。
 * 之後的絕對值與加法為常數時間，不影響整體複雜度。
 */
