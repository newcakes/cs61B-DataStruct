package Sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 插入排序：从待排序的元素起始位置依次向后遍历，如果当前元素小于前一个元素
 * 依次与前一个元素交换位置，直到索引为0或当前元素大于前一个元素
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(N)
 *
 * @author newcakes
 * @website https://github.com/newcakes
 *
 */
public class InsertionSort {
    private int[] ret;

    private void swap(int i, int j) {
        int temp = ret[i];
        ret[i] = ret[j];
        ret[j] = temp;
    }

    //核心代码
    private void sort() {
        for (int i = 0; i < ret.length; i++) {//从起始位置依次向后遍历
            int j = i;//设置j为当前索引
            while (j - 1 >= 0 && ret[j] < ret[j - 1]) {//如果索引j大于0，且索引j的前一个元素大于索引j元素
                swap(j, j - 1);//交换这两个元素
                j--;//索引减一，向前遍历，直到条件不满足
            }
        }
    }

    public InsertionSort(int[] arr) {
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
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int Ranval = StdRandom.uniform(0, 100);
            arr[i] = Ranval;
        }
        System.out.print("排序前：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        InsertionSort i = new InsertionSort(arr);
        System.out.print("排序后：");
        i.print();
    }
}
