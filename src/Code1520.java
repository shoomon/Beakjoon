import java.io.*;
import java.util.*;
public class Code1520 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int M, N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M  = Integer.parseInt(st.nextToken());
        N  = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        int[][] visited = new int[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,0, visited);
//        for(int[] i : dp){
//            System.out.println(Arrays.toString(i));
//        }
        System.out.println(dp[0][0]);

    }

    static int DFS(int curY, int curX, int[][] visited){
        if(curY == M-1 && curX == N-1) return 1;

        if(visited[curY][curX] != 0) return dp[curY][curX];
        visited[curY][curX] = 1;

        int nY, nX;
        for(int i = 0; i < 4; i++){
            nY = curY+dy[i];
            nX = curX+dx[i];

            if(-1 < nY && nY < M && -1 < nX && nX < N){
                if(map[nY][nX] < map[curY][curX]){
                    dp[curY][curX] += DFS(nY,nX, visited);
                }
            }
        }
        return dp[curY][curX];
    }
}
