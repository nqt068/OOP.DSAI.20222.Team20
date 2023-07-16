package algorithm;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import component.utils.*;

public abstract class SortingAlgorithm<T extends Comparable<T>> {
    protected ArrayUtil<T> array;
    protected int steps;
    protected long timeComplexity;
    public List<ArrayUtil<T>> stepsList = new ArrayList<>();
    
    public SortingAlgorithm(ArrayUtil<T> array) {
        this.array = array;
    }
    public SortingAlgorithm() {
    	
    }
    
    public abstract void sort();
    
    protected void printArray() {
        for (Element<T> element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    protected boolean lessThan(T a, T b) {
        steps++;
        return a.compareTo(b) < 0;
    }
    
    protected boolean equals(T a, T b) {
        steps++;
        return a.compareTo(b) == 0;
    }
    
    protected boolean greaterThan(T a, T b) {
        steps++;
        return a.compareTo(b) > 0;
    }
    
    protected boolean lessThanOrEqual(T a, T b) {
        steps++;
        return a.compareTo(b) <= 0;
    }
    
    protected boolean greaterThanOrEqual(T a, T b) {
        steps++;
        return a.compareTo(b) >= 0;
    }
    
    public boolean isSorted() {
        for (int i = 1; i < array.size(); i++) {
            if (lessThan(array.get(i).getValue(), array.get(i-1).getValue())) {
                return false;
            }
        }
        return true;
    }
    
    public long getTimeComplexity() {
        return timeComplexity;
    }
    
    public int getSteps() {
        return steps;
    }
    
    public List<ArrayUtil<T>> sortAndGetSteps() {
        return stepsList;
    }
}