import java.util.Scanner;

public class Code4963 {
    static int[] dX = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dY = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int W = -1, H = -1, count;
        int[][] map, visited;

        while(W != 0 && H != 0){
            W = sc.nextInt();
            H = sc.nextInt();
            if(W == 0 && H == 0) break;
            count = 0;
            map = new int[H][W];
            visited = new int[H][W];

            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    if(visited[i][j] == 0 && map[i][j] == 1){
                        DFS(map, visited, j, i);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void DFS(int[][] map, int[][] visited, int curX, int curY){
        int nX, nY;

        visited[curY][curX] = 1;

        for(int i = 0; i < 8; i++){
            nX = curX + dX[i];
            nY = curY + dY[i];

            if(nX > -1 && nX < map[0].length && nY > -1 && nY < map.length){
                if(visited[nY][nX] == 0 && map[nY][nX] == 1){
                    DFS(map, visited, nX, nY);
                }
            }
        }
    }
}
