import java.awt.*;
import java.util.*;

public class Code15686_notDone {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, M, chickNum = 0, answer = 0;
        int[][] map;
        Point[] chickLoc;
        int[] chickDist;

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        chickLoc = new Point[13];
        chickDist = new int[13];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2){
                    chickLoc[chickNum++] = new Point(j, i);
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    minDist(i, j, chickNum, chickLoc, chickDist);
                }
            }
        }

        Arrays.sort(chickDist);
        int count = 0;

        while(count < M){
            if(chickDist[count] != 0){
                answer += chickDist[count++];
            }
        }

        System.out.println(answer + "");

    }

    static void minDist(int i, int j, int chickCount, Point[] chickLoc, int[] sumChick){
        int min = Integer.MAX_VALUE, dist, p = -1;

        for(int k = 0; k < chickCount; k++){
            dist = Math.abs(chickLoc[k].y - i) + Math.abs(chickLoc[k].x - j);
            if(dist < min){
                min = dist;
                p = k;
            }
        }
        sumChick[p] += min;
    }
}
