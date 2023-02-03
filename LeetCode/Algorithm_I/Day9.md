### Day 9

---

#### 994. Rotting Oranges `java`

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        // 초기 배열이 0이면 시간도 0 리턴
        if(grid == null || grid.length == 0) return 0;
        
        //길이 구하기
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 1 갯수 - 신선한 오렌지
        int count_fresh = 0;

        //rotten 오렌지를  queue에 넣기.
        //신선한 오렌지 갯수 세기.
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        //신선한 오렌지가 0이면 시간도 0 리턴
        if(count_fresh == 0) return 0;

        //모두 썩기위한 시간 계산
        int count = 0;

        //4방향 탐색위한 배열
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        //bfs 시작
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    //범위 밖이거나 rotten 오렌지거나, 비어있다면 for문 반복
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //x,y가 1인 신선한 오렌지이므로, rotten으로 바꿈.
                    grid[x][y] = 2;
                    //새로운 rotten 오렌지를 큐에 다시 넣음.
                    queue.offer(new int[]{x , y});
                    //신선한 오렌지 갯수 감소시킴.(마지막에 확인을 위함)
                    count_fresh--;
                }
            }
        }

        // 신선한 오렌지가 남아있으면 -1 return, 마지막에 모두 바뀐상태에서도 count를 더하고 반복문이 끝나기 때문에 count - 1 까지 해줌,.
        return count_fresh == 0 ? count-1 : -1;
    }
}
```

---

#### 542. 01 Matrix `java`

```java
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        
        return matrix;
    }
}
```
