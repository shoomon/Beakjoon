import java.util.Scanner;

public class Code10250 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T, H, W, N;
        String s, tmp;

        T = sc.nextInt();
        for(int t = 0; t < T; t++){
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();

            s="";
            tmp="";

            s += N%H;
            if(H == 1){
                tmp += N/H;
            }else{
                tmp += N/H+1;
            }

            if(s.equals("0")){
                s = H+"";
                tmp = N/H+"";
            }
            switch (tmp){
                case "1": tmp = "01"; break;
                case "2": tmp = "02"; break;
                case "3": tmp = "03"; break;
                case "4": tmp = "04"; break;
                case "5": tmp = "05"; break;
                case "6": tmp = "06"; break;
                case "7": tmp = "07"; break;
                case "8": tmp = "08"; break;
                case "9": tmp = "09"; break;
            }
            s += tmp;
            System.out.println(s);
        }

    }
}
