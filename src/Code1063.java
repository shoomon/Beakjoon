import java.util.*;
import java.awt.*;
public class Code1063 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        String king = st.nextToken(), stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        Point curKing = new Point(), curStone = new Point();

        curKing.x = king.charAt(0)-'A';
        curKing.y = 8-(king.charAt(1)-'0');

        curStone.x = stone.charAt(0)-'A';
        curStone.y = 8-(stone.charAt(1)-'0');

        for(int i = 0; i < N; i++){
            String command = sc.nextLine();
            Point cur = move(curKing, command);
            Point stn = move(curStone, command);

            if(-1 < cur.x && cur.x < 8 && -1 < cur.y && cur.y < 8){
                if(cur.x == curStone.x && cur.y == curStone.y){
                    if(-1 < stn.x && stn.x < 8 && -1 < stn.y && stn.y < 8){
                        curStone = stn;
                        curKing = cur;
                    }else{
                        continue;
                    }
                }
                curKing = cur;
            }

        }


        int a = curKing.x+'A';
        king = (char)a+"";
        String c = (8-curKing.y)+"";
        king += c;

        a = curStone.x+'A';
        stone = (char)a+"";
        c = (8-curStone.y)+"";
        stone += c;

        System.out.println(king);
        System.out.println(stone);
    }

    static Point move(Point cur, String command){
        Point pos = new Point();

        switch(command){
            case "R" : {
                pos.x = cur.x+1;
                pos.y = cur.y;
                break;
            }
            case "L" : {
                pos.x = cur.x-1;
                pos.y = cur.y;
                break;
            }
            case "B" : {
                pos.x = cur.x;
                pos.y = cur.y+1;
                break;
            }
            case "T" : {
                pos.x = cur.x;
                pos.y = cur.y-1;
                break;
            }
            case "RT" : {
                pos.x = cur.x+1;
                pos.y = cur.y-1;
                break;
            }
            case "LT" : {
                pos.x = cur.x-1;
                pos.y = cur.y-1;
                break;
            }
            case "RB" : {
                pos.x = cur.x+1;
                pos.y = cur.y+1;
                break;
            }
            case "LB" : {
                pos.x = cur.x-1;
                pos.y = cur.y+1;
                break;
            }
        }
        return pos;
    }

}
