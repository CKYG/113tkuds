import java.util.*;

public class F05_LCMRecursive {
    static long gcd(long a, long b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        return gcd(a, b - a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long g = gcd(a, b);
        long lcm = a / g * b;
        System.out.println("LCM: " + lcm);
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：輾轉相減法每次遞迴至少將較大數減去較小數 1，
 *       最壞情況需進行約 max(a, b)‑1 次遞迴呼叫，因此
 *       時間複雜度為 O(max(a, b))，記為 O(n)。
 */
