import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class code15964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A, B;

        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());

        bw.write(calculate(A,B).toString());

        br.close();
        bw.close();
    }

    static BigInteger calculate(BigInteger a, BigInteger b){
        return ((a.add(b)).multiply(a.subtract(b)));
    }
}
