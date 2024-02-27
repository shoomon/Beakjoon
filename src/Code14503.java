import java.io.*;
import java.util.StringTokenizer;

public class Code14503 {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {-1, 0, 1, 0};
    static int N, M, r,c,d, flag=1, count=0, nextD;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            flag = 0;
            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }
            for(int i = 0; i < 4; i++){
                nextD = (d+4-i-1)%4;
                if(-1 < r+dY[nextD] && r+dY[nextD] < map.length && -1 < c+dX[nextD] && c+dX[nextD] < map[0].length){
                    if(map[r+dY[nextD]][c+dX[nextD]] == 0){
                        flag = 1;
                        r = r+dY[nextD];
                        c = c+dX[nextD];
                        d = nextD;
                        break;
                    }
                }
            }
            if(flag == 0){
                if(canBack()){
                    r += dY[(d+2)%4];
                    c += dX[(d+2)%4];
                }else{
                    break;
                }
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();

    }

    static boolean canBack(){
        if(0 > c+dX[(d+2)%4] || map[0].length-1 < c+dX[(d+2)%4] || 0 > r+dY[(d+2)%4] || map.length-1 < r+dY[(d+2)%4]){
            return false;
        }
        if(map[r+dY[(d+2)%4]][c+dX[(d+2)%4]] == 1){
            return false;
        }
        return true;
    }

}