package test.algorithm;

import component.utils.*;

import java.util.List;

import algorithm.*;


public class MergeSortTest {
    
    public static void main(String[] args) {
        testIntegerSort();
        System.out.println("----------------");
        testStringSort();
    }
    
    private static void testIntegerSort() {
        Element<Integer>[] intArray = createArray(
            new Element<>(5),
            new Element<>(3),
            new Element<>(7),
            new Element<>(1),
            new Element<>(9)
        );
        ArrayUtil<Integer> intArrayUtil = new ArrayUtil<>(intArray);
        intArrayUtil.printArray();
        
        SortingAlgorithm<Integer> mergeSort = new MergeSortAlgorithm<>(intArrayUtil);
        mergeSort.sort();
        
        System.out.println("Sort checking - isSorted: " + mergeSort.isSorted());
        intArrayUtil.printArray();
        System.out.println("Number of steps: " + mergeSort.getSteps());
        System.out.println("Time complexity: " + mergeSort.getTimeComplexity());
        
        List<ArrayUtil<Integer>> stepsList = mergeSort.sortAndGetSteps();
        System.out.println(stepsList.toString());
    }
    
    private static void testStringSort() {
        Element<String>[] stringArray = createArray(
            new Element<>("banana"),
            new Element<>("apple"),
            new Element<>("pear"),
            new Element<>("orange"),
            new Element<>("grape")
        );
        ArrayUtil<String> stringArrayUtil = new ArrayUtil<>(stringArray);
        stringArrayUtil.printArray();
        
        SortingAlgorithm<String> mergeSort = new MergeSortAlgorithm<>(stringArrayUtil);
        mergeSort.sort();
        
        System.out.println("Sort checking - isSorted: " + mergeSort.isSorted());
        stringArrayUtil.printArray();
        System.out.println("Number of steps: " + mergeSort.getSteps());
        System.out.println("Time complexity: " + mergeSort.getTimeComplexity());
        
        List<ArrayUtil<String>> stepsList = mergeSort.sortAndGetSteps();
        System.out.println(stepsList.toString());
    }
    
    @SafeVarargs
	@SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> Element<T>[] createArray(Element<T>... elements) {
        return elements;
    }
}