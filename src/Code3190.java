import java.awt.*;
import java.io.*;
import java.util.*;

public class Code3190 {
    static int[] dX = {0, 1,0,-1};
    static int[] dY = {-1, 0, 1, 0};
    static int N, K, L, curD, time=0;
    static int[][] map;
    static Deque<Point> snake = new LinkedList<>();
    static Queue<String[]> dir = new LinkedList<>();
    static Point head=new Point();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String[] s;
        Point temp=new Point();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            temp.y = Integer.parseInt(st.nextToken());
            temp.x = Integer.parseInt(st.nextToken());

            map[temp.y-1][temp.x-1] = 2;
        }

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());

        for(int i = 0; i < L; i++){
            s = new String[2];
            st = new StringTokenizer(br.readLine());
            s[0] = st.nextToken();
            s[1] = st.nextToken();

            dir.offer(s);
        }

        time = gameCount();
        bw.write(time+"");

        br.close();
        bw.close();
    }

    static int gameCount(){
        int count = 0, nX, nY;
        String[] nD = new String[2];
        Point tail;

        map[0][0] = 1;
        snake.offer(new Point(0,0));
        curD = 1;
        if(!dir.isEmpty()) nD = dir.poll();

        while(true){
            count++;
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println(count+ "=================");
            head = snake.pollFirst();

            nX = head.x+dX[curD];
            nY = head.y+dY[curD];
//            System.out.println("nX: " + nX + "nY: "+nY);

            if(0 > nX || N <= nX || 0 > nY || N <= nY || map[nY][nX] == 1){
                break;
            }
            if(map[nY][nX] == 2){
                snake.offerFirst(head);
                snake.offerFirst(new Point(nX, nY));
                map[nY][nX] = 1;
            }else{
                snake.offerFirst(head);
                snake.offerFirst(new Point(nX, nY));
                map[nY][nX] = 1;
                tail = snake.pollLast();
                map[tail.y][tail.x] = 0;
            }

            if(count == Integer.parseInt(nD[0])){
                if(nD[1].equals("D")){
                    curD = (curD+1)%4;
                }
                if(nD[1].equals("L")){
                    curD = (curD-1+4)%4;
                }
                if(!dir.isEmpty()) nD = dir.poll();
            }
        }
        return count;
    }
}
