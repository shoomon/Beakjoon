import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code7562 {
    static int[] dY = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dX = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T, L;
        Point cur = new Point(), dest = new Point();

        T = sc.nextInt();

        for(int l = 0; l < T; l++){
            L = sc.nextInt();
            cur.y = sc.nextInt();
            cur.x = sc.nextInt();
            dest.y = sc.nextInt();
            dest.x = sc.nextInt();

//            System.out.println("test" + l + " -------------------");
//            BFS(L, cur, dest);
            System.out.println(BFS(L, cur, dest));
        }
        sc.close();
    }

    static int BFS(int L, Point start, Point end){
        Point cur = new Point(), next = new Point();
        int[][] map = new int[L][L];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(start);

        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur.x == end.x && cur.y == end.y){
                return map[end.y][end.x];
            }

            for(int i = 0; i < 8; i++){
                next.x = cur.x + dX[i];
                next.y = cur.y + dY[i];

                if(next.x > -1 && next.x < L && next.y > -1 && next.y < L && !next.equals(start) && map[next.y][next.x] == 0){
                    queue.offer(new Point(next));
                    map[next.y][next.x] = map[cur.y][cur.x] + 1;
                }
            }

//            System.out.println("current Y: " + cur.y + "current X: " + cur.x);
//            for(int i = 0; i < L; i++){
//                for(int j = 0; j < L; j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println("");
//            }

        }
        return -1;
    }
}
