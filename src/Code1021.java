import java.util.Scanner;
public class Code1021 {
    public static void main(String[] args){
        int n, m, front = 0, size, minRotation, answer = 0;
        int[] toFind;
        boolean[] queueData;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        size = n;
        queueData = new boolean[n];
        toFind = new int[m];
        for(int i = 0; i < m; i++){
            toFind[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++){
            minRotation = Math.min(countValue(queueData, (toFind[i]-1+n)%n, front), countValue(queueData, front, (toFind[i]-1+n)%n));
            front = (toFind[i]-1+n)%n;
            queueData[front] = true;
            size--;
            if(size > 0){
                while(queueData[front]){
                    front++;
                    front %= n;
                }
            }

            answer += minRotation;
        }

        System.out.println(answer);
        sc.close();
    }

    static int countValue(boolean[] list, int start, int end){
        int count = 0, i = start;

        while (i % list.length != end){
            if(!list[i % list.length]){
                count++;
            }
            i++;
        }
        return count;
    }
}
