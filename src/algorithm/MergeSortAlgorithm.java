package algorithm;

import component.utils.*;

public class MergeSortAlgorithm<T extends Comparable<T>> extends SortingAlgorithm<T> {
    
    public MergeSortAlgorithm(ArrayUtil<T> array) {
        super(array);
    }
    
    @Override
    public void sort() {
        mergeSort(0, array.size() - 1);
    }
    
    private void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }
        
        int mid = (high + low) / 2;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        merge(low, mid, high);
    }
    
    private void merge(int low, int mid, int high) {
        Element<T>[] leftArray = new Element[mid - low + 1];
        Element<T>[] rightArray = new Element[high - mid];
        
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array.get(low + i);
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array.get(mid + 1 + i);
        }
        
        int i = 0, j = 0, k = low;
        while (i < leftArray.length && j < rightArray.length) {
            if (lessThanOrEqual(leftArray[i].getValue(), rightArray[j].getValue())) {
            	array.set(k++, leftArray[i++]);
            } else {
                array.set(k++, rightArray[j++]);
            }
        }
        
        while (i < leftArray.length) {
            array.set(k++, leftArray[i++]);
        }
        
        while (j < rightArray.length) {
            array.set(k++, rightArray[j++]);
        }
    }
    
    @Override
    public long getTimeComplexity() {
        return (long) array.size() * (long) Math.log(array.size());
    }
}