import java.io.*;
import java.util.StringTokenizer;

public class Code14888 {
    static int N, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
    static int[] seq, opr = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            opr[i] = Integer.parseInt(st.nextToken());
        }

        minMax(1, seq[0]);

        bw.write(max+"\n"+min);

        br.close();
        bw.close();
    }

    static void minMax(int count, int val){
        if(count == N){
            if(val > max) max = val;
            if(val < min) min = val;
            return;
        }
        for(int j = 0; j < 4; j++){
            if(opr[j] > 0){
                opr[j]--;
                switch (j){
                    case 0: minMax(count+1, val+seq[count]); break;
                    case 1: minMax(count+1, val-seq[count]); break;
                    case 2: minMax(count+1, val*seq[count]); break;
                    case 3: minMax(count+1, val/seq[count]); break;
                }
                opr[j]++;
            }
        }
    }


}
