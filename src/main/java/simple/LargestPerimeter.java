package simple;

//给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
//
//        如果不能形成任何面积不为零的三角形，返回 0。
//
//
//
//        示例 1：
//
//        输入：[2,1,2]
//        输出：5
//        示例 2：
//
//        输入：[1,2,1]
//        输出：0
//        示例 3：
//
//        输入：[3,2,3,4]
//        输出：10
//        示例 4：
//
//        输入：[3,6,2,3]
//        输出：8
//
//
//        提示：
//
//        3 <= A.length <= 10000
//        1 <= A[i] <= 10^6
public class LargestPerimeter {
    public static void main(String[] args) {
        LargestPerimeter test = new LargestPerimeter();
        int[] A = new int[]{3,4,15,2,9,4};
        System.out.println(test.largestPerimeter(A));
    }

    public int largestPerimeter(int[] A) {

        int result = 0;

        //先将数组按照从小到大的方式排序（此处可以做性能提升）
        A = bubbleSort(A);

        //从数组最后一位开始，依次取三个数，判断是否能否组成三角形，若能，则返回这三个数之和即最大周长值，若不能则接着向下取，直至遍历完整个数组。
        for (int i = A.length-1; i>=2; i--){
            if (biggerThanASide(A[i],A[i-1],A[i-2]) && smallerThanASide(A[i], A[i-1], A[i-2])) {
                result = A[i]+A[i-1]+A[i-2];
                break;
            }
            else
                continue;
        }

        return result;
    }

    public int[] bubbleSort (int[] A) {
        int length = A.length;
        int temp = 0;

        for (int rounds = 0; rounds < length-1; rounds++ ) {
            for (int times = 0; times < length-1-rounds; times++) {
                if (A[times] > A[times+1]) {
                    temp = A[times+1];
                    A[times+1] = A[times];
                    A[times] = temp;
                }
            }
        }

        return A;
    }

    public boolean biggerThanASide(int a, int b, int c) {
        return ( (a+b)>c && (a+c)>b && (b+c)>a ) ? true:false;
    }

    public boolean smallerThanASide(int a, int b, int c) {
        return ( (a-b)<c && (a-c)<b && (b-c)<a ) ? true:false;
    }
}