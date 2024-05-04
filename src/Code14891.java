import java.util.ArrayList;
import java.util.Scanner;

public class Code14891 {
    static int K,n, d, first=2, secondB=6, secondF=2, thirdB=6, thirdF=2, forth=6, answer = 0;
    static ArrayList<char[]> w = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s;

        for(int i = 0; i < 4; i++){
            s = sc.nextLine();
            w.add(s.toCharArray());
        }

        K = sc.nextInt();

        for(int i = 0; i < K; i++){
            n = sc.nextInt();
            d = sc.nextInt();
            operate();
//            System.out.println(i+" "+n+" "+d);
//            System.out.println(first+" "+secondB+" "+secondF+" "+thirdB+" "+thirdF+" "+forth);
        }
//        System.out.println(w.get(0)[(first-2+8)%8]+ " "+w.get(1)[(secondF-2+8)%8]+" "+w.get(2)[(thirdF-2+8)%8]+" "+w.get(3)[(forth+2+8)%8]);
        score();
        System.out.println(answer);
    }

    static void score(){
        if(w.get(0)[(first-2+8)%8] == '1'){
            answer += 1;
        }
        if(w.get(1)[(secondF-2+8)%8] == '1'){
            answer += 2;
        }
        if(w.get(2)[(thirdF-2+8)%8] == '1'){
            answer += 4;
        }
        if(w.get(3)[(forth+2+8)%8] == '1'){
            answer += 8;
        }
    }

    static void operate(){

        if(n == 1){
            if(w.get(0)[first] != w.get(1)[secondB]){
                if(w.get(1)[secondF] != w.get(2)[thirdB]){
                    if(w.get(2)[thirdF] != w.get(3)[forth]){
                        move(4,-1*d);
                    }
                    move(3, d);
                }
                move(2,-1*d);
            }
            move(1, d);
        }
        if(n == 2){
            if(w.get(0)[first] != w.get(1)[secondB]){
                move(1, -1*d);
            }
            if(w.get(1)[secondF] != w.get(2)[thirdB]){
                if(w.get(2)[thirdF] != w.get(3)[forth]){
                    move(4,d);
                }
                move(3, -1*d);
            }
            move(2, d);
        }
        if(n == 3){
            if(w.get(2)[thirdB] != w.get(1)[secondF]){
                if(w.get(1)[secondB] != w.get(0)[first]){
                    move(1, d);
                }
                move(2, -1*d);
            }
            if(w.get(2)[thirdF] != w.get(3)[forth]){
                move(4,-1*d);
            }
            move(3, d);
        }
        if(n == 4){
            if(w.get(3)[forth] != w.get(2)[thirdF]){
                if(w.get(2)[thirdB] != w.get(1)[secondF]){
                    if(w.get(1)[secondB] != w.get(0)[first]){
                        move(1,-1*d);
                    }
                    move(2, d);
                }
                move(3,-1*d);
            }
            move(4,d);
        }
    }

    static void move(int n, int d){
        switch (n){
            case 1: first = (first-d+8)%8; break;
            case 2: {
                secondB = (secondB-d+8)%8;
                secondF = (secondF-d+8)%8;
                break;
            }
            case 3:{
                thirdB = (thirdB-d+8)%8;
                thirdF = (thirdF-d+8)%8;
                break;
            }
            case 4: forth = (forth-d+8)%8; break;
        }
    }
}
