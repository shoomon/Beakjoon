import java.util.*;
import java.io.*;
//24.09.08
//설계 시간: 10분 (알고리즘 유형 참고함)
//구현 시간: 15분
public class Code17619 {
    static class Node implements Comparable<Node>{
        int id,x1,x2,y;
        public Node(int id,int x1, int x2, int y){
            this.id=id;
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }

        @Override
        public int compareTo(Node n){
            return this.x1-n.x1;
        }
    }

    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b){
        int pA = find(a);
        int pB = find(b);
        parents[pB] = pA;
    }

    static int N, Q;
    static PriorityQueue<Node> nodes;
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        nodes = new PriorityQueue<>();
        parents = new int[N];

        for(int i = 0; i < N; i++){
            parents[i] = i;
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.offer(new Node(i,x1,x2,y));
        }

        Node cur = nodes.poll();
        while(!nodes.isEmpty()){
            Node next = nodes.poll();
            if(cur.x2 >= next.x1) union(cur.id, next.id);
            cur = next;
        }

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            if(parents[Integer.parseInt(st.nextToken())-1] == parents[Integer.parseInt(st.nextToken())-1]){
                bw.write(1+"\n");
            }else{
                bw.write(0+"\n");
            }
        }
        bw.close();
    }
}
