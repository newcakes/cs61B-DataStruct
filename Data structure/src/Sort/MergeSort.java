package Sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 归并排序：该排序通过将待排序元素分割为大小为一的元素，此时单个元素排序完成
 * 递归的向上合并，分割的过程中一共分成了logn层
 * 每一层有n个元素，需要O(n)时间
 * 时间复杂度：O(NLogN)
 * 空间复杂度：O(N)
 *
 * @author newcakes
 * @website https://github.com/newcakes
 *
 */
public class MergeSort {
    private List<Integer> ret;
    private int len;

    //核心代码
    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> l = new ArrayList<>();//创建一个返回列表
        if (l1.size() != 1) {//如果l1列表长度不为一，继续分割l1
            //用l1来接收返回排序后的列表
            l1 = merge(l1.subList(0, l1.size() / 2), l1.subList(l1.size() / 2, l1.size()));
        }
        if (l2.size() != 1) {//如果l2列表长度不为一，继续分割l2
            //用l2来接收返回排序后的列表
            l2 = merge(l2.subList(0, l2.size() / 2), l2.subList(l2.size() / 2, l2.size()));
        }
        int i = 0;//设置l1的索引
        int j = 0;//设置l2的索引
        while (l1.size() > i && l2.size() > j) {
            if (l1.get(i) > l2.get(j)) {//如果l1当前元素大于l2当前元素
                l.add(l2.get(j));//将小的l2元素加到l中
                j++;//将l2的索引加一
            } else if (l1.get(i) < l2.get(j)) {//如果l2的当前元素大于l1的当前元素
                l.add(l1.get(i));//将较小的l1元素加入到l中
                i++;//l1的索引加一
            } else {//如果l1的当前元素与l2的当前元素相等，将两个元素同时加入l，两个索引同时加一
                l.add(l1.get(i));
                l.add(l2.get(j));
                i++;
                j++;
            }
        }
        if (i == l1.size()) {//如果l1遍历完成
            while (j != l2.size()) {//将l2的剩余元素加到l中
                l.add(l2.get(j));
                j++;
            }
        }
        if (j == l2.size()) {//如果l2遍历完成
            while (i != l1.size()) {//将l1的剩余元素加到l中
                l.add(l1.get(i));
                i++;
            }
        }
        return l;//返回l
    }

    private void sort() {
        ret = merge(ret.subList(0, len / 2), ret.subList(len / 2, len));
    }

    public MergeSort(int[] arr) {
        len = arr.length;
        ret = Arrays.stream(arr).boxed().toList();
        sort();
    }

    public void print() {
        for (int x : ret) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            int Ranval = StdRandom.uniform(0, arr.length);
            arr[i] = Ranval;
        }
        System.out.print("排序前：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        MergeSort m = new MergeSort(arr);
        System.out.print("排序后：");
        m.print();
    }
}
