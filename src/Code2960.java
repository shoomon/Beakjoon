import java.util.Scanner;

public class Code2960 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, K, count=0, index = 2;
        int[] nums;

        N = sc.nextInt();
        K = sc.nextInt();
        nums = new int[N+1];

        while(count != K && index < N+1){
            int i = 1;
            while(index*i <= N){
                if(nums[index*i] == 1) {
                    i++;
                    continue;
                }
                nums[index*i] = 1;
                i++;
                count++;
                if(count == K){
                    System.out.println(index*(i-1));
                    break;
                }
            }
            while(nums[index] == 1){
                index++;
                if(index > N) break;
            }
        }


    }
}
