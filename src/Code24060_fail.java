import java.util.Scanner;

public class Code24060_fail {
    //24060
    static int count = 0, answer;

    public static void main(String[] args) {
        int n, k;
        int[] nums;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        mergeSort(nums, 0, nums.length - 1, k);
        System.out.println(answer);
        sc.close();
    }

    static void mergeSort(int[] list, int left, int right, int key) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(list, left, mid, key);
            mergeSort(list, mid + 1, right, key);
            merge(list, left, mid, right, key);
        }
    }

    static void merge(int[] list, int left, int mid, int right, int key) {
        int indexL, indexR, index;
        int[] arrL = new int[mid - left + 1];
        int[] arrR = new int[right - mid];

        for (int i = 0; i < arrL.length; i++) {
            arrL[i] = list[left + i];
        }
        for (int i = 0; i < arrR.length; i++) {
            arrR[i] = list[mid + 1 + i];
        }

        indexL = 0;
        indexR = 0;
        index = left;
        while (indexL < arrL.length && indexR < arrR.length) {
            if (arrL[indexL] <= arrR[indexR]) {
                list[index++] = arrL[indexL++];
                count++;
                if (count == key) {
                    answer = arrL[indexL - 1];
                }
            } else {
                list[index++] = arrR[indexR++];
                count++;
                if (count == key) {
                    answer = arrR[indexR - 1];
                }
            }
        }

        while (indexL < arrL.length) {
            list[index++] = arrL[indexL++];
            count++;
            if (count == key) {
                answer = arrL[indexL - 1];
            }
        }

        while (indexR < arrR.length) {
            list[index++] = arrR[indexR++];
            count++;
            if (count == key) {
                answer = arrR[indexR - 1];
            }
        }
    }
}
