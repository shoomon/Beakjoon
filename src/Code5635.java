import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Code5635 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<Integer, String> map = new TreeMap<>();
        String key, val, d, m, y;
        int N;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            key = "";
            val = "";
            st = new StringTokenizer(br.readLine());
            val = st.nextToken();
            d = st.nextToken();
            m = st.nextToken();
            y = st.nextToken();

            key += y;
            if(m.length() == 1){
                key += "0"+m;
            }else{
                key += m;
            }
            if(d.length() == 1){
                key += "0"+d;
            }else{
                key += d;
            }

            map.put(Integer.parseInt(key), val);

        }

        System.out.println(map.get(map.lastKey()));
        System.out.println(map.get(map.firstKey()));

    }
}
