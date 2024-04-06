import java.io.*;
import java.util.StringTokenizer;
public class Code1002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T;
        double distPow;
        int[] xyr = new int[6];

        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++){
                xyr[j] = Integer.parseInt(st.nextToken());
            }

            distPow = Math.pow(xyr[0]-xyr[3],2)+Math.pow(xyr[1]-xyr[4],2);
            int minR = Math.min(xyr[2], xyr[5]);
            int maxR = Math.max(xyr[2], xyr[5]);

            if(xyr[0] == xyr[3] && xyr[1] == xyr[4]){
                if(xyr[2] != xyr[5]){
                    System.out.println(0+"");
                }else{
                    System.out.println(-1+"");
                }
            }else if(distPow < Math.pow(maxR,2)){
                if(Math.pow(maxR-minR, 2) > distPow){
                    System.out.println(0+"");
                }else if(Math.pow(maxR-minR, 2) == distPow){
                    System.out.println(1+"");
                }else{
                    System.out.println(2+"");
                }
            }else if(distPow > Math.pow(maxR+minR, 2)){
                System.out.println(0+"");
            }else if(distPow == Math.pow(maxR+minR, 2)){
                System.out.println(1+"");
            }else{
                System.out.println(2+"");
            }

        }
    }
}
