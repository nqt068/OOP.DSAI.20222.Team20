package component.utils;

import java.util.Random;

public class RandomArrayGenerator<T> {
    private Class<T> clazz;

    public RandomArrayGenerator(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T[] generateArray(int n) {
        T[] arr = (T[]) java.lang.reflect.Array.newInstance(clazz, n);

        Random rand = new Random();
        if (clazz == Integer.class) {
            for (int i = 0; i < n; i++) {
                arr[i] = (T) Integer.valueOf(rand.nextInt(100)); // generate random integer between 0 and 99
            }
        } else if (clazz == Double.class) {
            for (int i = 0; i < n; i++) {
                arr[i] = (T) Double.valueOf(rand.nextDouble() * 100); // generate random double between 0 and 99
            }
        } else if (clazz == String.class) {
            for (int i = 0; i < n; i++) {
                byte[] bytes = new byte[5];
                rand.nextBytes(bytes);
                arr[i] = (T) new String(bytes); // generate random string of length 5
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        RandomArrayGenerator<Integer> intArrayGenerator = new RandomArrayGenerator<>(Integer.class);
        Integer[] intArray = intArrayGenerator.generateArray(10);
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();

        RandomArrayGenerator<Double> doubleArrayGenerator = new RandomArrayGenerator<>(Double.class);
        Double[] doubleArray = doubleArrayGenerator.generateArray(10);
        for (int i = 0; i < doubleArray.length; i++) {
            System.out.print(doubleArray[i] + " ");
        }
        System.out.println();

        RandomArrayGenerator<String> stringArrayGenerator = new RandomArrayGenerator<>(String.class);
        String[] stringArray = stringArrayGenerator.generateArray(10);
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i] + " ");
        }
        System.out.println();
    }
}
