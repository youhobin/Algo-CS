#### 1. 가장 큰 수

풀이 : string 배열을 내림차순으로 정리. (a,b) -> (b + a).compareTo(a + b).
string에 더하지 않고 stringBuilder로 성능 올리기. 혹은 버퍼.

```java
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] numString = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            numString[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numString, (a,b) -> (b + a).compareTo(a + b));
        
        if(numString[0].equals("0")) return "0";
        
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < numString.length; i++) {
            answer.append(numString[i]);
        }
        
        return answer.toString();
    }
}
```

---

#### 2. 타겟 넘버

```java
class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length) {
            if(target == sum) answer++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }
}
```

---

#### 3. 최댓값과 최솟값

```java
class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        return min + " " + max;
    }
}
```
