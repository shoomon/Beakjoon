import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Code2751 {
    public static void main(String[] args) throws IOException {
        int n;
        ArrayList<Integer> nums = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                nums.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(nums);

            for (int i = 0; i < nums.size(); i++) {
                bw.write(nums.get(i) + "\n");
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
