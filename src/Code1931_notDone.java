import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code1931_notDone {
    public static void main(String[] args) {
        // 1931
        int n;
        int[] start, end;
        String[] s = new String[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            n = Integer.parseInt(br.readLine());
            start = new int[n];
            end = new int[n];
            for (int i = 0; i < n; i++) {
                s = br.readLine().split(" ");
                start[i] = Integer.parseInt(s[0]);
                end[i] = Integer.parseInt(s[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int setSchedule() {
        int count = 0;
        return count;
    }
}
