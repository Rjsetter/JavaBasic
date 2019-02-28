package 数据结构之数组;

/**
 * 有序数组
 */
public class OrderArray {
    private int [] intArray;
    private int length; //数组元素个数

    //构造方法
    public OrderArray(int max) {
        intArray = new int[max];
    }
    // 用二分查找法定位某个元素，如果存在返回其下标，不存在则返回-1
    public int binarySearch(int target){
        int lowerIndex = 0;//搜索段最小元素下标
        int upperIndex = length-1;//搜索段最大元素下标
    }
}
