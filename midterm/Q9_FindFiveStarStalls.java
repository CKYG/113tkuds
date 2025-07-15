import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double score = sc.nextDouble();
            if (score >= 5.0) {
                idxList.add(i);
            }
        }
        sc.close();

        if (idxList.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < idxList.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(idxList.get(i));
            }
            System.out.println();
        }
    }
}
