import java.util.Scanner;

public class Code1076 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        String c = sc.next();

        int num = switchStr(a)*10+switchStr(b);
        int e = switchStr(c);

        System.out.println(num*(long)Math.pow(10,e));
    }

    static int switchStr(String str){
        if(str.equals("black")){
            return 0;
        }else if(str.equals("brown")){
            return 1;
        }else if(str.equals("red")){
            return 2;
        }else if(str.equals("orange")){
            return 3;
        }else if(str.equals("yellow")){
            return 4;
        }else if(str.equals("green")){
            return 5;
        }else if(str.equals("blue")){
            return 6;
        }else if(str.equals("violet")){
            return 7;
        }else if(str.equals("grey")){
            return 8;
        }else if(str.equals("white")){
            return 9;
        }
        return -1;
    }
}
