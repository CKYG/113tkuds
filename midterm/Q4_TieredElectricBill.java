import java.util.*;

public class Q4_TieredElectricBill {

    private static int calc(int k) {
        double fee = 0;
        int remain = k;

        int used;

        used = Math.min(remain, 120);
        fee += used * 1.68;
        remain -= used;

        if (remain > 0) {
            used = Math.min(remain, 330 - 120);
            fee += used * 2.45;
            remain -= used;
        }
        if (remain > 0) {
            used = Math.min(remain, 500 - 330);
            fee += used * 3.70;
            remain -= used;
        }
        if (remain > 0) {
            used = Math.min(remain, 700 - 500);
            fee += used * 5.04;
            remain -= used;
        }
        if (remain > 0) {
            used = Math.min(remain, 1000 - 700);
            fee += used * 6.24;
            remain -= used;
        }
        if (remain > 0) {
            fee += remain * 8.46;
        }

        return (int) Math.round(fee);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        if (n < 1 || n > 1000) return;

        int total = 0;
        int[] bills = new int[n];

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            if (kWh < 0 || kWh > 5000) return;
            bills[i] = calc(kWh);
            total += bills[i];
        }
        sc.close();

        for (int bill : bills) {
            System.out.println("Bill: $" + bill);
        }

        int avg = (int) Math.round((double) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：對每戶呼叫 calc(int k) 時僅執行固定次段計算 O(1)，
 *       整體走訪 n 戶為 O(n)；輸出亦為 O(n)。
 */
