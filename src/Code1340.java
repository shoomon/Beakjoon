//25.02.11
//1시간 = 60분, 하루 = 1440분
import java.util.*;

public class Code1340 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double cur=0, total=0;
        String[] curTime = sc.nextLine().split(" ");

        int year = Integer.parseInt(curTime[2]);
        int day = Integer.parseInt(curTime[1].substring(0,2));
        int hour = Integer.parseInt(curTime[3].split(":")[0]);
        int min = Integer.parseInt(curTime[3].split(":")[1]);

//        System.out.println(year+" "+day+" "+hour+" "+min);

        total = 525600;
        if((year%100 != 0 && year%4 == 0) || (year%400 == 0)) {
            total += 1440;
            if(!"January".equals(curTime[0]) && !"February".equals(curTime[0])) cur += 1440;
        }

        switch(curTime[0]){
            case "December":
                cur += 30*1440;
            case "November":
                cur += 31*1440;
            case "October":
                cur += 30*1440;
            case "September":
                cur += 31*1440;
            case "August":
                cur += 31*1440;
            case "July":
                cur += 30*1440;
            case "June":
                cur += 31*1440;
            case "May":
                cur += 30*1440;
            case "April":
                cur += 31*1440;
            case "March":
                cur += 28*1440;
            case "February":
                cur += 31*1440;
            case "January":
                cur += (day-1)*1440 + hour*60 + min;
        }
//        System.out.println(total+" "+cur);
        System.out.println((cur/total)*100);
    }
}
