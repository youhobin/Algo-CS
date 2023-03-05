#### 1. 전화번호 목록

```java
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
    
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0,j))) {
                    return false;       
                }
            }
        }
        
        return true;
    }
}
```

---

#### 2. 위장

```java
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        for(String key : map.keySet()) {
            answer *= map.get(key);
        }
        return answer - 1;
    }
}
```
