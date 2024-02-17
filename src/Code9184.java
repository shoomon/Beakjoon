import java.io.*;
import java.util.*;
public class Code9184 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a, b, c;
        int[][][] val;
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;

            if(a < 0 || b < 0 || c < 0){
                bw.write("w(" + a + ", " + b + ", " + c + ") = " + 1 + "\n");
                continue;
            }


            val = new int[21][21][21];
            for(int i = 0; i < 21; i++){
                for(int j = 0; j < 21; j++){
                    for(int k = 0; k < 21; k++){
                        if(i == 0 || j == 0 || k == 0){
                            val[i][j][k] = 1;
                        }else if(i < j && j < k){
                            val[i][j][k] = val[i][j][k-1] + val[i][j-1][k-1] - val[i][j-1][k];
                        }else{
                            val[i][j][k] = val[i-1][j][k] + val[i-1][j-1][k] + val[i-1][j][k-1] - val[i-1][j-1][k-1];
                        }
                    }
                }
            }
            if(a == 0 || b == 0 || c == 0){
                bw.write("w(" + a + ", " + b + ", " + c + ") = " + 1 + "\n");
            }else if(a > 20 || b > 20 || c > 20){
                bw.write("w(" + a + ", " + b + ", " + c + ") = " + val[20][20][20] + "\n");
            }
            else{
                bw.write("w(" + a + ", " + b + ", " + c + ") = " + val[a][b][c] + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
