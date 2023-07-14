package test.component.utils;
import component.utils.*;

public class ArrayUtilTest {
    public static void main(String[] args) {
        // Create an array of Element<Integer> objects
        Element<Integer>[] integerArray = new Element[]{
                new Element<>(3),
                new Element<>(1),
                new Element<>(4),
                new Element<>(2)
        };

        // Create an ArrayUtil object using the integerArray
        ArrayUtil<Integer> integerArrayUtil = new ArrayUtil<>(integerArray);
        System.out.println(integerArrayUtil.dataType);
        System.out.println(Integer.class);

        // Print the original array
        integerArrayUtil.printArray(); // Output: 3 1 4 2

        // Test the swap method
        integerArrayUtil.swap(1, 3);
        integerArrayUtil.printArray(); // Output: 3 2 4 1

        // Test the set method
        integerArrayUtil.set(1, new Element<>(5));
        integerArrayUtil.printArray(); // Output: 3 5 4 1

        // Test the getMax method
        Element<Integer> maxElement = integerArrayUtil.getMax();
        System.out.println("Max element: " + maxElement); // Output: Max element: 5

        // Test the getMin method
        Element<Integer> minElement = integerArrayUtil.getMin();
        System.out.println("Min element: " + minElement); // Output: Min element: 1
        
        integerArrayUtil.generateRandomArray();
        System.out.println("Array after being randomly regenerated: ");
        integerArrayUtil.printArray();
        
        System.out.println("Create a random array with given length");
        ArrayUtil randomArr = new ArrayUtil(30);
        randomArr.generateRandomArray();
        randomArr.printArray();
    }
}
