package Sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 堆排序：把待排序的数组视为最大堆，对其进行堆操作（对最后一个非叶子节点到根节点依次下沉）
 * 依次交换堆的第一个节点和最后一个节点，堆的大小-1
 * 对交换后的堆的第一个元素下沉，重复第二步
 * 时间复杂度：O(NLogN)
 * 空间复杂度:O(1)
 *
 * @author newcakes
 * @website https://github.com/newcakes
 *
 */
public class HeapSort {
    private int[] arr;

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int leftChild(int i) {
        return 2 * (i + 1) - 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    private void shiftDown(int[] arr, int i, int bound) {
        int l = leftChild(i);
        int r = rightChild(i);
        if (l > bound) {
            return;
        }
        if (r > bound) {
            if (arr[l] > arr[i]) {
                swap(arr, l, i);
            }
            return;
        }
        if (arr[l] > arr[r]) {
            if (arr[l] > arr[i]) {
                swap(arr, l, i);
                shiftDown(arr, l, bound);
            }
        } else {
            if (arr[r] > arr[i]) {
                swap(arr, r, i);
                shiftDown(arr, r, bound);
            }
        }
    }

    //核心代码
    private void sort(int[] arr) {
        //找到最后一个非叶子节点，到根节点结束，依次进行下沉操作
        for (int i = arr.length / 2; i >= 0; i--) {
            shiftDown(arr, i, arr.length - 1);
        }
        for (int i = 0, bound = arr.length - 1; i < arr.length; i++, bound--) {
            swap(arr, 0, bound);//最大的值与最后一个值进行交换
            shiftDown(arr, 0, bound - 1);//对交换后的值进行下沉操作。
            //并且堆的大小-1.
        }
    }

    public HeapSort(int[] arr) {
        this.arr = arr;
        sort(arr);
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            int Ranval = StdRandom.uniform(0, arr.length);
            arr[i] = Ranval;
        }
        System.out.print("排序前：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        HeapSort h = new HeapSort(arr);
        System.out.print("排序后：");
        h.print();
    }

}
