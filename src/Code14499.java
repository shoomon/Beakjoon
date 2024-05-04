import java.awt.*;
import java.io.*;
import java.util.*;

public class Code14499 {
    static int N, M, K;
    static Point curPos = new Point();
    static int[][] map, dice = {{-1, 0, -1}, {0, 0, 0}, {-1, 0, -1}, {-1, 0, -1}};
    static int[] command;
    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        curPos.y = Integer.parseInt(st.nextToken());
        curPos.x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        command = new int[K];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < K; i++){
            command[i] = Integer.parseInt(st.nextToken());
        }

        simulation();
    }

    static void simulation(){

        for(int i : command){
//            System.out.println("cur "+i + " curPos " + curPos.y + " "+curPos.x);
            move(i);
        }
    }

    static void move(int dir){
        int nX = curPos.x+dX[dir-1], nY = curPos.y+dY[dir-1];

        if(nY < 0 || nY > N-1 || nX < 0 || nX > M-1) return;

        switch(dir){
            case 1:{ //동
                int temp = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = temp;
                break;
            }
            case 2:{ // 서
                int temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
                break;
            }
            case 3:{ // 북
                int temp = dice[0][1];
                for(int i = 0; i < 3; i++){
                    dice[i][1] = dice[i+1][1];
                }
                dice[3][1] = temp;
                break;
            }
            case 4:{ // 남
                int temp = dice[3][1];
                for(int i = 3; i > 0; i--){
                    dice[i][1] = dice[i-1][1];
                }
                dice[0][1] = temp;
                break;
            }
        }
        curPos.x += dX[dir-1];
        curPos.y += dY[dir-1];
        copy(curPos.x, curPos.y);
        System.out.println(dice[1][1]);
//        for(int i = 0; i < 4; i++){
//            for(int j = 0; j < 3; j++){
//                System.out.print(dice[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("============");
    }

    static void copy(int nX, int nY){
        if(map[nY][nX] == 0){
            map[nY][nX] = dice[3][1];
        }else{
            dice[3][1] = map[nY][nX];
            map[nY][nX] = 0;
        }
    }
}
