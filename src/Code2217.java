import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Code2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, count=0, max=0;
        ArrayList<Integer> arr = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr, Collections.reverseOrder());

        for(int i : arr){
            count++;
            max = Math.max(i*count, max);
        }

        bw.write(max+"");

        br.close();
        bw.close();
    }
}
