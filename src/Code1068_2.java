import java.util.*;
import java.io.*;
//24.09.07
//설계 시간: 10분
//구현 시간: 20분
public class Code1068_2 {
    static int N, toDelete, answer;
    static int[] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        answer=0;
        N = Integer.parseInt(br.readLine());
        parents = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            parents[i] = Integer.parseInt(st.nextToken());
        }

        //직속 자식 뿐 아니라 자손들 모드 제거해야 함.
        toDelete = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(toDelete);
        parents[toDelete] = -2;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i < N; i++){
                if(parents[i] == cur) {
                    q.offer(i);
                    parents[i] = -2;
                }
            }
        }
//        for(int i : parents) System.out.print(i+" ");
//        System.out.println();

        for(int i = 0; i < N; i++) {
            if(parents[i] == -2) continue; //현재 트리에 포암된정점이 아니면 스킵
            boolean flag = true;
            for(int j = 0; j < N; j++){
                if(parents[j] == i){
                    flag= false;
                    break;
                }
            }
            if(flag) answer++;
        }

        System.out.println(answer);

    }
}
