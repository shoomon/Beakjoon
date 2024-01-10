import java.io.*;
import java.util.StringTokenizer;

public class Code1920 {
    public static void main(String[] args) {
        try {
            int n, m, find;
            char[] nums, toFind;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            nums = new char[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = st.nextToken().charAt(0);
            }

            m = Integer.parseInt(br.readLine());
            toFind = new char[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                toFind[i] = st.nextToken().charAt(0);
            }

            for (int i = 0; i < m; i++) {
                find = 0;
                if (new String(nums).indexOf(toFind[i]) != -1) {
                    find = 1;
                }
                bw.write(find + "\n");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
