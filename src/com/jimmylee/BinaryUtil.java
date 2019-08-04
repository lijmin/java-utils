/**
 * 二进制工具类
 */
public class BinaryUtil {
    /**
     * 将数组的每一个数字拼接成二进制数，然后输出十进制。
     * 例: {1,0,1,0,1} => 21
     *
     * @param arr 数组
     * @return 十进制数，如果数组含有非0或1的数字，返回-1。
     */
    public static int array2int(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 0) {
                return -1;
            }
            num += arr[i] << (arr.length - i - 1);
        }
        return num;
    }

    /**
     * int数字转为二进制数组
     * 例：21 => {1,0,1,0,1}
     *
     * @param num 大于0的数字
     * @param length 数组长度
     * @return 如果小于0，返回null。
     */
    public static int[] int2array(int num, int length) {
        if(num < 0){
            return null;
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = num >>> (length - i - 1) & 1;
        }

        return arr;
    }


}
