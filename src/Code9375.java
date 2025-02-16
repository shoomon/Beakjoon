//25.02.16
//11:07
//hash map list, 2^30이면 10억임 조합 어케함
//옷 종류마다 안 입는 경우를 추가해주면 되는 거였다
import java.io.*;
import java.util.*;

public class Code9375 {
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N;
        HashMap<String, List<String>> map = new HashMap<>();
        String[] input;

        for(int t = 0; t < T; t++){
            answer = 1;
            N = Integer.parseInt(br.readLine());
            map.clear();

            for(int i = 0; i < N; i++){
                input = br.readLine().split(" ");

                if(!map.containsKey(input[1])) map.put(input[1], new ArrayList<>());
                map.get(input[1]).add(input[0]);
            }

            for(String key : map.keySet()){
                answer *= map.get(key).size()+1;
            }

            sb.append((answer-1)+"\n");
        }
        System.out.println(sb.toString());
    }
}
