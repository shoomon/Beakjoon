import java.io.*;
import java.util.*;

public class Code7569 {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    static int[] dZ = {-1, 0, 1};
    static int M, N, H;
    static int[][][] tomato, visited;
    static Queue<tomatoP> queue = new LinkedList<>();

    static class tomatoP{
        int x, y, z;
        tomatoP(int z, int y, int x){
           this.x = x;
           this.y = y;
           this.z = z;
        }
    }
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        try{
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            tomato = new int[H][N][M];
            visited = new int[H][N][M];

            for(int i = 0; i < H; i++){
                for(int j = 0; j < N; j++){
                    st = new StringTokenizer(br.readLine());
                    for(int k = 0; k < M; k++){
                        tomato[i][j][k] = Integer.parseInt(st.nextToken());
                        if(tomato[i][j][k] == 1){
                            queue.offer(new tomatoP(i, j, k));
                        }
                    }
                }
            }

            BFS();
            bw.write(findMax()+"");

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }

    static void BFS(){
        tomatoP cur = new tomatoP(0,0,0);
        int nX, nY, nZ;
        while(!queue.isEmpty()){
            cur = queue.poll();
            for(int i = 0; i < 4; i++){
                nX = cur.x + dX[i];
                nY = cur.y + dY[i];
                if(-1 < nX && nX < M && -1 < nY && nY < N){
                    if(tomato[cur.z][nY][nX] == 0){
                        queue.offer(new tomatoP(cur.z, nY, nX));
                        tomato[cur.z][nY][nX] = tomato[cur.z][cur.y][cur.x] + 1;
                    }
                }
            }
            for(int i = 0; i < 3; i++){
                nZ = cur.z + dZ[i];
                if(-1 < nZ && nZ < H){
                    if(tomato[nZ][cur.y][cur.x] == 0){
                        queue.offer(new tomatoP(nZ,cur.y,cur.x));
                        tomato[nZ][cur.y][cur.x] = tomato[cur.z][cur.y][cur.x] + 1;
                    }
                }
            }
        }
    }

    static int findMax(){
        int max=0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(tomato[i][j][k] > max){
                        max = tomato[i][j][k];
                    }
                    if(tomato[i][j][k] == 0){
                        return -1;
                    }
                }
            }
        }
        return max-1;
    }

}
