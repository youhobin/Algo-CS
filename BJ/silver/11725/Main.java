import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // 리스트 배열
    static List<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        tree = new ArrayList[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1, 0);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int node, int par) {
        parent[node] = par;
        for (int child : tree[node]) {
            if (child != par) {
                dfs(child, node);
            }
        }
    }
}
