package component.utils;
import java.util.ArrayList;
import java.util.List;

public class ArrayUtil<T extends Comparable<T>> extends ArrayList<Element<T>> {
    public ArrayUtil() {
        super();
    }
    
    public ArrayUtil(Element<T>[] array) {
        super();
        for (Element<T> element : array) {
            this.add(element);
        }
    }
    
    public void swap(int i, int j) {
        Element<T> temp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, temp);
    }
    
    public void printArray() {
        for (Element<T> element : this) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public Element<T> getMax() {
        Element<T> max = null;
        for (Element<T> element : this) {
            if (max == null || element.getValue().compareTo(max.getValue()) > 0) {
                max = element;
            }
        }
        return max;
    }
    
    public Element<T> getMin() {
        Element<T> min = null;
        for (Element<T> element : this) {
            if (min == null || element.getValue().compareTo(min.getValue()) < 0) {
                min = element;
            }
        }
        return min;
    }
}
