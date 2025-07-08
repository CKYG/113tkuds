public class ArrayUtility {
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static int findSecondLargest(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("陣列長度需至少為 2");
        }
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int v : array) {
            if (v > max) {
                second = max;
                max = v;
            } else if (v > second && v < max) {
                second = v;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] data = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.println("原始陣列：");
        printArray(data);

        int[] copy = copyArray(data);
        System.out.println("\n複製後的陣列（copyArray）：");
        printArray(copy);

        reverseArray(data);
        System.out.println("\n反轉後的原始陣列（reverseArray）：");
        printArray(data);

        reverseArray(data);

        int secondLargest = findSecondLargest(data);
        System.out.println("\n第二大的數值（findSecondLargest）： " + secondLargest);
    }
}
