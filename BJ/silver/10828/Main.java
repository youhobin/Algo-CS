import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            determineCommand(command, stack, st, sb);
        }

        System.out.println(sb);
    }

    private static void determineCommand(String command, Stack<Integer> stack, StringTokenizer st, StringBuilder sb) {
        if (command.equals("push")) {
            stack.push(Integer.valueOf(st.nextToken()));
        } else if (command.equals("pop")) {
            if (stack.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(stack.pop()).append("\n");
            }
        } else if (command.equals("size")) {
            sb.append(stack.size()).append("\n");
        } else if (command.equals("empty")) {
            if (stack.isEmpty()) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        } else {
            if (stack.isEmpty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(stack.peek()).append("\n");
            }
        }
    }
}
