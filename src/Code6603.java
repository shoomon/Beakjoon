import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int k;
        int[] s;
        ArrayList<Integer> answer = new ArrayList<>();

        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            s = new int[k];
            for(int i = 0; i < k; i++){
                s[i] = Integer.parseInt(st.nextToken());
            }
            findSeq(k, s, -1, answer, bw);
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
    static void findSeq(int k, int[] s, int prevIdx, ArrayList<Integer> a, BufferedWriter bw) throws IOException {
        if(a.size() == 6){
            for(int i : a){
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }
        for(int i = prevIdx+1; i < k; i++){
            if(!a.contains(s[i])){
                a.add(s[i]);
                findSeq(k, s, i, a, bw);
                a.remove(Integer.valueOf(s[i]));
            }
        }
    }
}
