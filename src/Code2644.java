import java.io.*;
import java.util.*;

public class Code2644 {
    static int result = -1;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int pepNum, edgNum, p1, p2;
        int[][] adj;
        int[] visited;
        try {
            pepNum = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            p1 = Integer.parseInt(st.nextToken());
            p2 = Integer.parseInt(st.nextToken());
            edgNum = Integer.parseInt(br.readLine());
            adj = new int[pepNum+1][pepNum+1];
            visited = new int[pepNum+1];

            for (int i = 0; i < edgNum; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adj[x][y] = 1;
                adj[y][x] = 1;
            }

            search(adj, visited, p1, p2, 0);
            bw.write(result + "");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void search(int[][] adj, int[] visited, int start, int end, int count) {
        visited[start] = 1;
//        System.out.println(start + ", " + end + ", " + count);
        if (start == end) {
            result =  count;
        }

        for (int i = 0; i < adj[0].length; i++) {
            if (visited[i] == 0 && adj[start][i] == 1) {
                search(adj, visited, i, end, count + 1);
            }
        }
    }
}
