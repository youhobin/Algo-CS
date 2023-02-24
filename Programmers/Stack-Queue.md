#### 1. 같은 숫자는 싫어

```java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        int num = -1; //원소가 0~9까지 이므로 영향 안받는 아무 숫자.
        for(int i=0; i<arr.length; i++){
             if(arr[i] != num){
                 arrList.add(arr[i]);
                 num = arr[i];
             }
        }
        
        answer = new int[arrList.size()]; //answer 리스트 크기 선언.
        for(int i=0; i<answer.length; i++){
            answer[i] = arrList.get(i); 
        }
        
        return answer;
    }
}
```

#### 2. 올바른 괄호 

```java
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? true : false;
        
    }
}
```

#### 3. 프린터 

우선순위 큐 
```java
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }
}
```
