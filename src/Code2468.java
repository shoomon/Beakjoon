import java.io.*;
import java.util.StringTokenizer;

public class Code2468 {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] map, visited, copy;
        int N, min=Integer.MAX_VALUE, max=0;
        try{
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new int[N][N];
            copy = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] < min){
                        min = map[i][j];
                    }
                    if(map[i][j] > max){
                        max = map[i][j];
                    }
                }
            }

            bw.write(rain(map, visited, copy, min, max) + "");

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }

    static int rain(int[][] map, int[][] visited, int[][] copy, int minHeight, int maxHeight){
        int max = 1, count;

        for(int i = minHeight+1; i < maxHeight+1; i++){
//            System.out.println("-------------");
            copyMap(map, copy, i);
            initList(visited);
            count = 0;
            for(int j = 0; j < copy.length; j++){
                for(int k = 0; k < copy[0].length; k++){
                    if(copy[j][k] != 0 && visited[j][k] == 0){
                        DFS(copy, visited, j, k);
                        count++;
                    }
                }
            }
//            System.out.println(count+"");
            max = Math.max(max, count);
        }
        return max;
    }

    static void DFS(int[][] map, int[][] visited, int curY, int curX){
        int nX, nY;

        visited[curY][curX] = 1;

        for(int i = 0; i < 4; i++){

            nX = curX + dX[i];
            nY = curY + dY[i];
            if(-1 < nX && nX < map[0].length && -1 < nY && nY < map.length){
                if(visited[nY][nX] == 0 && map[nY][nX] != 0){
                    DFS(map, visited, nY, nX);
                }
            }
        }
    }

    static void copyMap(int[][] map, int[][] copy, int height){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] < height){
                    copy[i][j] = 0;
                }else {
                    copy[i][j] = map[i][j];
                }
//                System.out.print(copy[i][j] +" ");
            }
//            System.out.println();
        }
    }

    static void initList(int[][] visited){
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[0].length; j++){
                visited[i][j] = 0;
            }
        }
    }

}
