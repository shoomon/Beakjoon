import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Code2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, med, freq=0;
        double mean=0;
        ArrayList<Integer> list = new ArrayList<>(), fq = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int val = Integer.parseInt(br.readLine());
            map.put(val, map.getOrDefault(val, 1)+1);
            list.add(val);
        }

        for(int i : map.values()){
            freq = Math.max(i, freq);
        }

        for(int i : map.keySet()){
            if(map.get(i) == freq){
                fq.add(i);
            }
        }

        Collections.sort(fq);
        Collections.sort(list);

        for(int i : list){
            mean += i;
        }

        mean = Math.round(mean/N);

        med = list.get(list.size()/2);

        bw.write((int)mean+"\n");
        bw.write(med+"\n");
        if(fq.size() > 1){
            bw.write(fq.get(1)+"\n");
        }else{
            bw.write(fq.get(0)+"\n");
        }
        bw.write(Math.abs(list.get(list.size()-1)-list.get(0))+"\n");

        br.close();
        bw.close();

    }
}
