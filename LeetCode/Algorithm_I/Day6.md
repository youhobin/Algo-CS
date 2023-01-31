### Day 6

---

#### 3. Longest Substring Without Repeating Characters `java`

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> result = new HashMap();

        int left = 0;
        int right = 0;

        int output = 0;
        while(right < s.length()) {
            char r = s.charAt(right);
            result.put(r, result.getOrDefault(r,0) + 1);

            while(result.get(r) > 1) {
                char l = s.charAt(left);
                result.put(l, result.get(l) - 1);
                left++;
            }

            output = Math.max(output, right - left + 1);

            right++;
        }
        return output;
    }
}
```

---

#### 567. Permutation in String

```java
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length(), length2 = s2.length();
        if (length1 > length2) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < length1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;
        
        for (int i = length1; i < length2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - length1) - 'a']++;
            if (allZero(count)) return true;
        }
        
        return false;
    }
    
    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
```
