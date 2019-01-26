package simple;

//两数之和
//地址：https://leetcode-cn.com/problems/two-sum/

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
//        示例:
//
//        给定 nums = [2, 7, 11, 15], target = 9
//
//        因为 nums[0] + nums[1] = 2 + 7 = 9
//        所以返回 [0, 1]
public class TwoSum {

    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();

        for ( int i : twoSum.twoSum(new int[]{11,2,7,15}, 9)) {
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] nums, int target) {

        int[] result = null;

        //思路：target减去第一个元素，得到结果后，在剩下的元素中看有没有，有就中断并返回，否则继续下一轮寻找。
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if( (target-nums[i]) == nums[j] ){
                    result = new int[]{i, j};
                    //跳出内层循环
                    break;
                }
            }

            if (result != null)
                break;
        }

        return result;
    }
}
