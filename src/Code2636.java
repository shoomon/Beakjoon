//25.01.30
//설계: 13분
//구현: 36분
//3:10 3:24 3:58
//판 넓이: 100*100 = 10000, 최대 수행 횟수: 10000*100 = 100만
//동시에 녹아야 한다 -> BFS
//구멍인지 여부 판단? 가장자리 빈공간들부터 BFS 탐색
//녹기 직전 상태? 직전 상태를 리스트에 저장 or map에 마킹
//while문 돌리는 이유 -> 순서대로 인접한 치즈들만 녹이면 구멍이 노출되었을 경우 노출된 치즈들을 녹이지 못함.
import java.util.*;
import java.io.*;

public class Code2636 {
    static int[] dY = {-1,0,1,0};
    static int[] dX = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, M, time = 0, cnt = 0;
        int[][] map;
        List<int[]> toMelt = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        while(true){
            toMelt.clear();
            q.clear();
            for(int i = 0; i < N; i++) Arrays.fill(visited[i], false);

            q.offer(new int[] {0,0});
            q.offer(new int[] {0,M-1});
            q.offer(new int[] {N-1,0});
            q.offer(new int[] {N-1, M-1});
            visited[0][0] = true;
            visited[0][M-1] = true;
            visited[N-1][0] = true;
            visited[N-1][M-1] = true;

            while(!q.isEmpty()){
                int[] cur = q.poll();

                for(int i = 0; i < 4; i++){
                    int nY = cur[0]+dY[i];
                    int nX = cur[1]+dX[i];

                    if(-1 < nY && nY < N && -1 < nX && nX < M && !visited[nY][nX]){
                        if(map[nY][nX] != 1){
                            q.offer(new int[] {nY,nX});
                            visited[nY][nX] = true;
                        }else if(map[nY][nX] == 1){
                            toMelt.add(new int[] {nY,nX});
                            visited[nY][nX] = true;
                        }
                    }
                }
            }

            if(!toMelt.isEmpty()){
                time++;
                for(int[] i : toMelt){
                    map[i[0]][i[1]] = -time;
                }
            }else{ //녹을 치즈가 없으면 break
                break;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == -time) cnt++;
//                System.out.print(map[i][j]+" ");
            }
//            System.out.println();
        }

        System.out.println(time+"\n"+cnt);

    }
}
