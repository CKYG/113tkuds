import java.util.*;

public class F12_TreeDiameter {
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
    static int best;
    static int dfs(Node n) {
        if (n == null) return -1;
        int lh = dfs(n.l) + 1;
        int rh = dfs(n.r) + 1;
        best = Math.max(best, lh + rh);
        return Math.max(lh, rh);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Node root = build(a);
        best = 0;
        dfs(root);
        System.out.println("Diameter: " + best);
    }
}
