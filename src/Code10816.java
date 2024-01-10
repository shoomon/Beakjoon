import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Code10816 {
    public static void main(String[] args) {
        int n, m, answer;
        ArrayList<Integer> have = new ArrayList<>();
        ArrayList<Integer> find = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


        n = sc.nextInt();
        for(int i = 0;i < n; i++){
            have.add(sc.nextInt());
        }

        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            find.add(sc.nextInt());
        }

        Collections.sort(have);

        for(int i = 0; i < m; i++){
            answer = binarySearchUpper(have, 0, have.size()-1, find.get(i)) - binarySearchLower(have, 0, have.size()-1, find.get(i));
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }

    static int binarySearchUpper(ArrayList<Integer> list, int low, int high, int key){
        int mid;
        while(low <= high){
            mid = (low+high)/2;
            if(list.get(mid) > key){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    static int binarySearchLower(ArrayList<Integer> list, int low, int high, int key){
        int mid;
        while(low <= high){
            mid = (low+high)/2;
            if(list.get(mid) < key){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}
