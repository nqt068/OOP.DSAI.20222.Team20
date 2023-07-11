package test.utils;
import component.utils.*;

public class ArrayUtilTest {
    public static void main(String[] args) {
    	@SuppressWarnings("unchecked")
    	Element<Integer>[] intArray = (Element<Integer>[]) new Element<?>[] {
    	    new Element<>(5),
    	    new Element<>(3),
    	    new Element<>(7),
    	    new Element<>(1),
    	    new Element<>(9)
    	};
		ArrayUtil<Integer> intArrayUtil = new ArrayUtil<>(intArray);
	
		@SuppressWarnings("unchecked")
		Element<String>[] strArray = new Element[] {
		    new Element<>("apple"),
		    new Element<>("banana"),
		    new Element<>("orange"),
		    new Element<>("pear"),
		    new Element<>("kiwi")
		};
		ArrayUtil<String> strArrayUtil = new ArrayUtil<>(strArray);
		
		Element<Integer> maxInt = intArrayUtil.getMax();
		Element<Integer> minInt = intArrayUtil.getMin();
		System.out.println("Maximum value in integer array: " + maxInt.getValue());
		System.out.println("Minimum value in integer array: " + minInt.getValue());

		Element<String> maxStr = strArrayUtil.getMax();
		Element<String> minStr = strArrayUtil.getMin();
		System.out.println("Maximum value in string array: " + maxStr.getValue());
		System.out.println("Minimum value in string array: " + minStr.getValue());
    }
}
