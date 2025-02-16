//25.01.28
import java.util.*;
public class Code1157 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toUpperCase();
        int[] cnt = new int[26];
        int ansIdx=0, sameIdx=0;

        for(int i = 0; i < str.length(); i++){
            cnt[str.charAt(i)-'A']++;
        }

        for(int i = 0; i < 26; i++){
            if(cnt[ansIdx] < cnt[i]) {
                ansIdx = i;
            }else if(cnt[ansIdx] == cnt[i]){
                sameIdx = i;
            }
        }
        if(ansIdx != sameIdx && cnt[ansIdx] == cnt[sameIdx]){
            System.out.println("?");
        }else{
            System.out.println((char)(ansIdx+'A'));
        }
    }
}
