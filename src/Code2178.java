import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code2178 {
    static int[] dY = {1, 0, -1, 0};
    static int[] dX = {0, 1, 0, -1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, M;
        String s;
        int[][] map, visited;

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        BFS(map, visited, 0, 0, M-1, N-1);
        System.out.println(map[N-1][M-1]);
    }

    static void BFS(int[][] map, int[][] visited, int startX, int startY, int endX, int endY){
        Queue<Point> queue = new LinkedList<>();
        int nX, nY;
        Point cur;

        queue.offer(new Point(startX, startY));
        visited[startY][startX] = 1;

        while(!queue.isEmpty()){
            cur = queue.poll();

            if(cur.x == endX && cur.y == endY){
                return;
            }
            for(int i = 0; i < 4; i++){
                nX = cur.x + dX[i];
                nY = cur.y + dY[i];

                if(nX > -1 && nX < endX+1 && nY > -1 && nY < endY+1){
                    if(visited[nY][nX] == 0 && map[nY][nX] == 1){
                        queue.offer(new Point(nX, nY));
                        map[nY][nX] = map[cur.y][cur.x] + 1;
                        visited[nY][nX] = 1;
                    }
                }
            }
        }
    }

}
