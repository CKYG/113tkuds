import java.util.*;

public class F08_ClimbStairsMemo {
    static long[] memo = new long[41];
    static long f(int n) {
        if (n < 0) return 0;
        if (memo[n] != 0) return memo[n];
        if (n == 0) return memo[0] = 1;
        memo[n] = f(n - 1) + f(n - 2) + f(n - 3);
        return memo[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Ways: " + f(n));
    }
}