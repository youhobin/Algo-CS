import java.util.*;

class Solution {
    //검은색 못감, 흰색은 길. 4방향가는거 가능
    //가장 빠른 방법으로, 못가는 경우도 존재.
    //도착하는 최솟값 return. 도착 못한다면 -1 
    //maps 는 n x m. 0은 벽, 1은 길. 시작(1,1). 상대(n,m)
    public static int answer;
    public static int[] rows = {-1, 1, 0, 0};
    public static int[] cols = {0, 0, -1, 1};
    public int solution(int[][] maps) {


        return bfs(maps);
    }

    public static int bfs(int[][] maps) {
        int r = maps.length;
        int c = maps[0].length;
        boolean[][] visited = new boolean[r][c];
        Queue<Person> queue = new LinkedList<>();
        queue.offer(new Person(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Person person = queue.poll();
            int row = person.row;
            int col = person.col;

            if (row == r - 1 && col == c - 1) {
                return person.dis;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = row + rows[i];
                int ncol = col + cols[i];

                if (nrow < 0 || ncol < 0 || nrow >= r || ncol >= c) continue;
                if (visited[nrow][ncol]) continue;
                if (maps[nrow][ncol] == 0) continue;

                queue.offer(new Person(nrow, ncol, person.dis + 1));
                visited[nrow][ncol] = true;
            }
        }

        return -1;

    }

    public static class Person {
        int row;
        int col;
        int dis;

        public Person(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
}