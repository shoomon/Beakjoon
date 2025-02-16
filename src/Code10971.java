import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Code10971 {
    static int N, answer;
    static int[][] map;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = Integer.MAX_VALUE;

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) DFS(0, 0, i, i, new boolean[N]);
        bw.write(answer+"");
        bw.close();
    }

    static void DFS(int depth, int cost,int start, int cur, boolean[] visited){
        if(depth == N){
            if(cur == start) answer = Math.min(answer, cost);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i] && map[cur][i] != 0){
                visited[i] = true;
                DFS(depth+1, cost+map[cur][i], start, i, visited);
                visited[i] = false;
            }
        }
    }
}
