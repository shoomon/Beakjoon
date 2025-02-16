//25.02.15
//설계: 분발하자분
//구현: 분
//10:45 11:09 11:18
//모든 정점을 방문하는데 필요한 간선 수 -> 모든 정점을 방문만 하면 됨
//한 노드를 방문했을 때 해당 노드에서 방문할 수 있는 노드는 모두 방문한다. 약간 문제 해석이 그리디스러움.
import java.io.*;
import java.util.*;

public class Code9372 {
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N, M;
        List<Integer>[] adj = new List[1001];

        for(int i = 0; i < 1001; i++) adj[i] = new ArrayList<>();

        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = 0;

            for(int i = 0; i < 1001; i++) adj[i].clear();

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
            }

            BFS(1, adj, N);
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }

    static void BFS(int start, List<Integer>[] adj,int N){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i : adj[cur]){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                    answer++;
                }
            }
        }
    }
}
