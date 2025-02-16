import java.util.*;
import java.io.*;
//24.11.17
//풀이 시간: 약 70분
//dp 어렵다
public class Code1446_2 {
    static class Node{
        int e,w;
        public Node(int e, int w){
            this.e = e;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, D;
        int[] dp;
        List<Node>[] adj;


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dp = new int[D+1];
        adj = new LinkedList[D+1];

        for(int i = 0; i < D+1; i++) adj[i] = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(e > D) continue;
            adj[s].add(new Node(e,w));
        }

        for(int i = 0; i < D+1; i++){
            dp[i] = i;
        }

        for(Node n : adj[0]){
            if(dp[n.e] > n.w) dp[n.e] = n.w;
        }

        for(int i = 1; i < D+1; i++){
            //지름길을 이용하지 않은 경우와 지름길을 이용한 경우 중 최단
            dp[i] = Math.min(dp[i-1]+1,dp[i]);
            //i점에서 갈 수 있는 지름길 반영
            for(Node n : adj[i]){
//                System.out.println(i+" "+n.e+" "+n.w);
                if(dp[n.e] > dp[i]+n.w) dp[n.e] = dp[i]+n.w;
            }
        }
        System.out.println(dp[D]);
    }
}
