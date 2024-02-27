import java.io.*;
import java.util.TreeMap;

public class Code4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<String, Integer> map = new TreeMap<>();
        double count=0;
        String s;

        while(true){
            s = br.readLine();
            if(s == null) break;
            count++;
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }else{
                map.put(s, 1);
            }
        }
        for(String k : map.keySet()){
            bw.write(k + " " + String.format("%.4f", Math.round((map.get(k)/count)*1000000)/10000.0) + "\n");
        }

        br.close();
        bw.close();
    }
}
