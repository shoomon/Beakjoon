//25.01.27
//설계: 분
//구현: 분
//이분그래프 따로 공부 필요
//탐색 시간복잡도 = 20만*5 = 100만
import java.io.*;
import java.util.*;

public class Code1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K;

        K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            int V, E;
            List<Integer>[] adj;
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adj = new LinkedList[V + 1];

            for (int i = 0; i < V + 1; i++) adj[i] = new LinkedList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
            }

            int[] color = new int[V + 1];
            boolean flag = true;

            for(int i = 1; i < V+1; i++){
                if(color[i] == 0){
                    if(!BFS(color,adj,i)) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
        static boolean BFS(int[] color, List<Integer>[] adj, int root) {
            Queue<Integer> q = new ArrayDeque<>();

            q.offer(root);
            color[root] = -1;

            while (!q.isEmpty()) {
                int cur = q.poll();

                for(int i : adj[cur]){
                    if(color[i] == 0){
                        color[i] = color[cur]*-1;
                        q.offer(i);
                    }else if(color[i] == color[cur]){
                        return false;
                    }
                }
            }
            return true;
        }
}
