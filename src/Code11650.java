//25.01.24
//설계: 0분
//구현: 6분 10:50
import java.util.*;
import java.io.*;

public class Code11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1,o2)->{return o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];}
        );

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

//        for(int[] i : pq) System.out.println(i[0]+" "+i[1]);
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            System.out.println(cur[0]+" "+cur[1]);
        }
    }
}
