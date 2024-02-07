import java.io.*;
import java.util.*;

public class Code2252_fail {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, M, first, second;
        LinkedList<Integer> list = new LinkedList<>();
        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                first = Integer.parseInt(st.nextToken());
                second = Integer.parseInt(st.nextToken());
                if(list.contains(first)){
                    list.add(list.indexOf(first)+1, second);
                }else if(list.contains(second)){
                    if(list.indexOf(second) == 0){
                        list.addFirst(first);
                    }else{
                        list.add(list.indexOf(second)-1, first);
                    }
                }else{
                    list.add(first);
                    list.add(second);
                }
            }
            if(list.size() == N){
                for(int i = 0; i < list.size(); i++){
                    bw.write(list.get(i)+" ");
                }
            }else{
                bw.write(-1+"");
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                br.close();
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
