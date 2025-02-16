//25.02.08
//설계: 3분
//구현: 23+4분
//06:56 06:59 7:22
import java.util.*;

public class Code20413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        int[] gradeMaxTable, payment;
        char[] grades;

        N = sc.nextInt();
        gradeMaxTable = new int[5];

        for(int i = 0; i < 4; i++) gradeMaxTable[i] = sc.nextInt()-1;
        gradeMaxTable[4] = gradeMaxTable[3]+1;
        sc.nextLine();

        payment = new int[N];
        grades = sc.nextLine().toCharArray();
//        for(int c : gradeMaxTable) System.out.print(c+" ");

        switch(grades[0]){
            case 'B':
                payment[0] = gradeMaxTable[0];
                break;
            case 'S':
                payment[0] = gradeMaxTable[1];
                break;
            case 'G':
                payment[0] = gradeMaxTable[2];
                break;
            case 'P':
                payment[0] = gradeMaxTable[3];
                break;
            case 'D':
                payment[0] = gradeMaxTable[4];
                break;
        }

        for(int i = 1; i < N; i++){
            switch(grades[i]){
                case 'B':
                    payment[i] = gradeMaxTable[0]-payment[i-1];
                    break;
                case 'S':
                    payment[i] = gradeMaxTable[1]-payment[i-1];
                    break;
                case 'G':
                    payment[i] = gradeMaxTable[2]-payment[i-1];
                    break;
                case 'P':
                    payment[i] = gradeMaxTable[3]-payment[i-1];
                    break;
                case 'D':
                    payment[i] = gradeMaxTable[4];
                    break;
            }
        }

//        for(int i : payment) System.out.print(i+" ");

        int answer=0;
        for(int i : payment) answer += i;
        System.out.println(answer);

    }
}
