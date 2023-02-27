#### 1. 나머지가 1이 되는 수

풀이 : 
홀수는 2로 나누면 무조건 나머지가 1이다. 짝수는 n-1을 n의 제곱근보다 작은 값으로 나눠서 0이 나오는 값을 리턴해줌(이때 나누는 값이 짝수가 아니므로 3부터 시작해서 2씩더함).
만약 나누어 떨어지지 않으면 n-1을 반환해준다.

```java
class Solution {
    public int solution(int n) {
        if ((n - 1) % 2 == 0) return 2;
        
        int answer = 0;
        for(int i = 3; i <= Math.sqrt(n); i+=2) {
            if((n - 1) % i == 0) {
                return i;
            }
        }
        
        return answer = n - 1;
    }
}
```

---

