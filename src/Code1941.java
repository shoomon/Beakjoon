//25.01.23
//설계: 5분 문제 이해 잘못해서 30분 버림
//구현: 20분
//완탐 -> 25C7 = 480700 + BFS 체크
//S가 4개 이상이면 안되는줄 알았는데 Y가 4개 이상이면 안되는 거였네
import java.util.*;

public class Code1941 {
    static int[] dY = {-1,0,1,0};
    static int[] dX = {0,1,0,-1};
    static char[][] map;
    static int answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        map = new char[5][5];
        answer=0;

        for(int i = 0; i < 5; i++){
            map[i] = sc.nextLine().toCharArray();
        }

        combination(0,0,0,new boolean[5][5]);

        System.out.println(answer);
    }

    static void combination(int depth, int yCount, int idx, boolean[][] isSelected){
        if(yCount > 3) return;
        if(depth == 7){
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[5][5];
            int count = 1;

            q.offer(new int[] {(idx-1)/5, (idx-1)%5});
            visited[(idx-1)/5][(idx-1)%5] = true;

            while(!q.isEmpty()){
                int[] cur = q.poll();
                for(int i = 0; i < 4; i++){
                    int nY = cur[0]+dY[i];
                    int nX = cur[1]+dX[i];

                    if(-1 < nY && nY < 5 && -1 < nX && nX < 5 && isSelected[nY][nX] && !visited[nY][nX]){
                        q.offer(new int[] {nY,nX});
                        visited[nY][nX] = true;
                        count++;
                    }
                }
            }
//            System.out.println(count+"==============="+(idx-1));
//            for(int i = 0; i < 5; i++){
//                for(int j = 0; j < 5; j++){
//                    System.out.print(isSelected[i][j]+" ");
//                }
//                System.out.println();
//            }
            if(count == 7) answer++;
            return;
        }

        for(int i = idx; i < 25; i++){
            int r = i/5;
            int c = i%5;

            isSelected[r][c] = true;
            if(map[r][c] == 'Y'){
                combination(depth+1, yCount+1, i+1, isSelected);
            }else{
                combination(depth+1, yCount, i+1, isSelected);
            }
            isSelected[r][c] = false;
        }
    }
}
