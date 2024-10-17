import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static boolean[] visited;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[r][c] = graph[c][r] = 1;
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node + " ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now + " ");

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[now][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
