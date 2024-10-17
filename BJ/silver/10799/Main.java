import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 막대기의 끝 부분이면 한 개만 추가하는 부분이 헷갈림
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();

                if (line.charAt(i - 1) == ')') {
                    answer++;
                } else {
                    answer += stack.size();
                }
            }
        }

        System.out.println(answer);
    }
}
