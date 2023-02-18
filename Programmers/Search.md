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

#### 2. 모의고사 `java`

Score 배열로 정답이면 값을 1씩 올림.
```java
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] answerOne = {1,2,3,4,5};
        int[] answerTwo = {2,1,2,3,2,4,2,5};
        int[] answerThree = {3,3,1,1,2,2,4,4,5,5};
        int[] answerScore = {0,0,0};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == answerOne[i % 5]) answerScore[0]++;
            if(answers[i] == answerTwo[i % 8]) answerScore[1]++;
            if(answers[i] == answerThree[i % 10]) answerScore[2]++;
        }
        
        int max = Math.max(answerScore[0], Math.max(answerScore[1], answerScore[2]));
        
        List<Integer> answ = new ArrayList<>();
        for(int i=0; i<answerScore.length; i++) if(max == answerScore[i]) answ.add(i+1);
        
        int[] answer = new int[answ.size()];
        
        for(int i =0; i<answer.length; i++) {
        	answer[i] = answ.get(i);
        }
        
        return answer;
    }
}
```
