import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int num = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());

            while (num <= now) {
                stack.push(num);
                num++;
                sb.append("+").append("\n");
            }

            if (now == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                sb.delete(0, sb.length()).append("NO");
                break;
            }
        }

        System.out.println(sb);
    }
}
