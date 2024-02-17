import java.io.*;
import java.util.StringTokenizer;

public class Code1068 {
    static int N, root, prt, toDelete, count=0;
    static int[][] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];

        st = new StringTokenizer(br.readLine());
        toDelete = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            prt = Integer.parseInt(st.nextToken());
            if(prt == -1){
                root = i;
                continue;
            }
            adj[prt][i] = 1;
        }

        if(toDelete == root){
            bw.write(0+"");
        }else{
            for(int i = 0; i < N; i++){
                adj[i][toDelete] = 0;
            }
            DFS(root);
            bw.write(count+"");
        }


        br.close();
        bw.close();
    }

    static void DFS(int vtx){
        int flag = 0;

        for(int i = 0; i < N; i++){
            if(adj[vtx][i] == 1){
                    flag = 1;
                    DFS(i);
            }
        }

        if(flag == 0){
            count++;
        }
    }
}
