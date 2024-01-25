import java.io.*;
import java.util.StringTokenizer;

public class Code11724 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, M, v1, v2, count = 0;
        int[][] adjacent;
        int[] visited;
        StringTokenizer st;

        try{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            adjacent = new int[N+1][N+1];
            visited = new int[N+1];

            for(int i = 0; i < N+1; i++){
                for(int j = 0; j < N+1; j++){
                    adjacent[i][j] = 0;
                }
                visited[i] = 0;
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                adjacent[v1][v2] = 1;
                adjacent[v2][v1] = 1;
            }

            for(int i = 1; i < N+1; i++){
                for(int j = 0; j < N+1; j++){
                    if(visited[i] == 0){
                        DFS(adjacent, i, visited);
                        count++;
                    }
                }
            }

            bw.write(count+"");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                br.close();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static void DFS(int[][] adjacent, int start, int[] visited){
        visited[start] = 1;

        for(int i = 1; i < visited.length; i++){
            if(adjacent[start][i] == 1 && visited[i] == 0){
                DFS(adjacent, i, visited);
            }
        }
    }
}
