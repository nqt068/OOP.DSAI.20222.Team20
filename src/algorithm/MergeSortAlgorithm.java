package algorithm;

import component.utils.ArrayUtil;
import component.utils.Element;


public class MergeSortAlgorithm<T extends Comparable<T>> extends SortingAlgorithm<T> {

    public MergeSortAlgorithm(ArrayUtil<T> array) {
        super(array);
    }

    @Override
    public void sort() {
    	stepsList.add(array.clone());
        mergeSort(0, array.size() - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayUtil<T> leftArray = new ArrayUtil<T>(n1);
        ArrayUtil<T> rightArray = new ArrayUtil<T>(n2);

        for (int i = 0; i < n1; i++) {
            leftArray.set(i, array.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.set(j, array.get(mid + 1 + j));
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (lessThanOrEqual(leftArray.get(i).getValue(), rightArray.get(j).getValue())) {
                array.set(k, leftArray.get(i));
                i++;
            } else {
                array.set(k, rightArray.get(j));
                j++;
            }
            stepsList.add(array.clone());
            k++;
        }

        while (i < n1) {
            array.set(k, leftArray.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            array.set(k, rightArray.get(j));
            j++;
            k++;
        }
        //stepsList.add(array); 
    }
    
    @Override
    public long getTimeComplexity() {
        return (long) array.size() * (long) Math.log(array.size());
    }
}
