import java.util.Scanner;

public class Code1926 {
    static int[] dY = {1, 0, -1, 0};
    static int[] dX = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, count = 0, max = 0;
        int[][] paper, visited;

        N = sc.nextInt();
        M = sc.nextInt();
        paper = new int[N][M];
        visited = new int[N][M];

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] == 0 && paper[i][j] == 1){
                    int val = DFS(paper, visited, i, j, 0);
                    count++;
                    if(val > max){
                        max = val;
                    }
                }
            }
        }
        System.out.println(count + "\n" + max);

    }
    static int DFS(int[][] map, int[][] visited, int curY, int curX, int count){
        int nX, nY;
        visited[curY][curX] = 1;
        count++;

        for(int i = 0; i < 4; i++){
            nX = curX + dX[i];
            nY = curY + dY[i];
            if(nX > -1 && nX < map[0].length && nY > -1 && nY < map.length){
                if(visited[nY][nX] == 0 && map[nY][nX] == 1){
                    count = DFS(map, visited, nY, nX, count);
                }
            }
        }
        return count;
    }
}
