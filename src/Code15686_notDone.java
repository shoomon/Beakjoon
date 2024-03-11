import java.io.*;
import java.util.*;
import java.awt.*;
public class Code15686_notDone {
    static int N, M, answer=Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Point> home = new ArrayList<>(), chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist;
        Stack<Point> s = new Stack<>();


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) home.add(new Point(j,i));
                if(map[i][j] == 2) chicken.add(new Point(j,i));
            }
        }

        dist = new int[home.size()];

        Arrays.fill(dist, Integer.MAX_VALUE);

        chickDist(s, dist, 0);

        bw.write(answer+"");

        br.close();
        bw.close();

    }

    static void chickDist(Stack<Point> s, int[] dist, int count){
        Point p;

        if(count == M){
            int sum=0;
            for(int i = 0; i < dist.length; i++){
                sum += dist[i];
            }
            answer = Math.min(sum, answer);
            return;
        }

        if(!s.isEmpty()){
            p = s.peek();
            for(int i = 0; i < dist.length; i++){
                dist[i] = Math.min(dist[i], calcDist(home.get(i), p));
            }
        }

        for(int i = count; i < chicken.size(); i++){
            s.push(chicken.get(i));
            chickDist(s, dist, count+1);
            s.pop();
        }
    }

    static int calcDist(Point a, Point b){
        return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
    }
}
