import java.io.*;
import java.util.StringTokenizer;

public class Code14890_fail {
    static int N, L, count=0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation();
        bw.write(count+"");

        br.close();
        bw.close();
    }

    static void simulation(){
        int cnt1=0, cnt2=0, tmp, flag;
        int[] copy = new int[N];

        for(int i = 0; i < N; i++){
            for(int t = 0; t < N; t++){
                copy[t] = map[i][t];
            }
            flag=0;
            cnt1=1;

            for(int j = 0; j < N-1; j++){
                if (map[i][j] == map[i][j + 1]) {
                    cnt1++;
                } else if (map[i][j] + 1 == map[i][j+1]) {
                    if (cnt1 < L) {
                        flag = 1;
                        break;
                    }
                    cnt1 = 1;
                } else if (map[i][j] - 1 == map[i][j+1]) {
                    cnt1 = 1;
                    cnt2 = 1;
                    j++;
                    tmp = j;
                    while (j + 1 < N && map[i][j] == map[i][j+1]) {
                        cnt2++;
                        j++;
                    }
                    if (cnt2 < L) {
                        flag = 1;
                        break;
                    }else{
                        for(int k = 0; k < L; k++){
                            map[i][tmp+k] = -1;
                        }
                        if(tmp+L < N && copy[tmp+L-1] < map[i][tmp+L]){
                            flag = 1;
                            break;
                        }
                        j = tmp+L-1;
                    }
                } else {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                count++;
                System.out.print(i+" ");
            }
            for(int t = 0; t < N; t++){
                map[i][t] = copy[t];
            }
        }
        System.out.println("/");

        for(int j = 0; j < N; j++){
            for(int t = 0; t < N; t++){
                copy[t] = map[t][j];
            }
            flag=0;
            cnt1=1;

            for(int i = 0; i < N-1;i++){
                if (map[i][j] == map[i+1][j]) {
                    cnt1++;
                } else if (map[i][j] + 1 == map[i+1][j]) {
                    if (cnt1 < L) {
                        flag = 1;
                        break;
                    }
                    cnt1 = 1;
                } else if (map[i][j] - 1 == map[i+1][j]) {
                    cnt1 = 1;
                    cnt2 = 1;
                    i++;
                    tmp = i;
                    while (i + 1 < N && map[i][j] == map[i+1][j]) {
                        cnt2++;
                        i++;
                    }
                    if (cnt2 < L) {
                        flag = 1;
                        break;
                    }else{
                        for(int k = 0; k < L; k++){
                            map[tmp+k][j] = -1;
                        }
                        if(tmp+L < N && copy[tmp+L-1] < map[tmp+L][j]){
                            flag = 1;
                            break;
                        }
                        i = tmp+L-1;
                    }
                } else {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                count++;
                System.out.print(j+" ");
            }
            for(int t = 0; t < N; t++){
                map[t][j] = copy[t];
            }
        }

    }
}
