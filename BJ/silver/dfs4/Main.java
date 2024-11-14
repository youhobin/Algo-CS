class Solution {
    // dfs를 이용해서 더하거나 빼는 두가지의 경우를 수행
    // 첫번째가 마이너스이려면, numbers[0]을빼면됨.
    public static int answer;
    public int solution(int[] numbers, int target) {

        dfs(0, 0, target, numbers);
        return answer;
    }

    public static void dfs(int depth, int sum, int target, int[] numbers) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
                return;
            }
            return;
        }

        dfs(depth + 1, sum + numbers[depth], target, numbers);
        dfs(depth + 1, sum - numbers[depth], target, numbers);
    }
}