import java.io.*;
import java.util.*;
import java.awt.*;
public class Code9205 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
//            System.out.println("test: "+ (t+1));
            int n = Integer.parseInt(br.readLine()), flag=0;
            ArrayList<Point> loc = new ArrayList<>();
            Queue<Point> q = new ArrayDeque<>();
            int[] visited = new int[n+2];

            for(int i = 0; i < n+2; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                loc.add(new Point(x,y));
            }

            q.offer(loc.get(0));
            visited[0] = 1;

            while(!q.isEmpty()){
                Point cur = q.poll();

//                System.out.println(cur.x+" "+cur.y);
                if(cur.x == loc.get(n+1).x && cur.y == loc.get(n+1).y){
                    flag = 1;
                    break;
                }

                for(int i = 1; i < n+2; i++){
                    Point next = loc.get(i);

                    if(visited[i] == 0 && (Math.abs(cur.x-next.x) + Math.abs(cur.y-next.y)) <= 1000){
//                        System.out.println(cur.x +" "+cur.y+" "+ next.x+" "+next.y+"/ " + (cur.x-next.x + cur.y-next.y));
                        q.offer(next);
                        visited[i] = 1;
                    }
                }
            }

            if(flag == 1){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }
    }
}
