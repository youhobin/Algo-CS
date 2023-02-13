### Day 1

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

### 4. JadenCase 문자열 만들기

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
