### Day 4

---

#### 344. Reverse String `java`

```java
class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
```

---

#### 557. Reverse Words in a String III

```java
class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for(int i = 0; i < ca.length; i++) {
            if(ca[i] != ' ') {
                int j = i;
                while(j + 1 < ca.length && ca[j + 1] !=' ') { // 단어의 끝을 j로
                    j++;
                }
                reverse(ca, i, j);
                // 다음 단어를 찾기위해 인덱스 이동
                i = j;
            }
        }
        //char 배열을 String으로
        return new String(ca);
    }

    public void reverse(char[] ca, int i, int j) {
        while(i < j) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
            i++;
            j--;
        }
    }
}
```
