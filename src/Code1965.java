//25.01.05
//설계: 1분
//구현: 15분
//LIS
import java.io.*;
import java.util.*;

public class Code1965 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        ArrayList<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int idx = Collections.binarySearch(box,cur);

            if(idx < 0) idx = (idx+1)*-1;

            if(idx == box.size()){
                box.add(cur);
            }else{
                box.set(idx,cur);
            }
        }

        System.out.println(box.size());
    }
}
