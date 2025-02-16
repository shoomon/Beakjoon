//25.01.22
//설계: 4분
//구현: 60분
//10:40
//알파벳 26자 -> 두 자리 묶거나 안 묶거나 -> String[i] == 2 && String[i+1] < 7 || String[i] = 1
//DP
import java.util.*;

public class Code2011 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int MOD = 1000000;
        char[] nums = sc.nextLine().toCharArray();
        int len = nums.length;
        int[] dp = new int[len];

        if(nums[0] != '0') dp[0] = 1;

        if(len > 1){
            if(nums[1] != '0'){
                dp[1] = dp[0];
                if(nums[0] == '1' || (nums[0] == '2'&& nums[1] < '7')) dp[1]++;
            }else if(nums[0] == '1' || nums[0] == '2'){
                dp[1] = 1;
            }else{
                dp[1] = 0;
            }
        }


        for(int i = 2; i < len; i++){
            if(nums[i] != '0') {
                dp[i] = dp[i-1]%MOD; //독립적으로 존재 가능
            }else if(nums[i-1] == '1' || nums[i-1] == '2'){
                dp[i] = dp[i-2]%MOD;
            }
            if(nums[i] == '0') continue;
            if(nums[i-1] == '1' || (nums[i-1] == '2' && nums[i] < '7')) dp[i] += dp[i-2]%MOD; //앞의 수와 합치기 가능
            dp[i] %= MOD;
        }

//        for(int i : dp) System.out.print(i + " ");
//        System.out.println();
        System.out.println(dp[len-1]);
    }
}
