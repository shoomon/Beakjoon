import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code15652 {
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makeSeq(arr, bw);

        br.close();
        bw.close();
    }

    static void makeSeq(ArrayList<Integer> arr, BufferedWriter bw) throws IOException{
        int j;

        if(arr.size() == M){
            for(int i : arr){
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }

        if(arr.isEmpty()){
            j = 1;
        }else{
            j = arr.get(arr.size()-1);
        }

        for(; j < N+1; j++){
            arr.add(j);
            makeSeq(arr, bw);
            arr.remove(arr.size()-1);
        }
    }
}
