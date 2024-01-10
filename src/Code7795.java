//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.util.Scanner;

public class Code7795 {
    public static void main(String[] args) {
        int t, anum, bnum, count;
        int[] a, b;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        //Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            count = 0;

            anum = sc.nextInt();
            bnum = sc.nextInt();
            a = new int[anum];
            b = new int[bnum];


            for (int j = 0; j < anum; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < bnum; j++) {
                b[j] = sc.nextInt();
            }

            mergeSort(b, 0, b.length - 1);
            for (int j = 0; j < anum; j++) {
                count += binarySearch(b, 0, b.length - 1, a[j]);
            }

            System.out.println(count);
        }
        sc.close();
    }

    static void mergeSort(int[] list, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    static void merge(int[] list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = list[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = list[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                list[k] = leftArray[i];
                i++;
            } else {
                list[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            list[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            list[k] = rightArray[j];
            j++;
            k++;
        }
    }

    static int binarySearch(int[] list, int low, int high, int key) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (list[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
