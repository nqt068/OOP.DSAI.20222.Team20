package component.utils;

public class ArrayUtil<T extends Comparable<T>> {
    private Element<T>[] array;

    public ArrayUtil(Element<T>[] array) {
        this.array = array.clone();
    }

    public void swap(int i, int j) {
        Element<T> temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    public void printArray() {
        for (Element<T> element : this.array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public Element<T> getMax() {
        Element<T> max = null;
        for (Element<T> element : this.array) {
            if (max == null || element.getValue().compareTo(max.getValue()) > 0) {
                max = element;
            }
        }
        return max;
    }

    public Element<T> getMin() {
        Element<T> min = null;
        for (Element<T> element : this.array) {
            if (min == null || element.getValue().compareTo(min.getValue()) < 0) {
                min = element;
            }
        }
        return min;
    }
    
    public int size() {
        return this.array.length;
    }
    public Element<T> get(int index) {
        return this.array[index];
    }
    public void set(int index, Element<T> element) {
        this.array[index] = element;
    }
}
