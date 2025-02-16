import java.util.*;
import java.io.*;

class Node3{
    int r,c,k; //해당 점 좌표와 남은 점프 횟수
    public Node3(int r, int c, int k) {
        this.r = r;
        this.c = c;
        this.k = k;
    }
}

public class Code1600 {
    //탐색 횟수 W*H 각 점마다 12방 탐색 -> 4800
    static int[] horseX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] horseY = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {-1, 0, 1, 0};
    static int[][] map;
    static int[][][] dist;
    static int K, W, H;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        dist = new int[H][W][K+1];
        Queue<Node3> q = new ArrayDeque<>();

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dist 배열 초기화 -> H*W*K = 200*200*30

        q.offer(new Node3(0,0,K));


        while(!q.isEmpty()) {
            Node3 cur = q.poll();
//            System.out.println(cur.r+" "+cur.c+" "+dist[cur.r][cur.c].dist+" "+dist[cur.r][cur.c].k);
            if(cur.r == H-1 && cur.c == W-1) break;
            int nY,nX;
            //원숭이 움직임 4방 탐색
            for(int i = 0; i < 4; i++) {
                nY = cur.r+dY[i];
                nX = cur.c+dX[i];
                //해당 좌표에 같은 횟수의 말 움직임을 사용하여 도달하면 모두 같은 시행 횟수를 가진다.
                //즉, 말 움직임을 사용한 수를 결정하면 원숭이 움직임 사용 횟수가 정해진다.
                if(check(nY,nX) && map[nY][nX] == 0 && dist[nY][nX][cur.k] == 0) {
                    q.offer(new Node3(nY,nX,cur.k));
                    dist[nY][nX][cur.k] = dist[cur.r][cur.c][cur.k]+1;
                }
            }
            if(cur.k == 0) continue;
            //말 움직임 8방 탐색
            for(int i = 0; i < 8; i++) {
                nY = cur.r+horseY[i];
                nX = cur.c+horseX[i];
                //현재 점에서 말 움직임을 사용하여 도달한 적 있다면 continue
                if(check(nY,nX) && map[nY][nX] == 0 && dist[nY][nX][cur.k-1] == 0) {
                    q.offer(new Node3(nY,nX,cur.k-1));
                    dist[nY][nX][cur.k-1] = dist[cur.r][cur.c][cur.k]+1;
                }
            }
        }
//        debug();
        int answer = Integer.MAX_VALUE;
        if(H == 1 && W == 1){
            System.out.println(0);
        }else{
            for(int i = 0; i < K+1; i++){
                if(dist[H-1][W-1][i] == 0) continue;
                answer = Math.min(answer, dist[H-1][W-1][i]);
            }
            if(answer == Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(answer);
            }
        }
    }

    static boolean check(int i, int j) {
        if(-1 < i && i < H && -1 < j && j < W) return true;
        return false;
    }

    static void debug(){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                System.out.print("["+dist[i][j][K]+" ");
            }
            System.out.println();
        }
    }

}