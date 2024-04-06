import java.util.Arrays;
import java.util.Scanner;

public class Code4153 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];

        while(true){

            for(int i = 0; i < 3; i++){
                nums[i] = sc.nextInt();
            }
            if(nums[0] == 0 && nums[1] == 0 && nums[2] == 0) break;

            Arrays.sort(nums);

            if(Math.pow(nums[2],2) == Math.pow(nums[1],2)+Math.pow(nums[0],2)){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}
