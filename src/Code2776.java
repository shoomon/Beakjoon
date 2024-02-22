import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Code2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T, N, M;
        HashMap<Integer, Integer> note1;
        int[] note2, answer;

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            note1 = new HashMap<>();

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                note1.put(Integer.parseInt(st.nextToken()), 1);
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            note2 = new int[M];
            answer = new int[M];

            for(int i = 0; i < M; i++){
                note2[i] = Integer.parseInt(st.nextToken());
                answer[i] = note1.containsKey(note2[i]) ? 1 : 0;
            }

            for(int i = 0; i < M; i++){
                bw.write(answer[i]+"\n");
            }
        }
        br.close();
        bw.close();
    }
}
