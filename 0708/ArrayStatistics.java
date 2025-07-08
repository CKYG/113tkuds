public class ArrayStatistics {
    public static void main(String[] args) {
        int[] data = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        for (int v : data) {
            sum += v;
        }
        double average = (double) sum / data.length;

        int max = data[0], min = data[0];
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
                maxIndex = i;
            }
            if (data[i] < min) {
                min = data[i];
                minIndex = i;
            }
        }

        int countAbove = 0;
        for (int v : data) {
            if (v > average) {
                countAbove++;
            }
        }

        int countEven = 0, countOdd = 0;
        for (int v : data) {
            if (v % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }

        System.out.println("=== 陣列統計結果 ===");
        System.out.printf("%-16s: %d%n", "總和", sum);
        System.out.printf("%-16s: %.2f%n", "平均值", average);
        System.out.printf("%-16s: %d （索引 %d）%n", "最大值", max, maxIndex);
        System.out.printf("%-16s: %d （索引 %d）%n", "最小值", min, minIndex);
        System.out.printf("%-16s: %d%n", "大於平均值個數", countAbove);
        System.out.printf("%-16s: %d%n", "偶數個數", countEven);
        System.out.printf("%-16s: %d%n", "奇數個數", countOdd);
    }
}
