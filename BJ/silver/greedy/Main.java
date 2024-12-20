import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = people.length;
        Arrays.sort(people);

        int left = 0;
        for(int i = people.length - 1; i > left; i--) {
            if(people[i] + people[left] <= limit) {
                left++;
            }

        }
        return answer - left;
    }
}