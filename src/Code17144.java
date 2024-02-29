import java.io.*;
import java.util.StringTokenizer;

public class Code17144 {
    static int R, C, T, r1=-1, r2, answer = 0;
    static int[][] room;
    static int[] dR = {-1, 0, 1, 0};
    static int[] dC = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        room = new int[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == -1 && r1 == -1) r1 = i;
            }
        }
        r2 = r1+1;

        spread();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(room[i][j] > 0) answer += room[i][j];
            }
        }

        bw.write(answer+"");

        br.close();
        bw.close();
    }

    static void spread(){
        int nR, nC;
        for(int t = 0; t < T; t++){
            int[][] tempRoom = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (room[i][j] > 0) {
                        int spreadAmount = room[i][j] / 5;
                        int spreadCount = 0;
                        for (int k = 0; k < 4; k++) {
                            nR = i + dR[k];
                            nC = j + dC[k];
                            if (check(nR, nC)) {
                                tempRoom[nR][nC] += spreadAmount;
                                spreadCount++;
                            }
                        }
                        room[i][j] -= spreadAmount * spreadCount;
                    }
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    room[i][j] += tempRoom[i][j];
                }
            }
            clean();
//            System.out.println("Test: "+ t+ ", r1: " + r1 + "r2: "+r2);
//            for(int i = 0; i < R; i++){
//                for(int j = 0; j < C; j++){
//                    System.out.print(room[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("----------------");
        }
    }

    static void clean(){
        for(int i = r1-1; i > 0; i--){
            room[i][0] = room[i-1][0];
        }
        for(int i = r2+1; i < R-1; i++){
            room[i][0] = room[i+1][0];
        }
        for(int i = 0; i < C-1; i++){
            room[0][i] = room[0][i+1];
            room[R-1][i] = room[R-1][i+1];
        }
        for(int i = R-1; i > r2; i--){
            room[i][C-1] = room[i-1][C-1];
        }
        for(int i = 0; i < r1; i++){
            room[i][C-1] = room[i+1][C-1];
        }
        for(int i = C-1; i > 1; i--){
            room[r1][i] = room[r1][i-1];
            room[r2][i] = room[r2][i-1];
        }
        room[r1][1] = 0;
        room[r2][1] = 0;
    }

    static boolean check(int a, int b){
        if(-1 < a && a < R && -1 < b && b < C && room[a][b] != -1) return true;
        return false;
    }
}
