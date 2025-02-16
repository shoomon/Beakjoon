import java.util.*;
import java.io.*;
//날짜 24.
//설계 시간: 분
//구현 시간: 분
//메모리: kb
//시간: ms
public class Cod {
        public static void main(String args[]) throws Exception
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int T;
            T=Integer.parseInt(br.readLine());

            for(int test_case = 1; test_case <= T; test_case++)
            {

                bw.write("#"+test_case+" "+"\n");
            }
            bw.close();
        }
}
