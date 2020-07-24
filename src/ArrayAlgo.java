import java.time.LocalDateTime;

/**
 * 数组模块的算法
 *
 * @author Billson
 * @date 2020/7/24 07:07
 */
public class ArrayAlgo {

    /**
     * 寻找数组的中心索引
     * 中心索引定义：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     *
     * @param nums 整型数组，长度范围为 [0, 10000]，任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数
     * @return int
     * @author Billson
     * @date 2020/7/24 7:08 上午
     */
    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    leftSum += nums[j];
                }
            }
            if (i < length - 1) {
                for (int j = i + 1; j < length; j++) {
                    rightSum += nums[j];
                }
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 寻找数组的中心索引优化版
     *
     * @param nums 整型数组
     * @return int
     * @author Billson
     * @date 2020/7/24 13:48
     */
    public static int pivotIndexV2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        // 总和
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // 左边总和
        int sumLeft = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sumLeft += nums[i - 1];
            }
            if (sum - sumLeft - nums[i] == sumLeft) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 正确应该输出 3
        int[] nums = new int[]{2};
        long start1 = System.currentTimeMillis();
        int pivotIndex = pivotIndex(nums);
        long end1 = System.currentTimeMillis();
        System.err.println(pivotIndex + ",耗时：" + (end1 - start1));
        long start2 = System.currentTimeMillis();
        pivotIndex = pivotIndexV2(nums);
        long end2 = System.currentTimeMillis();
        System.err.println(pivotIndex + ",耗时：" + (end2 - start2));
    }
}
