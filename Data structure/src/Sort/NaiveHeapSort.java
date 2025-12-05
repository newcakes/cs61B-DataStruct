package Sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.PriorityQueue;

/**
 * 简单的堆排序：通过将要排序的元素依次加入到优先队列（小堆）中，
 * 创建一个返回数组，将元素从小堆删除依次加入到返回数组中
 * 时间复杂度：O(NLogN)
 * 空间复杂度：O(N)
 *
 * @author newcakes
 * @website https://github.com/newcakes
 *
 */
public class NaiveHeapSort {
    private int[] arr;//创建的返回数组
    private PriorityQueue<Integer> pq = new PriorityQueue<>();//使用的优先队列

    //核心代码
    private void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {//依次将待排序元素加入到堆中
            pq.add(arr[i]);
        }
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = pq.poll();//将堆中元素删除并依次加入到返回数组中
        }
    }

    public NaiveHeapSort(int[] arr) {
        this.arr = new int[arr.length];
        sort(arr);
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
        NaiveHeapSort n = new NaiveHeapSort(arr);
        System.out.print("排序后：");
        n.print();
    }
}
