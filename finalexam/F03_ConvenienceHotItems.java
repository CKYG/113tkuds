import java.util.*;

public class F03_ConvenienceHotItems {
    static class Item {
        String name;
        int qty;
        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            arr[i] = new Item(name, qty);
        }
        for (int i = 1; i < n; i++) {
            Item key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].qty < key.qty) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        int limit = Math.min(10, n);
        for (int i = 0; i < limit; i++) {
            System.out.println(arr[i].name + " " + arr[i].qty);
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：插入排序在最壞情況（資料完全逆序）時需進行約 n(n‑1)/2 次比較與移動，
 *       因此總時間複雜度為 O(n^2)。
 */
