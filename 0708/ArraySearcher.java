import java.util.Scanner;

public class ArraySearcher {
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int v : array) {
            if (v == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] data = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        int target1 = sc.nextInt();
        int target2 = sc.nextInt();

        int idx1 = findElement(data, target1);
        int occ1 = countOccurrences(data, target1);
        System.out.println("\n搜尋 " + target1 + "：");
        if (idx1 != -1) {
            System.out.println("  找到，索引位置 = " + idx1);
        } else {
            System.out.println("  未找到！");
        }
        System.out.println("  出現次數 = " + occ1);

        int idx2 = findElement(data, target2);
        int occ2 = countOccurrences(data, target2);
        System.out.println("\n搜尋 " + target2 + "：");
        if (idx2 != -1) {
            System.out.println("  找到，索引位置 = " + idx2);
        } else {
            System.out.println("  未找到！");
        }
        System.out.println("  出現次數 = " + occ2);

        sc.close();
    }
}
