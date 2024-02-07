import java.io.*;
import java.util.*;

public class Code18352 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> cities = new ArrayList<>();
        List<Integer>[] adj;
        int N, M, K, X, c1, c2;
        int[] dist;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        try{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            adj = new List[N+1];
            dist = new int[N+1];

            for(int i = 0; i < N+1; i++) adj[i] = new ArrayList<>();

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                c1 = Integer.parseInt(st.nextToken());
                c2 = Integer.parseInt(st.nextToken());
                adj[c1].add(c2);
            }

            Arrays.fill(dist, Integer.MAX_VALUE);
            queue.add(X);
            dist[X] = 0;

            while(!queue.isEmpty()){
                int cur = queue.poll();
                if(dist[cur] == K){
                    cities.add(cur);
                }

                for(int next : adj[cur]){
                    if(dist[next] != Integer.MAX_VALUE) continue;
                    dist[next] = dist[cur]+1;
                    queue.add(next);
                }
            }


            if(cities.isEmpty()){
                bw.write(-1+"");
            }else{
                Collections.sort(cities);
                for(int i : cities){
                    sb.append(i).append("\n");
                }
                bw.write(sb + "");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
