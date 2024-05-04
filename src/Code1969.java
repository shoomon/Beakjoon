import java.util.Scanner;

public class Code1969 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, M, count=0,answerIdx, answerCnt;
        String[] dna;
        int[] cnt;
        String answer = "";

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        dna = new String[N];

        for(int i = 0; i < N; i++){
            dna[i] = sc.nextLine();
        }

        for(int i = 0; i < M; i++){
            cnt = new int[4];
            answerIdx=-1;
            answerCnt=Integer.MIN_VALUE;
            for(int j = 0; j < N; j++){
                if(dna[j].charAt(i) == 'A') {
                    cnt[0]++;
                }else if(dna[j].charAt(i) == 'C') {
                    cnt[1]++;
                }else if(dna[j].charAt(i) == 'G') {
                    cnt[2]++;
                }else if(dna[j].charAt(i) == 'T') {
                    cnt[3]++;
                }
            }
            for(int j = 0; j < 4; j++){
                if(cnt[j] > answerCnt){
                    answerCnt = cnt[j];
                    answerIdx = j;
                }
            }
            if(answerIdx == 0){
                answer += "A";
            }else if(answerIdx == 1){
                answer += "C";
            }else if(answerIdx == 2){
                answer += "G";
            }else if(answerIdx == 3){
                answer += "T";
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(answer.charAt(j) != dna[i].charAt(j)) count++;
            }
        }

        System.out.println(answer);
        System.out.println(count);
    }
}
