package sandbox;

public class HelloJava {
    public static void main(String[] args) {
        System.out.println("Hello, Java World!");
        
        // Basic variable declarations
        int number = 42;
        String text = "Java Programming";
        boolean flag = true;
        
        // Printing variables
        System.out.println("Number: " + number);
        System.out.println("Text: " + text);
        System.out.println("Flag: " + flag);
        
        // Simple conditional
        if (number > 40) {
            System.out.println("Number is greater than 40");
        } else {
            System.out.println("Number is less than or equal to 40");
        }
        
        // Simple loop
        System.out.println("Counting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
    }
}