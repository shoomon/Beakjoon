import java.io.*;
import java.util.StringTokenizer;

public class Code11404 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, M,v1,v2,cost;
        int[][] busCost;

        try{
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            busCost = new int[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    busCost[i][j] = Integer.MAX_VALUE;
                }
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());
                if(busCost[v1-1][v2-1] != Integer.MAX_VALUE){
                    if(busCost[v1-1][v2-1] > cost){
                        busCost[v1-1][v2-1] = cost;
                    }
                }else{
                    busCost[v1-1][v2-1] = cost;
                }

            }


            for(int k = 0; k < N; k++){
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        if(busCost[i][k] != Integer.MAX_VALUE && busCost[k][j] != Integer.MAX_VALUE
                                && busCost[i][j] > busCost[i][k] + busCost[k][j]){
                            busCost[i][j] = busCost[i][k] + busCost[k][j];
                        }
                    }
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    busCost[i][j] = busCost[i][j] == Integer.MAX_VALUE ? 0 : busCost[i][j];
                    if(i == j){
                        busCost[i][j] = 0;
                    }
                    bw.write(busCost[i][j] + " ");
                }
                bw.write("\n");
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                br.close();
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}
