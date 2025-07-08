public class StudentGradeSystem {
    public static char getGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else {
            return 'D';
        }
    }

    public static void printFullReport(int[] scores) {
        int n = scores.length;
        int sum = 0;
        int countA = 0, countB = 0, countC = 0, countD = 0;
        int max = scores[0], min = scores[0];
        int maxIdx = 0, minIdx = 0;
        int countAbove = 0;

        for (int i = 0; i < n; i++) {
            int s = scores[i];
            sum += s;

            char grade = getGrade(s);
            switch (grade) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
            }

            if (s > max) {
                max = s;
                maxIdx = i;
            }
            if (s < min) {
                min = s;
                minIdx = i;
            }
        }

        double average = (double) sum / n;
        for (int s : scores) {
            if (s > average) countAbove++;
        }
        double ratioAbove = (double) countAbove / n * 100;

        System.out.println("===== 學生成績報告 =====");
        System.out.println("-------------------------");
        System.out.printf("學生人數：%d  平均分：%.2f%n", n, average);
        System.out.printf("總分     ：%d%n", sum);
        System.out.printf("最高分   ：%d （學生編號 %d）%n", max, maxIdx + 1);
        System.out.printf("最低分   ：%d （學生編號 %d）%n", min, minIdx + 1);
        System.out.printf("A 級人數：%d   B 級人數：%d   C 級人數：%d   D 級人數：%d%n",
                          countA, countB, countC, countD);
        System.out.printf("高於平均分比例：%.1f%%%n", ratioAbove);
        System.out.println("-------------------------");
        System.out.println("學生明細：編號 | 分數 | 等級");
        System.out.println("-------------------------");
        for (int i = 0; i < n; i++) {
            char g = getGrade(scores[i]);
            System.out.printf("   %2d   |  %3d |   %c%n", i + 1, scores[i], g);
        }
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        printFullReport(scores);
    }
}
