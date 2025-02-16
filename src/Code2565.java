import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
//날짜 24.10.05
//설계 시간: 5분
//구현 시간: 15분
//메모리: 14184 kb
//시간: 104 ms
public class Code2565 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), max=0;
        int[][] line = new int[N][2];
        int[] lis = new int[N];

        for(int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, ((o1, o2) -> o1[0]-o2[0]));

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(line[i][1] > line[j][1]) lis[i] = Math.max(lis[i], lis[j]);
            }
            lis[i] += 1;
            max = Math.max(max, lis[i]);
        }

//        for(int i : lis) System.out.print(i+" ");
//        System.out.println();
        bw.write(N-max+"\n");
        bw.close();
    }
}

