import java.io.*;
import java.util.*;
public class Code17406 {
    static int N, M, K, answer;
    static int[][] A, rotation, copy;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        A = new int[N][M];
        copy = new int[N][M];
        rotation = new int[K][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                rotation[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sequence(0, new boolean[K], new int[K]);
        System.out.println(answer);
    }

    static void copy(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copy[i][j] = A[i][j];
            }
        }
    }

    static void sequence(int depth, boolean[] visited, int[] seq){
        if(depth == K){
            copy();
            for(int i : seq){
                rotate(i);
            }
            updateAnswer();
            return;
        }

        for(int i = 0; i < K; i++){
            if(!visited[i]){
                visited[i] = true;
                seq[depth] = i;
                sequence(depth+1, visited, seq);
                visited[i] = false;
            }
        }
    }

    static void rotate(int num){
        int r=rotation[num][0]-1, c=rotation[num][1]-1, s=rotation[num][2], tmp;

        for(; s > 0; s--){
            tmp = copy[r-s][c-s];
//            System.out.println(s);
            for(int i = 0; i < 2*s; i++){
//                System.out.println("in: "+(r-s+i)+" "+(c-s));
                copy[r-s+i][c-s] = copy[r-s+i+1][c-s];
//                System.out.println("out: "+(r-s+i)+" "+(c-s));
            }
            for(int i = 0; i < 2*s; i++){
                copy[r+s][c-s+i] = copy[r+s][c-s+i+1];
            }
            for(int i = 2*s; i > 0; i--){
                copy[r-s+i][c+s] = copy[r-s+i-1][c+s];
            }
            for(int i = 2*s; i > 0; i--){
                copy[r-s][c-s+i] = copy[r-s][c-s+i-1];
            }
            copy[r-s][c-s+1] = tmp;
        }

    }

    static void updateAnswer(){
        int min=Integer.MAX_VALUE;

        for(int i = 0; i  < N; i++){
            int tmp = 0;
            for(int j = 0; j < M; j++){
                tmp += copy[i][j];
            }
            min = Math.min(min, tmp);
        }
        answer = Math.min(answer, min);
    }
}
