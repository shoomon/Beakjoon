import java.io.*;
import java.util.StringTokenizer;

public class Code2115_notDone {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M, N, count = 0, nX, nY;
        char[][] map, visited;
        String s;
        StringTokenizer st;
        try {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new char[M][N];
            visited = new char[M][N];

            for(int i = 0; i < M; i++){
                s = br.readLine();
                map[i] = s.toCharArray();
            }

            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    visited[i][j] = '0';
                }
            }

            for(int i = 1; i < M-1; i++){
                for(int j = 1; j < N-1; j++){
                    if(visited[i][j] < '2' && map[i][j] == '.'){
                        for(int k = 0; k < 4; k++){
                            nX = j + dX[k];
                            nY = i + dY[k];
                            if(visited[nY][nX] < '2' && map[nY][nX] == '.'){
                                if(map[i+1][j] == 'X' && map[nY+1][nX] == 'X'){
                                    visited[i][j]++;
                                    visited[nY][nX]++;
                                    count++;
                                }
                                if(map[i][j+1] == 'X' && map[nY][nX+1] == 'X'){
                                    visited[i][j]++;
                                    visited[nY][nX]++;
                                    count++;
                                }
                                if(map[i-1][j] == 'X' && map[nY-1][nX] == 'X'){
                                    visited[i][j]++;
                                    visited[nY][nX]++;
                                    count++;
                                }
                                if(map[i][j-1] == 'X' && map[nY][nX-1] == 'X'){
                                    visited[i][j]++;
                                    visited[nY][nX]++;
                                    count++;
                                }
                            }
                        }
                    }
                }
            }

            bw.write(count + "");

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
