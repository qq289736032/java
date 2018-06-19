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
        /**
         * 数组的命名
         */
        int[] arr = new int[3];
        arr[0] = 1;

        int[] arr2 = {1,2};

        int[] arr3 = new int[]{1,2,3};
        Integer[][] arrTwo = new Integer[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(arrTwo.length);
        boolean isfind = find(7,new Integer[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}});
        System.out.println(isfind);

    }

    private static boolean find(Integer num, Integer[][] arr) {
        boolean found = false;
        if(num != null && arr != null){
            int row = 0;
           int column = arr[0].length-1;
            while(row<arr.length&&column>=0){
                if(arr[row][column]==num){
                    found = true;
                    break;
                }else if(arr[row][column]>num){
                    --column;
                }else
                    row++;
            }
        }
        return found;
    }
}
