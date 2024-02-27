import java.io.*;
import java.util.*;

public class Code1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, D, start, end, dist;
        int[][] adj;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        adj = new int[D+1][D+1];

        for(int i = 0; i <= D; i++){
            Arrays.fill(adj[i], -1);
        }
        for(int i = 0; i <= D; i++){
            for(int j = i; j <= D; j++){
                adj[i][j] = j-i;
            }
        }


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());

            if(end <= D){
                adj[start][end] = Math.min(adj[start][end], dist);
            }
        }

        for(int k = 1; k < D; k++){
            for(int i = 0; i <= k; i++){
                for(int j = i; j <= D; j++){
                    if(adj[i][j] != -1 && adj[i][k] != -1 && adj[k][j] != -1) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                }
            }
        }

        bw.write(adj[0][D]+"");

        br.close();
        bw.close();
    }
}
