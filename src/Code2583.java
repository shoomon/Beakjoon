import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Code2583 {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> size = new ArrayList<>();
        String s;
        StringTokenizer st;
        int m, n, k, startX, startY, endX, endY, count = 0;
        int[][] grid;
        try{
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            grid = new int[m][n];

            initTowDList(grid);

            for(int i = 0; i < k; i++) {
                s = br.readLine();
                st = new StringTokenizer(s, " ");
                startX = Integer.parseInt(st.nextToken());
                startY = Integer.parseInt(st.nextToken());
                endX = Integer.parseInt(st.nextToken());
                endY = Integer.parseInt(st.nextToken());

                for (int j = startY; j < endY; j++) {
                    for (int h = startX; h < endX; h++) {
                        if (grid[j][h] == 0) {
                            grid[j][h] = 1;
                        }
                    }
                }
            }

            for(int h = 0; h < grid.length; h++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[h][j] == 0){
                        size.add(DFS(grid, h, j, 0));
                        count++;
                    }
                }
            }
            Collections.sort(size);

            bw.write(count + " \n");
            for (int sz : size) {
                bw.write(sz + " ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    static void initTowDList(int[][] list){
        for(int i = 0; i < list.length; i++){
            for(int j = 0; j < list[0].length; j++){
                list[i][j] = 0;
            }
        }
    }

    static int DFS(int[][] map, int startY, int startX, int count){
        int nX, nY;

        count++;
        map[startY][startX] = -1;

        for(int i = 0; i < 4; i ++){
            nX = startX + dX[i];
            nY = startY + dY[i];
            if(nX >= 0 && nX < map[0].length && nY >= 0 && nY < map.length){
                if(map[nY][nX] == 0){
                    count = DFS(map, nY, nX, count);
                }
            }
        }
        return count;
    }

}
