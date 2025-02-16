//25.01.21
//설계: 10분
//구현: 50분
//시간초과
//idea2: linkedlist 구현? -> BFS탐색 방법?
import java.util.*;
import java.io.*;
public class Code11559 {
    static char[][] map;
    static int[] dY = {-1, 0, 1, 0};
    static int[] dX = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        int count = -1;

        for(int i = 0; i < 12; i++){
            map[i] = br.readLine().toCharArray();
        }

        boolean flag = true;
        while(flag){
            count++;
            flag = false;
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(map[i][j] != '.' && map[i][j] != 'x') {
                        if(BFS(map[i][j],i,j) > 3) flag = true;
                    }
                }
            }
//            System.out.println("=============");
//            for(int i = 0; i < 12; i++){
//                for(int j = 0; j < 6; j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
            blockDown();
        }
        System.out.println(count);
    }

    static int BFS(char color, int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        ArrayList<int[]> points = new ArrayList<>();
        boolean[][] visited = new boolean[12][6];

        q.offer(new int[] {i,j});
        points.add(new int[] {i,j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int k = 0; k < 4; k++){
                int nY = cur[0]+dY[k];
                int nX = cur[1]+dX[k];
                if(-1 < nY && nY < 12 && -1 < nX && nX < 6 && map[nY][nX] == color && !visited[nY][nX]){
                    q.offer(new int[] {nY,nX});
                    points.add(new int[] {nY,nX});
                    visited[nY][nX] = true;
                }
            }
        }
        if(points.size() > 3){
            for(int[] p : points) map[p[0]][p[1]] = 'x';
            return points.size();
        }
        return 0;
    }

    static void blockDown(){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 12; j++){
                if(map[j][i] != 'x') stack.push(map[j][i]);
            }
            for(int j = 0; j < 12-stack.size(); j++){
                map[j][i] = '.';
            }
            int size = stack.size();
            for(int j = 11; j >= 12-size; j--){
                map[j][i] = stack.pop();
            }
        }
    }
}
