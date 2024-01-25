import java.util.Scanner;

public class Code7576_notDone {

    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m, x = -1, y = -1;
        int[][] box, visited;

        n = sc.nextInt();
        m = sc.nextInt();
        box = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                box[i][j] = sc.nextInt();
                visited[i][j] = 0;
                if(box[i][j] == 1){
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(DFS(box, visited, x, y, 0));
    }

    static int DFS(int[][] adjacent, int[][] visited, int startX, int startY, int count){
        int nX, nY;

        if(startX == -1 || startY == -1){
            return -1;
        }
        visited[startX][startY] = 1;
        count++;

        for(int i = 0; i < 4; i++){
            nX = startX + dX[i];
            nY = startY + dY[i];

            if(nX < adjacent.length && nY < adjacent[0].length){
                if(adjacent[nX][nY] == 0){
                    return DFS(adjacent, visited, nX, nY, count);
                }else{
                    return count;
                }
            }
        }
        return -1;
    }
}
