import java.util.Scanner;

public class Code20055 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, K, answer = 0,count=0;
        int[] conv, robot;

        N = sc.nextInt();
        K = sc.nextInt();
        conv = new int[2*N+1];
        robot = new int[2*N+1];

        conv[0] = Integer.MIN_VALUE;
        for(int i = 1; i < 2*N+1; i++){
            conv[i] = sc.nextInt();
        }

        while(count < K){
            answer++;
            conv[0] = conv[2*N];
            robot[0] = robot[2*N];
            for(int i = 2*N; i > 0; i--){
                conv[i] = conv[i-1];
                robot[i] = robot[i-1];
            }
            robot[N] = 0;

            conv[0] = conv[1];
            robot[0] = robot[1];
            for(int i = 2*N; i > 0; i--){
                if(robot[i] == 1){
                    if(robot[(i+1)%(2*N+1)] == 0 && conv[(i+1)%(2*N+1)] > 0){
                        robot[(i+1)%(2*N+1)] = robot[i];
                        robot[i] = 0;
                        conv[(i+1)%(2*N+1)]--;
                        if(i+1 == N) robot[i+1] = 0;
                        if(conv[i+1] == 0) count++;
                    }
                }
            }
            conv[1] = conv[0];
            robot[1] = robot[0];

            if(conv[1] > 0 && robot[1] == 0){
                robot[1] = 1;
                conv[1]--;
                if(conv[1] == 0)count++;
            }
        }
        System.out.println(answer+"");
    }
}
