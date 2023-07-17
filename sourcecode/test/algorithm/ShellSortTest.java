package test.algorithm;

import java.util.List;

import algorithm.ShellSortAlgorithm;
import algorithm.SortingAlgorithm;
import component.utils.ArrayUtil;
import component.utils.Element;

public class ShellSortTest {
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
        
		int[] gaps = {5,3,1};
        
        SortingAlgorithm<Integer> shellSort = new ShellSortAlgorithm<>(gaps, intArrayUtil);
        shellSort.sort();
        
        System.out.println("Sort checking - isSorted: " + shellSort.isSorted());
        intArrayUtil.printArray();
        System.out.println("Number of steps: " + shellSort.getSteps());
        System.out.println("Time complexity: " + shellSort.getTimeComplexity());
        
        List<ArrayUtil<Integer>> stepsList = shellSort.sortAndGetSteps();
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
        
        int[] gaps = {5,3,1};
        
        SortingAlgorithm<String> shellSort = new ShellSortAlgorithm<>(gaps, stringArrayUtil);
        shellSort.sort();
        
        System.out.println("Sort checking - isSorted: " + shellSort.isSorted());
        stringArrayUtil.printArray();
        System.out.println("Number of steps: " + shellSort.getSteps());
        System.out.println("Time complexity: " + shellSort.getTimeComplexity());
        
        List<ArrayUtil<String>> stepsList = shellSort.sortAndGetSteps();
        System.out.println(stepsList.toString());
    }
    
    @SafeVarargs
	@SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> Element<T>[] createArray(Element<T>... elements) {
        return elements;
    }
}

