//25.02.24
//설계: 1분
//구현: 80분?
//08:26 9:07 12:24 01:06
//BFS 2개
import java.util.*;
import java.io.*;

public class Code3055 {
    static int[] dY = {-1,0,1,0};
    static int[] dX = {0,1,0,-1};
    static int[] start, end;

    static int R, C;
    static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        start = new int[2];
        end = new int[2];

        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }else if(map[i][j] == 'D'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }


        BFS(start[0], start[1]);

        System.out.println("KAKTUS");
    }

    static void BFS(int dR,int dC) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        int time=0;

        q.offer(new int[] {dR,dC,0});
        visited[dR][dC] = true;
        water();

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[2] != time){
                time = cur[2];
                water();
            }

//            System.out.println(cur[0]+" "+cur[1]+" "+cur[2]+"===========");
//            printMap();

            for(int i = 0; i < 4; i++){
                int nY = cur[0]+dY[i];
                int nX = cur[1]+dX[i];

                if(check(nY, nX) && !visited[nY][nX] && map[nY][nX] != 'X' && map[nY][nX] != '*'){
                    if(map[nY][nX] == 'D'){
                        System.out.println(cur[2]+1);
                        System.exit(0);
                    }
                    q.offer(new int[] {nY, nX, cur[2]+1});
                    visited[nY][nX] = true;
                }
            }
        }
    }

    static void water(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        List<int[]> list = new ArrayList<>();

        q.offer(new int[] {end[0], end[1]});
        visited[end[0]][end[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nY = cur[0]+dY[i];
                int nX = cur[1]+dX[i];

                if(check(nY,nX) && !visited[nY][nX] && map[nY][nX] != 'X' && map[nY][nX] != 'D'){
                    if(map[nY][nX] == '*' && map[cur[0]][cur[1]] != 'D'){
                        list.add(new int[] {cur[0], cur[1]});
                    }else{
                        q.offer(new int[] {nY,nX});
                        visited[nY][nX] = true;
                    }
                }
            }
        }

        for(int[] i : list){
            map[i[0]][i[1]] = '*';
        }
    }

    static boolean check(int r, int c){
        if(-1 < r && r < R && -1 < c && c < C)return true;
        return false;
    }

    static void printMap(){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
