public class GradeProcessor {
    public static void main(String[] args) {
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = (double) sum / scores.length;
        System.out.printf("總分：%d\n平均分數：%.2f\n", sum, average);

        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
        }
        System.out.printf("最高分：%d （索引 %d）\n", max, maxIndex);
        System.out.printf("最低分：%d （索引 %d）\n", min, minIndex);

        int countAbove = 0;
        for (int score : scores) {
            if (score > average) {
                countAbove++;
            }
        }
        System.out.printf("超過平均分的人數：%d 位\n", countAbove);

        System.out.println("\n所有成績：");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("學生 %d: %d\n", i, scores[i]);
        }
    }
}
