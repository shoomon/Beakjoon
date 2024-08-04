import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Code2352 {
    static int N;
    static int[] seq;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        seq = new int[N];

        st = new StringTokenizer(sc.nextLine());
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        arr.add(seq[0]);

        for(int i = 1; i < N; i++){
            if(arr.get(arr.size()-1) < seq[i]){
                arr.add(seq[i]);
            }else{
                int idx = getMax(0, arr.size(), seq[i]);
                arr.remove(idx);
                arr.add(idx, seq[i]);
            }
        }

        System.out.println(arr.size()+"");
    }

    static int getMax(int left, int right, int target){
        int mid;

        while(left < right){
            mid = (left+right)/2;
            if(arr.get(mid) < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return right;
    }
}
