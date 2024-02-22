import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Code7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;
        StringTokenizer st;
        String key, val;
        TreeMap<String, String> map = new TreeMap<>();
        Stack<String> s = new Stack<>();

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            key = st.nextToken();
            val = st.nextToken();
            map.put(key, val);
        }

        for(String k : map.keySet()){
            if(map.get(k).equals("enter")){
                s.push(k);
            }
        }

        while(!s.isEmpty()){
            bw.write(s.pop()+"\n");
        }
        br.close();
        bw.close();
    }
}
