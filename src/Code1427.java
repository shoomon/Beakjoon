import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Code1427 {
    public static void main(String[] args) throws IOException {
        int num;
        ArrayList<Integer> nums = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            num = Integer.parseInt(br.readLine());
            while(num > 0) {
                nums.add(num % 10);
                num /= 10;
            }
            Collections.sort(nums, Collections.reverseOrder());

            for (int i = 0; i < nums.size(); i++) {
                bw.write(Integer.toString(nums.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bw.flush();
            bw.close();
            br.close();
        }
    }
}
