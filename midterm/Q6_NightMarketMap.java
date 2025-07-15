import java.util.*;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int m = sc.nextInt();

        char[][] map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(map[i], '#');
        }

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (0 <= r && r < 10 && 0 <= c && c < 10) {
                map[r][c] = '*';
            }
        }
        sc.close();

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }
}
