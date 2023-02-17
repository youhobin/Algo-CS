### Search

---

#### 1. 최소직사각형 `java`

다른 사람 풀이 : 향상된 for문 사용하면 더 깔끔한듯. 그리고 숫자의 대소 비교는 Math 클래스의 메소드 이용. (Math.max 처럼)
```java
class Solution {
    public int solution(int[][] sizes) {
        int wideMax = 0;
        int heightMax = 0;
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            } 
            
            if(sizes[i][0] > wideMax) {
                wideMax = sizes[i][0];
            }
            
            if(sizes[i][1] > heightMax) {
                heightMax = sizes[i][1];
            }
        }
        
        int answer = wideMax * heightMax;
        return answer;
    }
}
```

---
