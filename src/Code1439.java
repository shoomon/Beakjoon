//25.02.14
//설계: 1분
//구현: 7+7분
//12:1112 :18 12:25
//연속된 구간 수 중 작은 카운트 리턴 -> O(N)
import java.util.*;

public class Code1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] num = sc.nextLine().toCharArray();
        int cnt=0;

        for(int i = 0; i < num.length-1; i++){
            if(num[i] != num[i+1]) cnt++;
        }

        if(cnt%2 == 1) cnt++;
        if(cnt != 0 && cnt != 1) cnt /= 2;

        System.out.println(cnt);
    }
}
