import java.awt.*;
import java.io.*;
import java.util.*;

public class Code14502 {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    static int N, M, answer;
    static int[][] map, copy;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            copy = new int[N][M];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            makeWall(0, 0);

            bw.write(answer + "");

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

    static void spreadVirus(){
        Point cur, next = new Point();

        while(!queue.isEmpty()){
            cur = queue.poll();

            for(int i = 0; i < 4; i++){
                next.x = cur.x + dX[i];
                next.y = cur.y + dY[i];
                if(next.y > -1 && next.y < copy.length && next.x > -1 && next.x < copy[0].length){
                    if(copy[next.y][next.x] == 0){
                        queue.offer(new Point(next));
                        copy[next.y][next.x] = 2;
                    }
                }
            }
        }
    }

    static int countSafe(int[][] map){
        int count = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    static void copyMap(int[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                copy[i][j] = map[i][j];
                if(map[i][j] == 2){
                    queue.offer(new Point(j, i));
                }
            }
        }
    }

    static void makeWall(int start, int count){
        if(count == 3){
//            System.out.println();
            copyMap(map);
            spreadVirus();
//            printCopy();
            answer = Math.max(answer, countSafe(copy));
            return;
        }

        for(int i = start; i < N*M; i++){
            if(map[i / M][i % M] == 2 || map[i / M][i % M] == 1) continue;
            map[i / M][i % M] = 1;
//            System.out.print(i / M+" "+i % M+", ");
            makeWall(i+1, count+1);
            map[i / M][i % M] = 0;
        }
    }

    //for debugging
//    static void printCopy(){
//        for(int i = 0 ; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(copy[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("-------------------");
//    }


}