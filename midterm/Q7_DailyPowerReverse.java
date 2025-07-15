import java.util.*;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int left = 0, right = 6;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(arr[i]);
            if (i != 6) System.out.print(" ");
        }
        System.out.println();
    }
}
