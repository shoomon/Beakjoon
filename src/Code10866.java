import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Code10866 {
    static LinkedList<String> deq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N;
        String c, val="";

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            c = st.nextToken();
            if(st.hasMoreTokens()) val = st.nextToken();
            switch (c){
                case "push_front": deq.addFirst(val); break;
                case "push_back": deq.addLast(val); break;
                case "pop_front":
                    if(deq.isEmpty()){
                        bw.write(-1+"\n");
                        break;
                    }else{
                        bw.write(deq.get(0)+"\n");
                        deq.remove(0);
                        break;
                    }
                case "pop_back":{
                    if(deq.isEmpty()){
                        bw.write(-1+"\n");
                        break;
                    }else{
                        bw.write(deq.get(deq.size()-1)+"\n");
                        deq.remove((deq.size()-1));
                        break;
                    }
                }
                case "size": bw.write(deq.size()+"\n"); break;
                case "empty":{
                    if(deq.isEmpty()) {
                        bw.write(1+"\n");
                        break;
                    }else {
                        bw.write(0+"\n");
                        break;
                    }
                }
                case "front":{
                    if(deq.isEmpty()){
                        bw.write(-1+"\n");
                        break;
                    }else{
                        bw.write(deq.get(0)+"\n");
                        break;
                    }
                }
                case "back":{
                    if(deq.isEmpty()){
                        bw.write(-1+"\n");
                        break;
                    }else{
                        bw.write(deq.get(deq.size()-1)+"\n");
                        break;
                    }
                }
            }
        }

        br.close();
        bw.close();

    }
}
