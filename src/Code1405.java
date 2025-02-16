//25.01.05
//설계: 10분
//구현: 20분
//단순 경로 확률 -> DFS, 최대 depth 14
//전체 경우의 수 최대 = 4^14 = 약 10억 -> int
import java.io.*;
import java.util.*;

public class Code1405 {
    static double answer;
    static double[] prob;
    static int N;
    static int[] dY = {0,0,1,-1};
    static int[] dX = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer=0;
        prob = new double[4];
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 4; i++) prob[i] = Double.parseDouble(st.nextToken())*0.01;

        DFS(0, new boolean[29][29], 14, 14, 1);
        System.out.println(answer);
    }

    static void DFS(int depth, boolean[][] visited, int curY, int curX, double p){
//        System.out.println(depth+" "+p);
        if(visited[curY][curX]) return;
        if(depth == N){
            answer += p;
            return;
        }

        visited[curY][curX] = true;
        for(int i = 0; i < 4; i++){
            DFS(depth+1, visited, curY+dY[i], curX+dX[i], p*prob[i]);
        }
        visited[curY][curX] = false;
    }
}
