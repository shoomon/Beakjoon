import java.util.Scanner;
import java.util.Arrays;
public class Code10817 {
    public static void main(String[] args){
        int[] nums = new int[3];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        System.out.println(nums[1]);
    }
}
