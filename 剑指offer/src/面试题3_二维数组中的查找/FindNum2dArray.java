package 面试题3_二维数组中的查找;

/**
 * Created by jisen on 2018/6/5.
 */

/**
 * 在一个二维数组中,每一行都是按照从左到右递增的顺序排序,每一列都是从上到下递增的顺序排序,
 * 请完成一个函数,输入这样的一个二维数组和整数,判断数组是否含有该整数.
 */


public class FindNum2dArray {
    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 1;

        int[] arr2 = {1,2};

        int[] arr3 = new int[]{1,2,3};

        boolean isfind = find(3,new int[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}});
    }

    private static boolean find(int num, int[][] arr) {
        boolean found = false;

        return true;
    }
}
