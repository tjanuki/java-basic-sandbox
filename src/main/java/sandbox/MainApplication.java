package sandbox;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("====== Java Sandbox Demo ======");
        
        // Person and Employee demonstration
        System.out.println("\n===== Person & Employee Classes =====");
        Person person = new Person("John", 25);
        person.introduce();
        
        Employee employee = new Employee("Jane", 30, "Software Engineer", 80000);
        employee.introduce(); // Polymorphism
        employee.work();
        
        // Static factory method
        Person adult = Person.createAdult("Mark");
        adult.introduce();
        
        // Shape interface demonstration
        System.out.println("\n===== Shape Interface =====");
        Circle circle = new Circle(5.0);
        circle.printInfo();
        
        // You can run the collection and generics demos separately
        System.out.println("\nTo see collections examples, run: java -cp target/classes sandbox.CollectionsDemo");
        System.out.println("To see generics examples, run: java -cp target/classes sandbox.GenericsDemo");
    }
}