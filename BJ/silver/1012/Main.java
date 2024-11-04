import java.util.*;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int M, N, K;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            M = sc.nextInt(); // 가로 길이
            N = sc.nextInt(); // 세로 길이
            K = sc.nextInt(); // 배추의 수

            field = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[x][y] = 1; // 배추가 심어진 위치
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j); // DFS 호출
                        count++;
                    }
                }
            }
            System.out.println(count); // 그룹 수 출력
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true; // 현재 위치 방문 처리
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny); // 인접한 배추로 이동
                }
            }
        }
    }
}

