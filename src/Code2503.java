import java.util.Scanner;

public class Code2503 {
    static int N, num, s, b, count=0;
    static int[][] nums, sb, tmp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N][3];
        sb = new int[N][2];

        for(int i = 0 ;i < N; i++){
            num = sc.nextInt();
            s = sc.nextInt();
            b = sc.nextInt();
            if(s == 3) {
                System.out.println(1);
                System.exit(0);
            }
            nums[i][0] = num/100;
            nums[i][1] = (num/10)%10;
            nums[i][2] = num%10;
            sb[i][0] = s;
            sb[i][1] = b;
        }

        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                if(j == i) continue;
                for(int k = 1; k < 10; k++){
                    if(k == j || k == i) continue;
                    tmp = new int[N][2];
                    baseball(i,j,k);
                    if(isEqual()) count++;
                }
            }
        }

        System.out.println(count);

    }

    static void baseball(int i, int j, int k){
        for(int a = 0; a < N; a++){
            if(nums[a][0] == i) tmp[a][0]++;
            if(nums[a][1] == i) tmp[a][1]++;
            if(nums[a][2] == i) tmp[a][1]++;

            if(nums[a][0] == j) tmp[a][1]++;
            if(nums[a][1] == j) tmp[a][0]++;
            if(nums[a][2] == j) tmp[a][1]++;

            if(nums[a][0] == k) tmp[a][1]++;
            if(nums[a][1] == k) tmp[a][1]++;
            if(nums[a][2] == k) tmp[a][0]++;
        }
    }

    static boolean isEqual(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                if(sb[i][j] != tmp[i][j]) return false;
            }
        }
        return true;
    }
}
