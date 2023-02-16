### Problem 01~10

---

#### 1. 짝수와 홀수 `java`

```java
class Solution {
    public String solution(int num) {
        if(num % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
        
    }
}
```

---

#### 2. Pascal's Triangle

```java
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <=0){
            return triangle;
        }
        for (int i=0; i<numRows; i++){
            List<Integer> row =  new ArrayList<Integer>();
            for (int j=0; j<i+1; j++){
                if (j==0 || j==i){
                    row.add(1);
                } else {
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
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

---

#### 4. JadenCase 문자열 만들기

```java
class Solution {
    public String solution(String s) {
        
        StringBuffer sb = new StringBuffer();
        
        s = s.toLowerCase();
        sb.append(Character.toUpperCase(s.charAt(0)));
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ' ') {
                sb.append(" ");
            }
            else if(s.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
```

---

#### 5. 최솟값 만들기

두 배열에서 각각 숫자를 한 개씩 꺼내 곱한 수의 합의 최솟값 구하기
```java 
import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }

        return answer;
    }
}
```

---

#### 6. 올바른 괄호

괄호가 ()의 갯수가 맞으면 true, 아니면 false. ( 단 ')'로 시작하면 false).
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

---

#### 7. 피보나치 수 

피보나치 수를 1234567으로 나눈 나머지를 리턴하기.
dp를 이용해서 계속 재귀하지 않고, 값을 저장해뒀다가 사용.
 - n이 커지면 오버플로우가 발생하므로 최종 return 값 뿐만아니라, 이전 결과를 계산하는 return 값에도 1234567로 나눠서 오버플로우를 방지한다.
```java
class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        return fibo(dp, n) % 1234567;
    }
    
    public int fibo(int[] dp, int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = fibo(dp, n-1) % 1234567 + fibo(dp, n-2) % 1234567;
    }
}
```

#### 8. 다음 큰 숫자

2진수로 변환했을 때 1의 갯수가 같은 다음 큰 숫자. bitCount는 정수를 2진법으로 변환 후 1의 갯수를 반환해준다.
```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        int n_cnt = Integer.bitCount(n);
        int b_cnt = 0;
        
        while(true){
            n++;
            b_cnt = Integer.bitCount(n);
            if(n_cnt == b_cnt){
                answer = n;
                break;
            }            
        }
                
        return answer;
    }
}
```
