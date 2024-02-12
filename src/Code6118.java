import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code {
    static int N, M, answer, maxDist=0, sameDistNum=0;
    static int[] visited, dist;
    static LinkedList<LinkedList<Integer>> adj = new LinkedList<>();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        dist = new int[N+1];

        for(int i = 0; i < N+1; i++){
            adj.add(new LinkedList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        BFS();

        for(int i = 1; i < N+1; i++){
            if(dist[i] != 0 && dist[i] > maxDist){
                answer = i;
                maxDist = dist[i];
            }
        }

        for(int i = 1; i < N+1; i++){
            if(dist[i] == maxDist){
                sameDistNum++;
            }
        }

        bw.write(answer + " " + maxDist + " " + sameDistNum);
        br.close();
        bw.close();

    }

    static void BFS(){
        int cur;

        queue.offer(new Integer(1));
        visited[1] = 1;

        while(!queue.isEmpty()){
            cur = queue.poll();
            for(int i : adj.get(cur)){
                if(visited[i] == 0){
                    queue.add(i);
                    visited[i] = 1;
                    dist[i] = dist[cur]+1;
                }
            }
        }
    }
}
