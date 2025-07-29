import java.util.*;

public class F11_BSTClosestValue {
    static class Node {
        int v;
        Node l, r;
        Node(int v) { this.v = v; }
    }
    static Node build(int[] a) {
        if (a.length == 0 || a[0] == -1) return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(a[0]);
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < a.length) {
            Node cur = q.poll();
            if (i < a.length && a[i] != -1) {
                cur.l = new Node(a[i]);
                q.add(cur.l);
            }
            i++;
            if (i < a.length && a[i] != -1) {
                cur.r = new Node(a[i]);
                q.add(cur.r);
            }
            i++;
        }
        return root;
    }
    static int closest(Node root, int t) {
        int best = root.v;
        Node cur = root;
        while (cur != null) {
            int diff = Math.abs(cur.v - t);
            int bestDiff = Math.abs(best - t);
            if (diff < bestDiff || (diff == bestDiff && cur.v < best))
                best = cur.v;
            cur = (t < cur.v) ? cur.l : cur.r;
        }
        return best;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int T = sc.nextInt();
        Node root = build(a);
        System.out.println("Closest: " + closest(root, T));
    }
}
