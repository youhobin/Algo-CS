### Day 1

---

#### 짝수와 홀수 `java`

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

#### Pascal's Triangle

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
