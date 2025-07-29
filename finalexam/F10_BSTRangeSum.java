import java.util.*;

public class F10_BSTRangeSum {
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
    static int sum(Node n, int L, int R) {
        if (n == null) return 0;
        if (n.v < L) return sum(n.r, L, R);
        if (n.v > R) return sum(n.l, L, R);
        return n.v + sum(n.l, L, R) + sum(n.r, L, R);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        Node root = build(a);
        System.out.println("Sum: " + sum(root, L, R));
    }
}
