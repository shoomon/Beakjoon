//25.01.19
import java.util.*;

class C {
    static int N, M;
    static int[] answer;
   public static void main(String[] args){
       int[] ans = solution(new int[][] {{40, 10000}, {25, 10000}}, new int[] {7000, 9000});
       System.out.println(Arrays.toString(ans));
   }
    //25.01.30
//설계: 6분
//구현: 45분
//11:40 11:46 12:31
//완탐: 4^7*700 = 2^14*700 = 16,384*700 < 1천4백만

        public static int[] solution(int[][] users, int[] emoticons) {
            answer = new int[2];
            N = users.length;
            M = emoticons.length;

            permutation(0, new int[M], users, emoticons);

            return answer;
        }

        static void permutation(int depth, int[] saleRate, int[][] users, int[] emoticons){
            if(depth == M){
                int cnt=0, revenue=0;

                for(int i = 0; i < N; i++){
                    int buy=0;
                    for(int j = 0; j < M; j++){
//                        System.out.println(buy > users[i][1]);
                         if(buy >= users[i][1]) {
                             cnt++;
                             buy=0;
                             break;
                         }
                        if(saleRate[j] >= users[i][0]){
                            buy += Math.ceil(emoticons[j]*(1-saleRate[j]*0.01));
                            // System.out.println(buy > users[i][1]);
//                            if(buy >= users[i][1]) {
//                                cnt++;
//                                buy = 0;
//                                break;
//                            }
                        }
                    }
                    if(buy >= users[i][1]) {
                        cnt++;
                        buy=0;
                    }
                    revenue += buy;
                }
                // System.out.println(cnt+" "+revenue);
                if(answer[0] < cnt){
                    answer[0] = cnt;
                    answer[1] = revenue;
                }else if(answer[0] == cnt && answer[1] < revenue) {
                    answer[1] = revenue;
                }
                return;
            }

            saleRate[depth] = 40;
            permutation(depth+1, saleRate, users, emoticons);

            saleRate[depth] = 30;
            permutation(depth+1, saleRate, users, emoticons);

            saleRate[depth] = 20;
            permutation(depth+1, saleRate, users, emoticons);

            saleRate[depth] = 10;
            permutation(depth+1, saleRate, users, emoticons);
        }

}