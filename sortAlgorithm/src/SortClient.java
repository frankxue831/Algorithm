public class SortClient {

    public int[] bubbleSort(int[] arr) {
        if (arr.length < 2) return arr;
        // n - 1轮次执行，当前 n - 1 个元素排好后，最后一个元素无需执行，故i < arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            // 本轮执行是否有交换的标志，若无则false，若有则true
            boolean swapped = false;
            // 每轮循环，通过依次向右比较两个数，将本轮循环中最大的数放到最右
            for (int j = 1; j < arr.length - i; j++) {
                // 若左大于右则交换，并将swapped置为true
                if (arr[j - 1] > arr[j]) {
                    SwapClient.swap(arr, j - 1, j);
                    swapped = true;
                }
            }
            // 若无交换，表示当前数组已完全排序，退出大循环
            if (!swapped) break;
        }
        return arr;
    }

    public int[] selectSort(int[] arr) {
        if (arr.length < 2) return arr;
        // n - 1 轮次执行,当前 n - 1 个元素排好后，最后一个元素无需执行，故 i < arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            // 找到本轮执行中最小的元素，将最小值下标赋值给min
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx])  minIdx = j;
            }
            // 若本轮第一个数字不是最小值，则交换位置
            if (minIdx != i) {
                SwapClient.swap(arr, i, minIdx);
            }
        }
        return arr;
    }

    public int[] insertSort(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length;
        for (int i = 1; i < n; i++) { // n - 1轮次执行
            int target = arr[i], j = i - 1;
            for (j = i - 1; j >= 0; j--) {
                if(target < arr[j]) arr[j + 1] = arr[j];
                else break;
            }
            // j变动表示发生了移动，此时的插入对象数字 ≥ j位置的数字，故插入位置为j + 1
            if (j != i - 1) arr[j + 1] = target;
        }
        return arr;
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
        if(left < right) {
            int center = left + (right - left) / 2;
            mergeSort(arr, tmpArr, left, center);
            mergeSort(arr, tmpArr, center + 1, right);
            merge(arr, tmpArr, left, center, right);
        }
    }

    // 非原地合并方法
    private void merge(int[] arr, int[] tmpArr, int leftPos, int leftEnd, int rightEnd) {
        int rightPos = leftEnd + 1;
        int startIdx = leftPos;
        int tmpPos = leftPos;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos]) {
                tmpArr[tmpPos++] = arr[leftPos++];
            }
            else {
                tmpArr[tmpPos++] = arr[rightPos++];
            }
        }
        // 比较完成后若左数组还有剩余，则将其添加到tmpArr剩余空间
        while (leftPos <= leftEnd) {
            tmpArr[tmpPos++] = arr[leftPos++];
        }
        // 比较完成后若右数组还有剩余，则将其添加到tmpArr剩余空间
        while (rightPos <= rightEnd) {
            tmpArr[tmpPos++] = arr[rightPos++];
        }
        // 容易遗漏的步骤，将tmpArr拷回arr中
        // 从小区间排序到大区间排序，大区间包含原来的小区间，需要从arr再对应比较排序到tmpArr中，
        // 所以arr也需要动态更新为排序状态，即随时将tmpArr拷回到arr中
        for(int i = startIdx; i <= rightEnd; i++) {
            arr[i] = tmpArr[i];
        }
    }

    // 三数取中快排
    public int[] quickSortMedian3(int[] arr) {
        if (arr.length < 2) return arr;
        quickSortMedian3(arr, 0, arr.length - 1); // 后两个参数是下标值
        return arr;
    }

    private void quickSortMedian3(int[] arr, int left, int right) {
        if (left < right) {
            // 执行median3将左，中，右三数中值放到left位置上
            median3(arr, left, right);
            int pivot = partition(arr, left, right);
            quickSortMedian3(arr, left, pivot - 1);
            quickSortMedian3(arr, pivot + 1, right);
        }
    }


    // 将left, center, right下标三个数中，大小居中者放到left下标处
    private void median3(int[]arr, int l, int r) {
        int c = l + (r - l) / 2;
        if (arr[l] > arr[c]) SwapClient.swap(arr, l, c); // 左中，大者居中
        if (arr[c] > arr[r]) SwapClient.swap(arr, c, r); // 中右，大者居右，此时最大者居右
        if (arr[c] > arr[l]) SwapClient.swap(arr, l, c); // 左中，大者居左，此时中者居左
    }

    // 朴素快排(首位为主轴)
    public int[] quickSortSimple(int[] arr) {
        if (arr.length < 2) return arr;
        quickSortSimple(arr, 0, arr.length - 1); // 后两个参数是下标值
        return arr;
    }

    private void quickSortSimple(int[] arr, int left, int right) {
        // 若left == right，表示此时arr只有一个元素，即为基准情形，完成递归(准确说是完成递进)
        // (尾递归，“回归”过程中不做任何事情）
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSortSimple(arr, left, pivot - 1);
            quickSortSimple(arr, pivot + 1, right);
        }
    }

    //　partition方法
    private int partition(int[] arr, int left, int right) {
        int pivot = left, index = pivot + 1;
        // 注意此时right是坐标，要执行到最后一个元素，所以是<=
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                SwapClient.swap(arr, index, i);
                index++;
            }
        }
        // 最后一个小于主轴元素的元素下标是index - 1
        SwapClient.swap(arr, pivot, index - 1);
        return index - 1;
    }








}
