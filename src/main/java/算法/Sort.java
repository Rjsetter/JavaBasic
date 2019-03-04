package 算法;

/**
 * 冒泡排序
 */
public class Sort {
    private int [] array;

    public Sort(int[] array) {
        this.array = array;
    }

    //输出排序结果
    public void display(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();//换行
    }
    //Bubble sort
    public void BubbleSort(){
        int temp;//中间值
        int length = array.length;
        for(int i=0;i<length-1;i++) {//外层循环（循环次数为长度减一次）：每次循环就会确认一个最大值
            for (int j = 1; j < length - i; j++) {//内层循环：有i个元素已经排好序，只要对比剩下的元素
                if(array[j-1]>array[j]){//数值小的往上冒
                    temp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
                System.out.print("第"+(i+1)+"轮排序结果：");
                display();
            }
        }
    }
    //选择排序
    public void SelectionSort(){
        //改进方式，每次确认最大值和最小值
        int minIndex;  //储存最小元素的下标
        int length = array.length;
        int temp;  //中间值
        int counter=1;

        for(int i=0;i<length-1;i++){
            minIndex = i;
            for (int j=i+1;j<=length-1;j++){//每完成一轮排序，就确定了一个相对最小元素，下一轮排序只对后面的元素排序
                if(array[j]<array[minIndex]){
                    minIndex = j;  //如果待排数组中的某个元素比当前元素小，minPoint指向该元素的下标
                }
            }
            if(minIndex!=i){  //如果发现了更小的元素，交换位置
                temp= array[i];
                array[i]= array[minIndex];
                array[minIndex]= temp;
            }

            System.out.print("第"+counter+"轮排序结果：");
            display();
            counter++;
        }
    }
    //插入排序
    public void insertionSort(){

        int len = array.length;
        int counter = 1;

        for(int i=1;i<len;i++){

            int temp = array[i];  //存储待排序的元素值
            int insertPoint = i-1;  //与待排序元素值作比较的元素的下标

            while(insertPoint>=0 && array[insertPoint]>temp){ //当前元素比待排序元素大
                array[insertPoint+1]= array[insertPoint];  //当前元素后移一位
                insertPoint--;
            }
            array[insertPoint+1]= temp;  //找到了插入位置，插入待排序元素

            System.out.print("第"+counter+"轮排序结果：");
            display();
            counter++;
        }
    }


    //归并排序
    public void mergeSort(){

        int[] workSpace = new int [array.length]; //用于辅助排序的数组
        recursiveMergeSort(workSpace,0,workSpace.length-1);
    }

    /**
     * 递归的归并排序
     * @param workSpace  辅助排序的数组
     * @param lowerBound 欲归并数组段的最小下标
     * @param upperBound 欲归并数组段的最大下标
     */
    private void recursiveMergeSort(int [] workSpace,int lowerBound,int upperBound){

        if(lowerBound== upperBound){  //该段只有一个元素，不用排序
            return;
        }else{
            int mid = (lowerBound+upperBound)/2;
            recursiveMergeSort(workSpace,lowerBound,mid);    //对低位段归并排序
            recursiveMergeSort(workSpace,mid+1,upperBound);  //对高位段归并排序
            merge(workSpace,lowerBound,mid,upperBound);
            display();
        }
    }

    /**
     * 对数组array中的两段进行合并，lowerBound~mid为低位段，mid+1~upperBound为高位段
     * @param workSpace 辅助归并的数组，容纳归并后的元素
     * @param lowerBound 合并段的起始下标
     * @param mid 合并段的中点下标
     * @param upperBound 合并段的结束下标
     */
    private void merge(int [] workSpace,int lowerBound,int mid,int upperBound){

        int lowBegin = lowerBound;  //低位段的起始下标
        int lowEnd = mid;           //低位段的结束下标
        int highBegin = mid+1;  //高位段的起始下标
        int highEnd = upperBound;  //高位段的结束下标
        int j = 0; //workSpace的下标指针
        int n = upperBound-lowerBound+1;  //归并的元素总数

        while(lowBegin<=lowEnd && highBegin<=highEnd){
            if(array[lowBegin]<array[highBegin]){//将两者较小的那个放到workSpace中
                workSpace[j++]= array[lowBegin++];
            }else{
                workSpace[j++]= array[highBegin++];
            }
        }

        while(lowBegin<=lowEnd){
            workSpace[j++]= array[lowBegin++];
        }

        while(highBegin<=highEnd){
            workSpace[j++]= array[highBegin++];
        }

        for(j=0;j<n;j++){  //将归并好的元素复制到array中
            array[lowerBound++]= workSpace[j];
        }

    }

    //快速排序
    public void quikSort(){
        recursiveQuikSort(0,array.length-1);
    }

    /**
     * 递归的快速排序
     *@param low  数组的最小下标
     *@param high  数组的最大下标
     */
    private void recursiveQuikSort(int low,int high){
        if(low>=high){
            return;
        }else{
            int pivot = array[low];  //以第一个元素为基准
            int partition =partition(low,high,pivot);  //对数组进行划分，比pivot小的元素在低位段，比pivot大的元素在高位段

            recursiveQuikSort(low,partition-1);  //对划分后的低位段进行快速排序
            recursiveQuikSort(partition+1,high);  //对划分后的高位段进行快速排序
        }
    }

    /**
     * 以pivot为基准对下标low到high的数组进行划分
     *@param low 数组段的最小下标
     *@param high 数组段的最大下标
     *@param pivot 划分的基准元素
     *@return 划分完成后基准元素所在位置的下标
     */
    private int partition(int low,int high,int pivot){

        while(low<high){

            while(low<high &&array[high]>=pivot){  //从右端开始扫描，定位到第一个比pivot小的元素
                high--;
            }
            swap(low,high);

            while(low<high &&array[low]<=pivot){  //从左端开始扫描，定位到第一个比pivot大的元素
                low++;
            }
            swap(low,high);

        }
        return low;

    }
    /**
     * 交换数组中两个元素的数据
     *@param low 欲交换元素的低位下标
     *@param high 欲交换元素的高位下标
     */
    private void swap(int low,int high){
        int temp = array[high];
        array[high] = array[low];
        array[low] = temp;
    }

    public static void main(String[] args) {
        int [] a = {1,5,4,11,2,20,18};
        Sort sort = new Sort(a);
        System.out.print("未排序时的结果：");
        sort.quikSort();
        sort.display();

    }

}
