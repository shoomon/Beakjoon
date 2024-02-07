import java.io.*;
import java.util.StringTokenizer;

public class Dijkstra {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        StringTokenizer st;
        int v, e, v1, v2, answer = 0;
        int[] dist;
        int[][] adj;

        try {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            adj = new int[v+1][v+1];
            dist = new int[v+1];

            initList(dist, Integer.MAX_VALUE);
            dist[1] = 0;

            for(int i = 0; i < e; i++){
                s = br.readLine();
                st = new StringTokenizer(s, " ");
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                adj[v1][v2] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= v; i++){
                for(int j = 1; j <= v; j++){
                    if(dist[i] != Integer.MAX_VALUE && dist[i] + adj[i][j] < dist[j]){
                        dist[j] = dist[i] + adj[i][j];
                    }
                }
            }
            for(int i = 1; i < v+1; i++){
                answer += dist[i];
            }
            System.out.println(answer);
        }catch (IOException ex){
            ex.printStackTrace();
        }finally{
            try {
                br.close();
                bw.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    static void initList(int[] list, int value){
        for(int i = 0; i < list.length; i++){
            list[i] = value;
        }
    }
}
