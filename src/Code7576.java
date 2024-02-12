import java.awt.*;
import java.io.*;
import java.util.*;

public class Code {
    static Queue<Point> queue = new LinkedList<>();
    static int M, N;
    static int[][] box;
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.offer(new Point(j,i));
                }
            }
        }

        BFS();
        System.out.println(minDay());
    }

    static void BFS(){
        int nX, nY;
        Point cur;

        while(!queue.isEmpty()){
            cur = queue.poll();
            for(int i = 0; i < 4; i++){
                nX = cur.x + dX[i];
                nY = cur.y + dY[i];
                if(-1 < nX && nX < M && -1 < nY && nY < N){
                    if(box[nY][nX] == 0){
                        queue.offer(new Point(nX, nY));
                        box[nY][nX] = box[cur.y][cur.x]+1;
                    }
                }
            }
        }
    }

    static int minDay(){
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] > max){
                    max = box[i][j];
                }
                if(box[i][j] == 0){
                    return -1;
                }
            }
        }
        return max-1;
    }
}
