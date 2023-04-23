소수 확인시 String을 int로 파싱하면 런타임에러가 발생하는 경우도 있음. 따라서 Long으로 파싱해서 소수인지 확인.

```java
class Solution {
    public static int answer = 0;
    public int solution(int n, int k) {
        if(n == 1) return 0;
        String changedNumber = Integer.toString(n, k);
        String[] nums = changedNumber.split("0");
        
        for (String s : nums) {
            if(s.equals("")) {
                continue;
            }
            Long num = Long.valueOf(s);
            if (isPrime(num)) {
                answer++;
            }
            
        }
        
        return answer;
    }
    
    public static boolean isPrime(Long num) {
        if(num == 1) {
            return false;
        } else if(num == 2) {
            return true;
        } else if(num % 2 == 0) {
            return false;
        }
    
        
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```
