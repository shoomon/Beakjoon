import java.io.*;
import java.util.*;

public class Code1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, count=0, prev=0;
        int[][] times;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        times = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i][0] = start;
            times[i][1] = end;
        }

        Arrays.sort(times, new Comparator<int[]>(){
            @Override()
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < N; i++){
            if(prev <= times[i][0]){
                prev = times[i][1];
                count++;
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }

}
