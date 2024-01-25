import java.util.Scanner;

public class Code2606 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numNode, numEdge, v1, v2;
        int[][] adj;
        int[] visited;

        numNode = sc.nextInt();
        numEdge = sc.nextInt();
        adj = new int[numNode][numNode];
        visited = new int[numNode];

        for(int i = 0; i < numEdge; i++){
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            adj[v1-1][v2-1] = 1;
            adj[v2-1][v1-1] = 1;
        }

        System.out.println(DFS(adj, visited, 0, 0) - 1);

    }

    static int DFS(int[][] adjacent, int visited[], int cur, int count){
        visited[cur] = 1;
        count++;

        for(int i = 0; i < visited.length; i++){
            if(visited[i] == 0 && adjacent[cur][i] == 1){
                count = DFS(adjacent, visited, i, count);
            }
        }
        return count;
    }
}
