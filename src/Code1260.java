import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code1260 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n, m, v, e1,e2;
        int[][] adj;
        int[] visited;

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        adj = new int[n+1][n+1];
        visited = new int[n+1];

        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < n+1; j++){
                adj[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++){
            e1 = sc.nextInt();
            e2 = sc.nextInt();
            adj[e1][e2] = 1;
            adj[e2][e1] = 1;
        }

        initList(visited);
        DFS(adj, visited, v);

        System.out.println("");

        initList(visited);
        BFS(adj, visited, queue, v);
    }

    static void initList(int[] list){
        for(int i = 0; i < list.length; i++){
            list[i] = 0;
        }
    }
    static void DFS(int[][] adjacent, int[] visited, int start){
        System.out.print(start + " ");
        visited[start] = 1;

        for(int i = 1; i < visited.length; i++){
            if(visited[i] == 0 && adjacent[start][i] == 1){
                DFS(adjacent, visited, i);
            }
        }
    }

    static void BFS(int[][] adjacent, int[] visited, Queue<Integer> queue, int start){
        int cur;

        queue.add(start);
        visited[start] = 1;

        while(!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur + " ");
            for(int i = 1; i < visited.length; i++) {
                if (visited[i] == 0 && adjacent[cur][i] == 1) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
    }

}
