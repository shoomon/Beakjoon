import java.util.Scanner;

public class Code3967_fail {
    static char[][] star = new char [5][9];
    static int[] alphabet = new int[12];
    static int toFill = 12;
    static int callCount = 0;
    static String min ="z";
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s;

        for(int i = 0; i < 5; i++){
            s = sc.nextLine();
            star[i] = s.toCharArray();
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 9; j++){
                if('A' <= star[i][j] && star[i][j] <= 'L'){
                    alphabet[star[i][j]-'A'] = 1;
                    toFill--;
                }
            }
        }

        makeStar(0,0);
//        System.out.println(min);

        char[] c = min.toCharArray();
        int idx = 0;
        for (int j = 0; j < 5 && idx < c.length; j++) {
            for (int k = 0; k < 9; k++) {
                if (star[j][k] == '.') continue;
                star[j][k] = c[idx++];
                if (idx >= c.length) break;
            }
        }


        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
//        System.out.println(callCount);
    }

    static void makeStar(int depth, int r){
//        callCount++;
        String tmp = "";
        if(depth == toFill){
            if(check()){
                for(int i = 0; i < 5; i++){
                    for(int j = 0; j < 9; j++){
                        if('A' <= star[i][j] && star[i][j] <= 'L'){
                            tmp += star[i][j];
                        }
                    }
                }
                min = min.compareTo(tmp)<0? min : tmp;
            }
            return;
        }
        int emptyCount = 0;
        for(int i = r; i < 5; i++){
            for(int j = 0; j < 9; j++){
                if(star[i][j] == 'x'){
                    emptyCount++;
                    for(int k = 0; k < 12; k++){
                        if(alphabet[k] == 0){
                            alphabet[k] = 1;
                            star[i][j] = (char)('A' + k);
                            makeStar(depth + 1, i);
                            star[i][j] = 'x';
                            alphabet[k] = 0;
                        }
                    }
                    break;
                }
            }
            if(emptyCount>0) break;
        }
    }

    static void show() {
        char a = star[0][4];
        char b = star[1][1];
        char c = star[1][3];
        char d = star[1][5];
        char e = star[1][7];
        char f = star[2][2];
        char g = star[2][6];
        char h = star[3][1];
        char i = star[3][3];
        char j = star[3][5];
        char k = star[3][7];
        char l = star[4][4];

        System.out.println(""+a+b+c+d+e+f+g+h+i+j+k+l);
    }

    static boolean check(){
        boolean answer = true;

        int a = star[0][4]-'A'+1;
        int b = star[1][1]-'A'+1;
        int c = star[1][3]-'A'+1;
        int d = star[1][5]-'A'+1;
        int e = star[1][7]-'A'+1;
        int f = star[2][2]-'A'+1;
        int g = star[2][6]-'A'+1;
        int h = star[3][1]-'A'+1;
        int i = star[3][3]-'A'+1;
        int j = star[3][5]-'A'+1;
        int k = star[3][7]-'A'+1;
        int l = star[4][4]-'A'+1;

//        System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g+" "+h+" "+i+" "+j+" "+k+" "+l);

        if(a+c+f+h != 26) answer = false;
        if(b+c+d+e != 26) answer = false;
        if(h+i+j+k != 26) answer = false;
        if(b+f+i+l != 26) answer = false;
        if(e+g+j+l != 26) answer = false;
        if(a+d+g+k != 26) answer = false;

        return answer;
    }
}
