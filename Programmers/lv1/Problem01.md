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

#### 2. 신고 결과 받기

풀이 : Map 에서 putIfAbsent 는 존재하지 않으면 추가하고, 존재하면 추가하지 않음. getOrDefault 는 존재하면 get 아니면 default 값 가져오기.
다른 사람 풀이 : 처음에 report 배열에서 반복되는 것은 stream의 distinct로 제거하는거도 괜찮은듯.

```java
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, HashSet<String>> reportSet = new HashMap<>();
        Map<String, Integer> reportedNumber = new HashMap<>();
        HashSet<String> reportMsg = new HashSet<>(Arrays.asList(report));
        
        for(String userId : reportMsg) {
            String[] reportList = userId.split(" ");
            String reporting = reportList[0];
            String reported = reportList[1];
            reportSet.putIfAbsent(reporting, new HashSet<String>(){{add(reported);}});
            reportSet.get(reporting).add(reported);
            reportedNumber.put(reported, reportedNumber.getOrDefault(reported, 0) + 1);
        }
        
        for (String reported : reportedNumber.keySet()){
            int reportedCount = reportedNumber.get(reported);
            if(reportedCount >= k){
            
                for(int i=0; i<id_list.length; i++){
                    if(reportSet.containsKey(id_list[i]) && reportSet.get(id_list[i]).contains(reported)) {
                        answer[i]++;
                    }
                }
            }
        }
           
        return answer;
    }
        
}
```
