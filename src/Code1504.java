import java.io.*;
import java.util.*;
import java.awt.*;

public class Code1504 {
    static int N, E, v1, v2, a, b, c, answer;
    static ArrayList<LinkedList<Point>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N+1; i++){
            adj.add(new LinkedList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Point(b,c));
            adj.get(b).add(new Point(a,c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        if(dist[v1] == Integer.MAX_VALUE || distV1[v2] == Integer.MAX_VALUE || distV2[N] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else if(dist[v2] == Integer.MAX_VALUE || distV2[v1] == Integer.MAX_VALUE || distV1[N] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            answer = Math.min(dist[v1]+distV1[v2]+distV2[N], dist[v2]+distV2[v1]+distV1[N]);
            System.out.println(answer);
        }

    }
    static int[] dijkstra(int start){
        int[] dist = new int[N+1];
        Queue<Point> q = new LinkedList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        q.offer(new Point(start, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if(dist[cur.x] < cur.y) continue;

            for(Point next : adj.get(cur.x)){
                if(dist[next.x] > dist[cur.x] + next.y){
                    dist[next.x] = dist[cur.x] + next.y;
                    q.offer(new Point(next.x,dist[next.x]));
                }
            }
        }
        return dist;
    }
}
