import java.util.Scanner;
import java.util.StringTokenizer;

public class Code2477 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K, dir, len, answer, maxX = 0, maxY = 0, indexX = -1, indexY = -1;
        StringTokenizer st;
        int[][] map = new int[6][2];

        K = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < 6; i++){
            st = new StringTokenizer(sc.nextLine());
            dir = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());
            map[i][0] = dir;
            map[i][1] = len;
            if(dir == 3 || dir == 4){
                if(maxY < len){
                    maxY = len;
                    indexY = i;
                }
            }else{
                if(maxX < len){
                    maxX = len;
                    indexX = i;
                }
            }
        }
        answer = (maxX*maxY - map[(indexX+3)%6][1]*map[(indexY+3)%6][1])*K;
        System.out.println(answer);
    }
}
