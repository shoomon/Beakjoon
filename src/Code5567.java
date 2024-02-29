import java.util.*;

public class Code5567 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, M, a, b;
        ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0; i <= N; i++){
            adj.add(new LinkedList<Integer>());
        }

        for(int i = 0; i < M; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        Iterator<Integer> it = adj.get(1).iterator();
        while(it.hasNext()){
            int p = it.next();
            if(p == 1) continue;
            answer.add(p);
            q.offer(p);
        }
        while(!q.isEmpty()){
            int f = q.poll();
            Iterator<Integer> it2 = adj.get(f).iterator();
            while(it2.hasNext()){
                int p = it2.next();
                if(p == 1) continue;
                if(answer.contains(p)) continue;
                answer.add(p);
            }
        }

        System.out.println(answer.size());
    }
}
