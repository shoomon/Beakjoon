import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> arr = new ArrayList<>();
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] s = st.nextToken().split("-");

        for(String i : s){
            if(i.contains("+")){
                int k = 0;
                String[] tmp  = i.split("\\+");
                for(String j : tmp){
                    k += Integer.parseInt(j);
                }
                arr.add(k);
            }else{
                arr.add(Integer.parseInt(i));
            }
        }

        for(int i : arr){
            answer -= i;
        }
        answer += arr.get(0)*2;

        bw.write(answer+"");

        br.close();
        bw.close();
    }
}
