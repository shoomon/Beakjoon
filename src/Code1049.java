import java.io.*;
import java.util.StringTokenizer;

public class Code1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, M, minSet=Integer.MAX_VALUE, minOne=Integer.MAX_VALUE, answer=0, toBuy;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        toBuy = N;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int tmpSet = Integer.parseInt(st.nextToken());
            int tmpOne = Integer.parseInt(st.nextToken());

            minSet = Math.min(minSet, tmpSet);
            minOne = Math.min(minOne, tmpOne);
        }

        while(toBuy > 0){
            int q;
            if(toBuy >= 6){
                q = toBuy/6;
                if(minSet > minOne*6){
                    answer += minOne*6*q;
                    toBuy -= 6*q;
                }else {
                    answer += minSet*q;
                    toBuy -= 6*q;
                }
            }else{
                if(minSet > minOne*toBuy){
                    answer += minOne*toBuy;
                    toBuy -= toBuy;
                }else{
                    answer += minSet;
                    toBuy -= 6;
                }
            }
        }

        bw.write(answer+"");

        br.close();
        bw.close();
    }
}
