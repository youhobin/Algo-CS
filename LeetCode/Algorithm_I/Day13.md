### Day 13

---

#### 231. Power of Two `java`

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
```

---

#### 191. Number of 1 Bits `java`

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count += n & 1;
            n = n >>> 1;
        }

        return count;
    }
}
```

---
