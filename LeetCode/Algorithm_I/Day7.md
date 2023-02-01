### Day 7

---

#### 733. Flood Fill `java`

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        
        //color 는 바꿔야할 color, image[sr][sc] 는 기존 컬러
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    // cur 이 기존 시작 지점의 컬러
    public void fill(int[][] image, int sr, int sc, int color, int cur) {
        
        // 범위를 넘어갈때 return.
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;

        //시작 지점 cur와 지금 위치의 color가 같지 않을때, 즉 1 과 0 처럼.
        if(cur != image[sr][sc]) return;

        //cur과 지금 위치가 같다면 color=2 로 바꿈.
        image[sr][sc] = color;

        //4방향으로 반복
        fill(image, sr-1, sc, color, cur);
        fill(image, sr+1, sc, color, cur);
        fill(image, sr, sc-1, color, cur);
        fill(image, sr, sc+1, color, cur);
    }
}
```

---

#### 695. Max Area of Island `java`

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
            }
        }
        return max_area;    
    }

    public int AreaOfIsland(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){

            // 주변 탐색시 무한 루프로 돌지 않도록
            grid[i][j] = 0;

            //이어진 area의 1인 값들을 더해서 area 의 넓이 값 리턴.
            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
        }
        return 0;
    }
}
```
