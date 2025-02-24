//25.02.18
//설계: 13분
//구현: 27분
//12:35 12:48 01:15
//제일 큰 거에 다 합쳐가면 각 숫자들은 한 번만 절반으로 나뉘면 되고 결과적으로 (제일 큰 수 + (나머지 수들 합/2))가 답이됨
//내림차순 정렬하는법 까먹음
import java.util.*;
import java.io.*;

public class Code20115 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        Double[] drinks;
        double answer;

        N = Integer.parseInt(br.readLine());
        drinks = new Double[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) drinks[i] = Double.parseDouble(st.nextToken());

        Arrays.sort(drinks, Collections.reverseOrder());
        answer = drinks[0];

        for(int i = 1; i < N; i++) answer += drinks[i]/2;

        System.out.println(answer);
    }
}
