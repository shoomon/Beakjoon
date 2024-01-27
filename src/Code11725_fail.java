import java.awt.*;
import java.util.Scanner;

public class Code11725_fail {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        int[][] adj;
        int[] visited;
        Point p = new Point();

        N = sc.nextInt();
        adj = new int[N][N];

        for(int i = 0; i < N-1; i++){
            p.x = sc.nextInt();
            p.y = sc.nextInt();
            adj[p.x-1][p.y-1] = 1;
            adj[p.y-1][p.x-1] = 1;
        }

        for(int i = 1; i < N; i++){
            visited = new int[N];
            System.out.println(DFS(adj, visited, 0, i));
        }
    }

    static int DFS(int[][] adj, int[] visited, int cur, int target) {
        visited[cur] = 1;
        if (adj[cur][target] == 1) {
            return cur + 1;
        }

        int result = -1;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0 && adj[cur][i] == 1) {
                result = DFS(adj, visited, i, target);
                if (result != -1) {
                    break;
                }
            }
        }
        return result;
    }
}
