import java.util.*;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String s = sc.nextLine();
        int mask = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                int bit = Character.toLowerCase(c) - 'a';
                mask ^= 1 << bit;
            }
        }
        if (mask == 0 || (mask & (mask - 1)) == 0) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}
