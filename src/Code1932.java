import java.io.*;
import java.util.StringTokenizer;

public class Code1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, len=0, answer=0, tmp=0;
        int[] dp, nums;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i = 1; i  <= N; i++){
            len += i;
        }

        dp = new int[len];
        nums = new int[len];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            tmp += i;
            for(int j = 0; j <= i; j++){
                nums[tmp+j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0] = nums[0];
        tmp = 0;

        for(int i = 1; i < N; i++){
            tmp += i;
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[tmp+j] = dp[(tmp+j-i)] + nums[tmp+j];
                }else if(j == i){
                    dp[tmp+j] = dp[(tmp+j-i-1)] + nums[tmp+j];
                }else {
                    dp[tmp + j] = Math.max(dp[(tmp + j-i-1)], dp[(tmp+ j-i)]) + nums[tmp+ j];
                }
            }
        }

        for(int i = len-N; i < len; i++){
            answer = Math.max(answer, dp[i]);
        }

        bw.write(answer+"");

        br.close();
        bw.close();

    }
}
