import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int v,w;
    public Node(int v,int w){
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Node n){
        return this.w-n.w;
    }
}
public class Code1753 {
    static int V, E, K;
    static int[] dist;
    static boolean[] visited;
    static LinkedList<Node>[] adj;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine())-1;
        dist = new int[V];
        visited = new boolean[V];
        adj = new LinkedList[V];

        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            adj[s].add(new Node(e,w));
        }
        dijkstra(K);
        for(int i : dist){
            if(i == Integer.MAX_VALUE){
                bw.write("INF\n");
            }else{
                bw.write(i+"\n");
            }

        }
        bw.close();
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(Node i : adj[cur.v]){
                Node next = i;

                if(dist[next.v]>cur.w + next.w){
                    dist[next.v] = cur.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
