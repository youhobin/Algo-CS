import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터 수
        int N = Integer.parseInt(br.readLine());
        // 연결된 컴퓨터 쌍의 수
        int M = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr[n][m] = arr[m][n] = 1;
        }

        dfs(1, N);

        // 1번 제외
        System.out.println(count - 1);
    }

    private static void dfs(int start, int N) {
        count++;
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && arr[start][i] == 1) {
                dfs(i, N);
            }
        }
    }
}
