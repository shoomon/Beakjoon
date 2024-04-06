import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code14889 {
    static int N, min = Integer.MAX_VALUE;
    static int[][] S;
    static ArrayList<Integer> arr = new ArrayList<>(), arr2 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeTeam(1);
        System.out.println(min);
    }

    static void makeTeam(int last){
        int startScore=0, linkScore=0;

        if(arr.size() == N/2){
            arr2 = new ArrayList<>();
            for(int i  = 1; i < N+1; i++){
                if(arr.contains(i)) continue;
                arr2.add(i);
            }
            for(int i = 0; i < N/2-1; i++){
                for(int j = i+1; j < N/2; j++){
                    linkScore += S[arr2.get(i)-1][arr2.get(j)-1];
                    linkScore += S[arr2.get(j)-1][arr2.get(i)-1];
                }
            }
            for(int i = 0; i < N/2-1; i++){
                for(int j = i+1; j < N/2; j++){
                    startScore += S[arr.get(i)-1][arr.get(j)-1];
                    startScore += S[arr.get(j)-1][arr.get(i)-1];
                }
            }
            min = Math.min(Math.abs(linkScore-startScore), min);
        }

        for(int i = last; i < N+1; i++){
            if(arr.contains(i)) continue;
            arr.add(i);
            makeTeam(i);
            arr.remove(arr.size()-1);
        }
    }
}
