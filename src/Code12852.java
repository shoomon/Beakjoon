import java.util.Scanner;
public class Code12852 {
    static int[] dp;
    static int[] nums;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;

        n = sc.nextInt();
        dp = new int[n+1];
        nums = new int[n+1];

        dp[1] = 0;
        nums[1] = 0;

        for(int i = 2; i < n+1; i++){
            dp[i] = dp[i-1]+1; //(i-1) = (i) - 1, 연산 횟수
            nums[i] = i-1; //바로 이전 칸에서 왔다고 가정

            if(i % 3 == 0 && dp[i] > dp[i/3]+1){
                dp[i] = dp[i/3] + 1;
                nums[i] = i/3;
            }
            if(i % 2 == 0 && dp[i] > dp[i/2]+1){
                dp[i] = dp[i/2]+1;
                nums[i] = i/2;
            }
        }

        System.out.println(dp[n]);
        System.out.print(n + " ");
        int i = n;
        while(nums[i] != 0){
            System.out.print(nums[i] + " ");
            i = nums[i];
        }
    }
}
