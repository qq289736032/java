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
        //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18
        int[] arr3 = new int[]{1,2,3};
        Integer[][] arrTwo = new Integer[][] {
                {1,2,3,4,5,6,7,8,9},
                {2,3,4,5,6,7,8,9,10},
                {3,4,5,6,7,8,9,10,11},
                {4,5,6,7,8,9,10,11,12},
                {5,6,7,8,9,10,11,12,13},
                {6,7,8,9,10,11,12,13,14},
                {7,8,9,10,11,12,13,14,15},
                {8,9,10,11,12,13,14,15,16},
                {9,10,11,12,13,14,15,16,17}};
        System.out.println(arrTwo.length);
        boolean isfind = find2(7,arrTwo);
        boolean isfind2 = find3(7,arrTwo);
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
    private static boolean find2(Integer num, Integer[][] arr) {
        boolean found = false;
        if(num != null && arr != null){
            int row = arr.length>>1;
            int column = arr[0].length>>1;
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



    public static boolean find3(Integer target,Integer [][] array) {

        for(int i=0;i<array.length;i++){
        int low=0;
        int high=array[i].length-1;
        while(low<=high){
        int mid=(low+high)/2;
        if(target>array[i][mid])
        low=mid+1;
        else if(target<array[i][mid])
        high=mid-1;
        else
        return true;
        }
        }
        return false;
        }

}
