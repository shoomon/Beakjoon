import java.io.*;
import java.util.TreeMap;

//class File{
//    String text;
//    int count = 1;
//    public file(String t){
//        this.text = t;
//    }
//
//    public void countUp(int count) {
//        this.count++;
//    }
//}
public class Code20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<String, Integer> map = new TreeMap<>();
        String s;
        int N;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            s = br.readLine();
            s = s.split("\\.")[1];
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }else{
                map.put(s, 1);
            }
        }

        for(String k : map.keySet()){
            bw.write(k + " " + map.get(k) + "\n");
        }

        br.close();
        bw.close();
    }
}
