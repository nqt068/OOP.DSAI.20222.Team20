package component.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ArrayUtil<T extends Comparable<T>> implements Iterable<Element<T>>{
	protected Element<T>[] array;
    public Class<T> dataType;

    @SuppressWarnings("unchecked")
	public ArrayUtil(Element<T>[] array) {
        this.array = array.clone();
        this.dataType = (Class<T>) array[0].getValue().getClass();
    }
    @SuppressWarnings("unchecked")
	public ArrayUtil(int n) {
    	this.array = (Element<T>[]) new Element<?>[n];
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
    
    public ArrayUtil<T> clone() {
    	return new ArrayUtil<T>(array.clone());
    }
    
    public int min(int a, int b) { 
    	if (a <= b) {
    		return a;
    	}
    	else {
    		return b;
    	}
    }
        
    public void set(int index, Element<T> element) {
        this.array[index] = element;
    }
    

	@Override
	public Iterator<Element<T>> iterator() {
		return new ArrayUtilIterator();
	}
	
    private class ArrayUtilIterator implements Iterator<Element<T>> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < array.length;
        }

        @Override
        public Element<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex++];
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    @SuppressWarnings("unchecked")
	public void generateRandomArray() {
    	Random rand = new Random();
    	if (dataType == Integer.class) {
            for (int i = 0; i < this.size(); i++) {
                array[i] = new Element<T>((T)Integer.valueOf(rand.nextInt(100)));
            }
    	} else if (dataType == Double.class) {
            for (int i = 0; i < this.size(); i++) {
                array[i] = new Element<T>((T) Double.valueOf(rand.nextDouble() * 100));
            }
    	} else if (dataType == String.class) {
            for (int i = 0; i < this.size(); i++) {
                byte[] bytes = new byte[5];
                rand.nextBytes(bytes);
                array[i] = new Element<T>((T) new String(bytes));
            }
    	} else { // just let it be integers :v
//    		for (int i = 0; i < this.size(); i++) {
//                array[i] = new Element<T>((T)Integer.valueOf(rand.nextInt(100)));
//            }
    	}
    }
}

