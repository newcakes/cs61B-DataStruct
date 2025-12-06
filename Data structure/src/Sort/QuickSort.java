package Sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 快速排序：通过将待排序的元素选择一个基准值（一般选首个元素）进行分区，
 * 将一个大问题分为两个小问题，
 * 再对这两个小问题采用相同的方式进行操作。
 *
 * 时间复杂度：O(N^2),一般平均时间的复杂度是O(NLogN)
 * 空间复杂度：O(LogN)
 *
 */
public class QuickSort {
    private int[] ret;

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //核心代码
    private int partition(int[] arr, int left, int right) {
        int base = left;//将数组的第一个值作为基准值
        int index = left + 1;//指向第一个大于或等于基准值的元素索引
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[base]) {//如果该元素小于基准值
                swap(arr, i, index);//交换该元素与索引为index的元素
                index++;//index加一，继续指向第一个大于或等于基准值的元素索引
            }
        }
        swap(arr, base, index - 1);//交换基准值和最后一个小于基准值的元素
        return index - 1;//返回基准值的索引
    }

    //核心代码
    private void sortHelp(int[] arr, int left, int right) {//利用基准值将数组分割
        if (left < right) {//只处理长度大于一的数组
            int base = partition(arr, left, right);//将数组按照基准值分为两部分，返回基准值索引
            sortHelp(arr, left, base - 1);//按相同操作处理基准值左边的数组
            sortHelp(arr, base + 1, right);//按相同操作处理基准值右边的数组
        }
    }

    private void sort() {
        sortHelp(ret, 0, ret.length - 1);
    }

    public QuickSort(int[] arr) {
        ret = arr;
        sort();
    }

    public void print() {
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            int Ranval = StdRandom.uniform(0, arr.length);
            arr[i] = Ranval;
        }
        System.out.print("排序前：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        QuickSort q = new QuickSort(arr);
        System.out.print("排序后：");
        q.print();
    }

}
