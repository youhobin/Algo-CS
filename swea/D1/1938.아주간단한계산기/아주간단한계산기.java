import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 아주간단한계산기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        sb.append(i + j).append("\n");
        sb.append(i - j).append("\n");
        sb.append(i * j).append("\n");
        sb.append(i / j);
        System.out.println(sb);
    }
}
