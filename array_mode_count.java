public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};
        int maxCount = 0;
        int mode = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (i < arr.length - 2) {
                System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);
            }

            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}

//這程式使用兩層巢狀迴圈比對每個數字的出現次數，因此時間複雜度為 O(n²)
//可以，使用 HashMap 可改善為 O(n)