import java.awt.*;
import java.util.*;

public class Code1966 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T, N, M, cnt, index;
        Point cur;
        ArrayList<Integer> doc;
        Queue<Point> q;

        T = sc.nextInt();

        for(int t = 0; t < T; t++){
            cnt = 0;
            index = 0;
            N = sc.nextInt();
            M = sc.nextInt();

            doc = new ArrayList<>();
            q = new LinkedList<>();

            for(int i = 0; i < N; i++){
                doc.add(sc.nextInt());
                q.offer(new Point(doc.get(i), i));
            }

            Collections.sort(doc, Collections.reverseOrder());

            cur = new Point(-1,-1);
            while(!q.isEmpty()){
                cur = q.poll();

                if(doc.get(index) == cur.x){
                    if(cur.y == M) break;
                    index++;
                    cnt++;
                }else{
                    q.add(cur);
                }
            }

            System.out.println(cnt+1);

        }

    }
}
