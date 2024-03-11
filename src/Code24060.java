import java.util.Scanner;

public class Code24060 {
    static int N, K, count=0, answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] list;

        N = sc.nextInt();
        K = sc.nextInt();
        list = new int[N];

        for(int i = 0; i < N; i++){
            list[i] = sc.nextInt();
        }

        mergeSort(list, 0, N-1);
        if(count < K) System.out.println(-1+"");
        else System.out.println(answer+"");

    }

    static void mergeSort(int[] list, int left, int right){
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(list, left, mid);
            mergeSort(list,mid+1, right);
            merge(list, left, mid, right);
        }
    }
    static void merge(int[] list, int left, int mid, int right){
        int i = left, j = mid+1, t = 0;
        int[] temp = new int[right-left+1];

        while(i <= mid && j <= right){
            if(list[i] <= list[j]){
                temp[t++] = list[i++];
            }else{
                temp[t++] = list[j++];
            }
        }

        while(i <= mid){
            temp[t++] = list[i++];
        }
        while(j <= right){
            temp[t++] = list[j++];
        }
        for(int k = left; k <= right; k++){
            list[k] = temp[k-left];
            count++;
            if(count == K) answer = list[k];
        }

    }
}
