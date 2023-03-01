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

---

#### 3. 성격 유형 검사하기 

풀이 : map에 put 을 할 때 키값이 같으면 덮어쓰기를 함  -> getOrDefault로 value를 바꿔줌. 
반복문 이후에 if문을 하나씩 하기 보다 char [][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}} 배열을 이용해서 이 배열의 key를 이용해 value 를 비교하는 방법이 좋은듯.
```java
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> result = new HashMap<>();
        
        for(int i = 0; i < choices.length; i++) {
            if(choices[i] - 4 > 0) {
                result.put(survey[i].charAt(1), result.getOrDefault(survey[i].charAt(1), 0) + choices[i] - 4);
            } else if (choices[i] - 4 < 0) {
                result.put(survey[i].charAt(0), result.getOrDefault(survey[i].charAt(0), 0) + 4 - choices[i]);
            }
        }
        
        if(result.getOrDefault('T', 0) > result.getOrDefault('R', 0)) {
            answer += "T";
        } else {
            answer += "R";
        }
        
        if(result.getOrDefault('F', 0) > result.getOrDefault('C', 0)) {
            answer += "F";
        } else {
            answer += "C";
        }
        
        if(result.getOrDefault('M', 0) > result.getOrDefault('J', 0)) {
            answer += "M";
        } else {
            answer += "J";
        }
        
        if(result.getOrDefault('N', 0) > result.getOrDefault('A', 0)) {
            answer += "N";
        } else {
            answer += "A";
        }
        
        return answer;
    }
}
```

---

#### 4. 신규아이디 추천

풀이 : 정규표현식이 어려움. 주석에 있는 부분부터 공부하기. string 비교시 equals 사용 ( == 비교시 런타임에러 발생. -> 공부해보기)
```java
class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        
        // -_.소문자 숫자 가 아닌거를 "" 로 바꾸기. 
        answer = answer.replaceAll("[^-_.a-z0-9]","");
        
        //[.]의 갯수가 {2이상 , 이하}를 "."로 바꾸기.
        answer = answer.replaceAll("[.]{2,}", ".");
        
        //.으로 시작 또는 .으로 끝나는 거 ""로 바꾸기
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        if(answer.equals("")) answer += "a";
        
        if(answer.length() > 15) {
            answer = answer.substring(0,15);
            answer = answer.replaceAll("[.]$", "");
        }
        
        if(answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }
        
        return answer;
    }
}
```