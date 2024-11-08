class Solution {

    public static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        boolean[] isVisit = new boolean[words.length];

        dfs(begin, target, words, 0, isVisit);
        return answer;
    }

    public void dfs (String begin, String target, String[] words, int count, boolean[] isVisit) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (isVisit[i]) continue;

            int num = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    num++;
                }
            }

            if (num == begin.length() - 1) {
                isVisit[i] = true;
                dfs(words[i], target, words, count + 1, isVisit);
                isVisit[i] = false;
            }
        }
    }
}