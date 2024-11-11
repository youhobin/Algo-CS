class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!isVisit[i]) {
                dfs(i, computers, isVisit);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int i, int[][] computers, boolean[] isVisit) {
        isVisit[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i == j) continue;
            if (computers[i][j] == 0) continue;
            if (isVisit[j]) continue;
            dfs(j, computers, isVisit);
        }
    }
}