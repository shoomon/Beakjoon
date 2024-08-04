import java.awt.*;
import java.io.*;
import java.util.*;

public class Code14890_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, L, answer=0;
        int[][] map;
        ArrayList<Point> heightR, heightC;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            System.out.println(i+"========================");
            heightR = new ArrayList<>();
            heightC = new ArrayList<>();
            heightR.add(new Point(map[i][0], 1));
            heightC.add(new Point(map[0][i], 1));
            for(int j = 1; j < N; j++){
                Point curR = heightR.get(heightR.size()-1);
                if(Math.abs(map[i][j] - curR.x) > 1){
                    break;
                }else if(map[i][j] == curR.x){
                    curR.y += 1;
                    heightR.remove(heightR.size()-1);
                    heightR.add(curR);
                }else if(Math.abs(map[i][j] - curR.x) == 1){
                    heightR.add(new Point(map[i][j], 1));
                }

                Point curC = heightC.get(heightC.size()-1);
                if(Math.abs(map[j][i] - curC.x) > 1){
                    break;
                }else if(map[j][i] == curC.x){
                    curC.y += 1;
                    heightC.remove(heightC.size()-1);
                    heightC.add(curC);
                }else if(Math.abs(map[i][j] - curC.x) == 1){
                    heightC.add(new Point(map[j][i], 1));
                }
            }

            int flagR=0, flagC=0;
            System.out.println(heightR.size()+" "+heightC.size());
            for(int k = 2; k < heightR.size(); k++){
                Point r0 = heightR.get(k-2);
                Point r1 = heightR.get(k-1);
                Point r2 = heightR.get(k);

                if(r0.x > r1.x && r1.x < r2.x){
                    if(r1.y < 2*L){
                        flagR = 1;
                        break;
                    }
                }

                if((r0.x > r1.x && r1.y < L) || (r0.x < r1.x && r0.y < L)){
                    flagR = 1;
                    break;
                }

                if((r2.x > r1.x && r1.y < L) || (r2.x < r1.x && r2.y < L)){
                    flagR = 1;
                    break;
                }
                System.out.println(r0.x+" "+r1.x+" "+r2.x);
            }
            if(flagR == 0) answer++;
            for(int k = 2; k < heightC.size(); k++){
                Point c0 = heightC.get(k-2);
                Point c1 = heightC.get(k-1);
                Point c2 = heightC.get(k);

                if(c0.x > c1.x && c1.x < c2.x){
                    if(c1.y < 2*L){
                        flagC = 1;
                        break;
                    }
                }

                if((c0.x > c1.x && c1.y < L) || (c0.x < c1.x && c0.y < L)){
                    flagC = 1;
                    break;
                }

                if((c2.x > c1.x && c1.y < L) || (c2.x < c1.x && c2.y < L)){
                    flagC = 1;
                    break;
                }
                System.out.println(c0.x+" "+c1.x+" "+c2.x);
            }
            if(flagC == 0) answer++;
        }

        System.out.println(answer);
    }
}
