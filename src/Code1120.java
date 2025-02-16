//25.02.13
//설계: 2분
//구현: 8분
//10:59 11:07
//문자열 하나씩 대보기
import java.util.*;

public class Code1120 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int matchCount = 0;
        String A, B;

        A = sc.next();
        B = sc.next();

        for(int i = 0; i < B.length()-A.length()+1; i++){
            int count = 0;
            for(int j = 0; j < A.length(); j++){
                if(B.charAt(i+j) == A.charAt(j)) count++;
            }
            matchCount = Math.max(matchCount, count);
        }

        matchCount += B.length()-A.length();

        System.out.println(B.length()-matchCount);

    }
}
