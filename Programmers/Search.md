### Search

---

#### 1. 최소직사각형 `java`

다른 사람 풀이 : 향상된 for문 사용하면 더 깔끔한듯. 그리고 숫자의 대소 비교는 Math 클래스의 메소드 이용. (Math.max 처럼)
```java
class Solution {
    public int solution(int[][] sizes) {
        int wideMax = 0;
        int heightMax = 0;
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            } 
            
            if(sizes[i][0] > wideMax) {
                wideMax = sizes[i][0];
            }
            
            if(sizes[i][1] > heightMax) {
                heightMax = sizes[i][1];
            }
        }
        
        int answer = wideMax * heightMax;
        return answer;
    }
}
```

---

#### 2. 모의고사 `java`

Score 배열로 정답이면 값을 1씩 올림.
```java
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] answerOne = {1,2,3,4,5};
        int[] answerTwo = {2,1,2,3,2,4,2,5};
        int[] answerThree = {3,3,1,1,2,2,4,4,5,5};
        int[] answerScore = {0,0,0};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == answerOne[i % 5]) answerScore[0]++;
            if(answers[i] == answerTwo[i % 8]) answerScore[1]++;
            if(answers[i] == answerThree[i % 10]) answerScore[2]++;
        }
        
        int max = Math.max(answerScore[0], Math.max(answerScore[1], answerScore[2]));
        
        List<Integer> answ = new ArrayList<>();
        for(int i=0; i<answerScore.length; i++) if(max == answerScore[i]) answ.add(i+1);
        
        int[] answer = new int[answ.size()];
        
        for(int i =0; i<answer.length; i++) {
        	answer[i] = answ.get(i);
        }
        
        return answer;
    }
}
```

--- 

#### 3. 소수 찾기 `java`


```java
import java.util.HashSet;
class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }        
        return count;
    }

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
    int n = str.length();

    if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
    for (int i = 0; i < n; i++)
      permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }

}
```

---

#### 4. 피로도 `java`

dfs. 전역변수로 visit boolean 배열 생성. 방문하면 true로 바꿔준 후 탐색이 끝나고 다시 false로 바꿔줌. dfs 함수 시작 부분에 탐색 조건문을 적고 시작. 탐색 할때 마다 depth값을 늘려줌.
```java
class Solution {
    int count = 0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        
        visit = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }
    
    private void dfs(int depth, int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(visit[i] || dungeons[i][0] > k) {
                continue;
            }
            visit[i] = true;
            dfs(depth + 1, k - dungeons[i][1], dungeons);
            visit[i] = false;
        }
        count = Math.max(count, depth);
        
    }
}
```

---

#### 5.  전력망을 둘로 나누기

bfs. 
```java
import java.util.*;
class Solution {
    static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        map = new int[n+1][n+1];
        
        //이어진 곳을 1로
        for(int i = 0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        //이어진 곳 1을 0으로 바꾸며 순회.
        for(int i = 0;i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            map[a][b] = 0;
            map[b][a] = 0;
            
            answer = Math.min(answer, bfs(n, i+1));
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        return answer;
    }
    
    private int bfs(int n, int start){
        int cnt = 1;
        Queue<Integer>que = new LinkedList<>();
        boolean[] check = new boolean[n+1];
        que.add(start);
        check[start] = true;
        while(!que.isEmpty()){
            int now = que.poll();
            for(int i = 1; i<=n; i++){
                if(map[now][i]==1 && !check[i]){
                    que.add(i);
                    check[i] = true;
                    cnt++;
                }
            }
        }
        
        return (int)Math.abs(n-2*cnt);
    }
}
```

--- 

#### 6. 모음 사전

dfs로.
```java
import java.util.*;
class Solution {
    public String[] dict;
    public int cnt = 0, answer = 0;
    public int solution(String word) {
        dict = "AEIOU".split("");
        dfs("", word);
        
        return answer;
    }
    
    public void dfs(String cur, String word){
        if(cur.length() == 5 || cur.equals(word)){
            if(cur.equals(word)){
                answer = cnt;
            }
            return;
        }
        
        for(int i = 0; i < 5; i++){
            cnt++;
            dfs(cur+dict[i],word);
        }
    }
}
```
