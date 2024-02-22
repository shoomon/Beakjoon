import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Code10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, M;
        int[]  toFind;
        HashMap<Integer, Integer> card = new HashMap<>();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            card.put(Integer.parseInt(st.nextToken()), i);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        toFind = new int[M];

        for(int i = 0; i < M; i++){
            if (card.containsKey(Integer.parseInt(st.nextToken()))) {
                toFind[i] = 1;
            }else{
                toFind[i] = 0;
            }
        }

        for(int i : toFind){
            bw.write(i+" ");
        }

        br.close();
        bw.close();

    }
}
