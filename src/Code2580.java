import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Code2580 {
    static int callCount = 0;
    static ArrayList<Integer> have = new ArrayList<>();
    static int[][] map = new int[9][9];
    static int count = 0;
    static boolean flag=false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        String[] c;

        for (int i = 0; i < 9; i++) {
            s = br.readLine();
            c = s.split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(c[j]);
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        write(0, 0);
    }

    static void write(int index, int depth) {
        if(flag == true) return;
        if (depth == count) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            flag = true;
            return;
        }
        for (int idx = index; idx < 81; idx++) {
            int i = idx / 9;
            int j = idx % 9;
            if (map[i][j] == 0) {
                check(i, j);
                List<Integer> temp = new ArrayList<>(have);
                for (int k : temp) {
                    map[i][j] = k;
                    write(idx + 1, depth + 1);
                    map[i][j] = 0;
                }
                break;
            }
        }
    }

    static void check(int r, int c) {
        have.clear();

        boolean[] used = new boolean[10];

        for (int i = 0; i < 9; i++) {
            used[map[r][i]] = true;
        }
        for (int i = 0; i < 9; i++) {
            used[map[i][c]] = true;
        }

        for (int i = (r / 3) * 3; i < (r / 3) * 3 + 3; i++) {
            for (int j = (c / 3) * 3; j < (c / 3) * 3 + 3; j++) {
                used[map[i][j]] = true;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (!used[i]) have.add(i);
        }

    }
}
