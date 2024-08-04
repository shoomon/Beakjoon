import java.util.*;
public class Code1543 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
        char[] dic = s.toCharArray();
        s = sc.nextLine();
        char[] word = s.toCharArray();
        int idx = 0, count=0;

        while(idx <= dic.length - word.length){
            String tmp = "";
            String w = "";
            for(int i = 0; i < word.length; i++){
//                tmp.concat(dic[idx+i]+"");
                tmp += dic[idx+i]+"";
            }
            for(char c : word){
//                w.concat(c+"");
                w += c+"";
            }
//            System.out.println("idx: " + idx + " tmp: "+ tmp + " w: "+ w);
            if(tmp.equals(w)){
                count++;
                idx += word.length;
            }else{
                idx++;
            }
        }

        System.out.println(count);

    }
}
