import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class Code7568 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, count;
        StringTokenizer st;
        Point wH = new Point();
        Point[] people;
        try {
            N = Integer.parseInt(br.readLine());
            people = new Point[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                people[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            for(int i = 0; i < N; i++){
                count = 1;
                for(int j = 0; j < N; j++){
                    if(people[i].x < people[j].x && people[i].y < people[j].y){
                        count++;
                    }
                }
                bw.write(count + " ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
