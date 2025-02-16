import java.util.*;
import java.io.*;
//설계시간: 1분
//구현 시간: 45분
public class Code17471_2 {
    static int N, answer;
    static int[] population;
    static LinkedList<Integer>[] adj;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        adj = new LinkedList[N];
        population = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            adj[i] = new LinkedList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for(int j = 0; j < a; j++){
                int c = Integer.parseInt(st.nextToken())-1;
                adj[i].add(c);
            }
        }

        divide(0,new boolean[N]);

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }

    static void divide(int depth,boolean[] isSelected){
        if(depth == N){
//            System.out.println(isConnected(isSelected, true)+ " "+isConnected(isSelected, false));
            if(isConnected(isSelected, true) && isConnected(isSelected, false)){
                int a = 0, b = 0;
                for(int i = 0; i < N; i++){
                    if(isSelected[i]) {
                        a+=population[i];
                    }else{
                        b+=population[i];
                    }
                }

                answer = Math.min(answer, Math.abs(a-b));
            }
            return;
        }

        isSelected[depth] = true;
        divide(depth+1,isSelected);
        isSelected[depth] = false;
        divide(depth+1,isSelected);
    }

    static boolean isConnected(boolean[] isSelected, boolean state){
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            if(isSelected[i] == state){
                q.offer(i);
                visited[i] = true;
                break;
            }
        }

        //선택된 선거구 연결 여부
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : adj[cur]){
                if(visited[i] || isSelected[i] != state) continue;
                visited[i] = true;
                q.offer(i);
            }
        }
        if(state){
            for(int i = 0; i < N; i++){
                if(visited[i] != isSelected[i]) return false;
            }
        }else{
            for(int i = 0; i < N; i++){
                if(visited[i] == isSelected[i]) return false;
            }
        }

        return true;
    }
}
