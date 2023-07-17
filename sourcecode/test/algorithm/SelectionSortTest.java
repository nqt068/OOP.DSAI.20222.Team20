package test.algorithm;

import component.utils.ArrayUtil;
import component.utils.Element;
import algorithm.SelectionSortAlgorithm;
import algorithm.SortingAlgorithm;

import java.util.List;

public class SelectionSortTest {

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

        SortingAlgorithm<Integer> selectionSort = new SelectionSortAlgorithm<>(intArrayUtil);
        selectionSort.sort();
//
//        System.out.println("Sort checking - isSorted: " + selectionSort.isSorted());
//        intArrayUtil.printArray();
//        System.out.println("Number of steps: " + selectionSort.getSteps());
//        System.out.println("Time complexity: " + selectionSort.getTimeComplexity());

        List<ArrayUtil<Integer>> stepsList = selectionSort.sortAndGetSteps();
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

        SortingAlgorithm<String> selectionSort = new SelectionSortAlgorithm<>(stringArrayUtil);
        selectionSort.sort();

        System.out.println("Sort checking - isSorted: " + selectionSort.isSorted());
        stringArrayUtil.printArray();
        System.out.println("Number of steps: " + selectionSort.getSteps());
        System.out.println("Time complexity: " + selectionSort.getTimeComplexity());

        List<ArrayUtil<String>> stepsList = selectionSort.sortAndGetSteps();
        System.out.println(stepsList.toString());
    }

    @SafeVarargs
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> Element<T>[] createArray(Element<T>... elements) {
        return elements;
    }
}
