package Sort;

import edu.princeton.cs.algs4.StdRandom;

public class BasicSort {
    /**
     * 选择排序：找到从i到n的最小的数，与第i个数交换位置，接着从第i+1的元素重复开始此操作
     * 该算法的时间复杂度为O(n^2),十分的低效。
     * 空间复杂度为O(1)
     *
     * @author newcakes
     * @website https://github.com/newcakes
     *
     */
    public class SelectionSort {
        private int[] arr;

        private void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private void sort() {
            for (int i = 0; i < arr.length; i++) {//从i=0的元素开始，到最后一个元素
                int min = i;//选择最小元素的索引
                for (int j = i; j < arr.length; j++) {
                    if (arr[min] > arr[j]) {
                        min = j;//在i到n个元素中找到最小元素的索引
                    }
                }
                swap(i, min);//交换i和min的元素的位置
            }//从i+1个元素开始，重复以上操作
        }

        public SelectionSort(int[] arr) {
            this.arr = arr;
            sort();
        }

        public void print() {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public void main(String[] args) {
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
        SelectionSort s = new SelectionSort(arr);
        System.out.print("排序后：");
        s.print();
    }
}
