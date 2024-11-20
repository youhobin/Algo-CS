import java.util.*;
class Main {
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