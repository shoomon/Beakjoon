import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Code19637_notDone {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m, index;
        String[] nm;
        String[][] name;
        int[]power;
        try{
            nm = new String[2];
            nm = br.readLine().split(" ");
            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);

            name = new String[n][2];
            power = new int[m];

            for(int i = 0; i < n; i++){
                name[i] = br.readLine().split(" ");
            }

            for(int i = 0; i < m; i++){
                power[i] = Integer.parseInt(br.readLine());
                index = n/2;
                while(index < n){
                    if(power[i] > Integer.parseInt(name[index][1])){
                        index /= 2;
                    }else if(index == 0){
                        bw.write(name[index][0] + "\n");
                        break;
                    }else{
                        index++;
                        if(power[i] <= Integer.parseInt(name[index][1]) && power[i] > Integer.parseInt(name[index-1][1])){
                            bw.write(name[index][0] + "\n");
                            break;
                        }
                    }
                }
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
