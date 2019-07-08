import java.util.Arrays;
import java.util.Stack;

/**
 * @Author sunyi
 * @Date: 2019/7/4
 */
public class Sort {
    public static void shellSort(int[] arr){
        int gap = arr.length / 2;
        for (; gap > 0; gap /= 2) {      //不断缩小gap，直到1为止
            for (int j = 0; (j+gap) < arr.length; j++){     //使用当前gap进行组内插入排序
                for(int k = 0; (k+gap)< arr.length; k += gap){
                    if(arr[k] > arr[k+gap]) {
                        int temp = arr[k+gap];      //交换操作
                        arr[k+gap] = arr[k];
                        arr[k] = temp;
                        System.out.println("    Sorting:  " + Arrays.toString(arr));
                    }
                }
            }
        }
    }

    public static void heapSort(int[] arr){
        for(int i = arr.length; i > 0; i--){
            max_heapify(arr, i);

            int temp = arr[0];      //堆顶元素(第一个元素)与Kn交换
            arr[0] = arr[i-1];
            arr[i-1] = temp;
            //System.out.println("array: " + Arrays.toString(arr));
        }
    }

    private static void max_heapify(int[] arr, int limit){
        if(arr.length <= 0 || arr.length < limit) return;
        int parentIdx = limit / 2;

        for(; parentIdx >= 0; parentIdx--){
            if(parentIdx * 2 >= limit){
                continue;
            }
            int left = parentIdx * 2;       //左子节点位置
            int right = (left + 1) >= limit ? left : (left + 1);    //右子节点位置，如果没有右节点，默认为左节点位置

            int maxChildId = arr[left] >= arr[right] ? left : right;
            if(arr[maxChildId] > arr[parentIdx]){   //交换父节点与左右子节点中的最大值
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[maxChildId];
                arr[maxChildId] = temp;
            }
        }
        System.out.println("Max_Heapify: " + Arrays.toString(arr));
    }


    /**
     * 堆排序
     */
    public static void headSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            headAdjust(list, list.length, i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAdjust(list, i, 0);
            System.out.println("Max_Heapify: " + Arrays.toString(list));
        }
    }

    private static void headAdjust(int[] list, int len, int i) {
        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            if (index + 1 < len) {
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            if (list[index] > temp) {
                list[k] = list[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }

        list[k] = temp;
        System.out.println("array: " + Arrays.toString(list));
    }


    public static void quickSortByStack(int[] arr){
        if(arr.length <= 0) return;
        Stack<Integer> stack = new Stack<Integer>();

        //初始状态的左右指针入栈
        stack.push(0);
        stack.push(arr.length - 1);
        while(!stack.isEmpty()){
            int high = stack.pop();     //出栈进行划分
            int low = stack.pop();

            int pivotIdx = partition(arr, low, high);

            //保存中间变量
            if(pivotIdx > low) {
                stack.push(low);
                stack.push(pivotIdx - 1);
            }
            if(pivotIdx < high && pivotIdx >= 0){
                stack.push(pivotIdx + 1);
                stack.push(high);
            }
            System.out.println("array: " + Arrays.toString(arr));
        }
    }

    private static int partition(int[] arr, int low, int high){
        if(arr.length <= 0) return -1;
        if(low >= high) return -1;
        int l = low;
        int r = high;

        int pivot = arr[l];    //挖坑1：保存基准的值
        while(l < r){
            while(l < r && arr[r] >= pivot){  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] <= pivot){   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;   //基准值填补到坑3中，准备分治递归快排
        return l;
    }

    public static int[] mergingSort(int[] arr){
        if(arr.length <= 1) return arr;

        int num = arr.length >> 1;
        int[] leftArr = Arrays.copyOfRange(arr, 0, num);
        int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);
        System.out.println("split two array: " + Arrays.toString(leftArr) + " And " + Arrays.toString(rightArr));
        return mergeTwoArray(mergingSort(leftArr), mergingSort(rightArr));      //不断拆分为最小单元，再排序合并
    }

    private static int[] mergeTwoArray(int[] arr1, int[] arr2){
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length];  //申请额外的空间存储合并之后的数组
        while(i < arr1.length && j < arr2.length){      //选取两个序列中的较小值放入新数组
            if(arr1[i] <= arr2[j]){
                result[k++] = arr1[i++];
            }else{
                result[k++] = arr2[j++];
            }
        }
        while(i < arr1.length){     //序列1中多余的元素移入新数组
            result[k++] = arr1[i++];
        }
        while(j < arr2.length){     //序列2中多余的元素移入新数组
            result[k++] = arr2[j++];
        }
        System.out.println("Merging: " + Arrays.toString(result));
        return result;
    }

    /**
     * 基数排序（LSD 从低位开始）
     *
     * 基数排序适用于：
     *  (1)数据范围较小，建议在小于1000
     *  (2)每个数值都要大于等于0
     *
     * ①. 取得数组中的最大数，并取得位数；
     * ②. arr为原始数组，从最低位开始取每个位组成radix数组；
     * ③. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     * @param arr    待排序数组
     */
    public static void radixSort(int[] arr){
        if(arr.length <= 1) return;

        //取得数组中的最大数，并取得位数
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while(max / 10 > 0){
            maxDigit++;
            max = max / 10;
        }
        System.out.println("maxDigit: " + maxDigit);

        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for(int i = 0; i < maxDigit; i++){
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for(int j = 0; j < arr.length; j++){
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for(int b = 0; b < buckets.length; b++){
                for(int p = 0; p < bktLen[b]; p++){
                    arr[k++] = buckets[b][p];
                }
            }

            System.out.println("Sorting: " + Arrays.toString(arr));
            base *= 10;
        }
    }


    public static void main(String args[]){
        int[] a={1231231,1231213123,12,223,22,11232,344,555,77};
        //int[] a={1,9,8,7,6,5,4,3,2};
        Sort.radixSort(a);
    }
}
