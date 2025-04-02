package sandbox;

import java.util.*;

// Generic class
class Box<T> {
    private T content;
    
    public Box(T content) {
        this.content = content;
    }
    
    public T getContent() {
        return content;
    }
    
    public void setContent(T content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return "Box containing: " + content;
    }
}

// Class with bounded type parameter
class NumberBox<T extends Number> {
    private T number;
    
    public NumberBox(T number) {
        this.number = number;
    }
    
    public T getNumber() {
        return number;
    }
    
    public double getDoubleValue() {
        return number.doubleValue();
    }
}

public class GenericsDemo {
    public static void main(String[] args) {
        // Using the generic Box class
        System.out.println("===== Generic Box =====");
        Box<String> stringBox = new Box<>("Hello Generics");
        Box<Integer> intBox = new Box<>(123);
        
        System.out.println(stringBox);
        System.out.println(intBox);
        
        // String from box
        String message = stringBox.getContent();
        System.out.println("Message: " + message);
        
        // Using bounded type parameter
        System.out.println("\n===== NumberBox =====");
        NumberBox<Integer> intNumberBox = new NumberBox<>(10);
        NumberBox<Double> doubleNumberBox = new NumberBox<>(10.5);
        
        System.out.println("Integer value: " + intNumberBox.getNumber());
        System.out.println("Double value from Integer box: " + intNumberBox.getDoubleValue());
        System.out.println("Double value: " + doubleNumberBox.getNumber());
        
        // Generic method example
        System.out.println("\n===== Generic Method =====");
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
        System.out.println("Numbers: " + numbers);
        System.out.println("First number > 5: " + findFirst(numbers, n -> n > 5));
        
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println("Words: " + words);
        System.out.println("First word with length > 5: " + findFirst(words, w -> w.length() > 5));
        
        // Wildcard example
        System.out.println("\n===== Wildcards =====");
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        
        System.out.println("Sum of integers: " + sumOfList(intList));
        System.out.println("Sum of doubles: " + sumOfList(doubleList));
    }
    
    // Generic method
    public static <T> T findFirst(List<T> list, Predicate<T> condition) {
        for (T item : list) {
            if (condition.test(item)) {
                return item;
            }
        }
        return null; // Or throw exception
    }
    
    // Method with wildcard
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    // Simple functional interface (similar to java.util.function.Predicate)
    interface Predicate<T> {
        boolean test(T t);
    }
}