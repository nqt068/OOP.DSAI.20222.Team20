package component.utils;

public class Element<T> {
    private T value;
    
    public Element(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
}