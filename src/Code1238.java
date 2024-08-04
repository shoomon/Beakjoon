import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, M, X, T, str, end, answer=0;
        int[][] adj;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adj = new int[N+1][N+1];

        for(int i = 0; i < N+1; i++){
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }


        for(int i = 0; i < M; i ++){
            st = new StringTokenizer(br.readLine());
            str = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            adj[str][end] = T;
        }

        for(int k = 1; k < N+1; k++){
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    if(adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE) continue;
                    if(i == j) {
                        adj[i][j] = 0;
                    }else{
                        adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                    }
                }
            }
        }

//        for(int i = 0; i < N+1; i++){
//            for(int j = 0; j < N+1; j++){
//                System.out.print(adj[i][j] +" ");
//            }
//            System.out.println();
//        }

        for(int i = 1; i < N+1; i++){
            if(adj[i][X] == Integer.MAX_VALUE) continue;
            answer = Math.max(answer, adj[i][X]+adj[X][i]);
        }

        System.out.println(answer);
    }
}
