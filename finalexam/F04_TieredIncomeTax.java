import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long income = sc.nextLong();
            long tax = 0;

            if (income <= 500000) {
                tax = income * 5 / 100;
            } else if (income <= 1000000) {
                tax = income * 12 / 100;
            } else if (income <= 2000000) {
                tax = income * 20 / 100;
            } else if (income <= 4000000) {
                tax = income * 30 / 100;
            } else {
                tax = income * 40 / 100;
            }

            sum += tax;
            System.out.println("Tax: $" + tax);
        }

        if (n > 0) {
            System.out.println("Average: $" + (sum / n));
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆收入計算稅額的時間為常數，總共處理 n 筆收入資料，
 *       因此總時間複雜度為 O(n)。
 */
