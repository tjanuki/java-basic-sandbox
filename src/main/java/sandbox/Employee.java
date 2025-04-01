package sandbox;

// Class demonstrating inheritance
public class Employee extends Person {
    private String jobTitle;
    private double salary;
    
    // Constructor
    public Employee(String name, int age, String jobTitle, double salary) {
        super(name, age); // Call to parent constructor
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
    
    // Getters and setters
    public String getJobTitle() {
        return jobTitle;
    }
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }
    
    // Method overriding - polymorphism
    @Override
    public void introduce() {
        System.out.println("Hello, my name is " + getName() + ", I am " + getAge() + 
                           " years old, and I work as a " + jobTitle + ".");
    }
    
    // New method
    public void work() {
        System.out.println(getName() + " is working as a " + jobTitle + ".");
    }
}