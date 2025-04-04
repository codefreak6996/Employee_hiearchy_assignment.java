// Base class
class Employee {
    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;

    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        setSalary(salary); // Use setter to validate salary
        this.jobTitle = jobTitle;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05; // Default bonus calculation
    }

    public String generatePerformanceReport() {
        return "Performance Report for " + name + " (" + jobTitle + "):\n" +
               "Address: " + address + "\n" +
               "Salary: $" + salary + "\n" +
               "Bonus: $" + calculateBonus();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getName() {  // Added getter for name
        return name;
    }
}

// Subclass for Manager
class Manager extends Employee {
    private String department;

    public Manager(String name, String address, double salary, String jobTitle, String department) {
        super(name, address, salary, jobTitle);
        this.department = department;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10; // Managers get a higher bonus
    }

    public void manageProject(String projectName) {
        System.out.println(getName() + " is managing the project: " + projectName);
    }

    @Override
    public String generatePerformanceReport() {
        return super.generatePerformanceReport() + "\nDepartment: " + department;
    }
}

// Subclass for Developer
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, String address, double salary, String jobTitle, String programmingLanguage) {
        super(name, address, salary, jobTitle);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.07; // Developers get a moderate bonus
    }

    public void developFeature(String featureName) {
        System.out.println(getName() + " is developing the feature: " + featureName);
    }

    @Override
    public String generatePerformanceReport() {
        return super.generatePerformanceReport() + "\nProgramming Language: " + programmingLanguage;
    }
}

// Subclass for Programmer
class Programmer extends Developer {
    private String project;

    public Programmer(String name, String address, double salary, String jobTitle, String programmingLanguage, String project) {
        super(name, address, salary, jobTitle, programmingLanguage);
        this.project = project;
    }

    @Override
    public String generatePerformanceReport() {
        return super.generatePerformanceReport() + "\nCurrent Project: " + project;
    }

    public void code() {
        System.out.println(getName() + " is coding for the project: " + project);
    }
}

// Main class to test the hierarchy
public class Company {
    public static void main(String[] args) {
        Manager manager = new Manager("Abhishek", "UCL Colony", 90000, "Manager", "Sales");
        Developer developer = new Developer("Harshit", "Peptech City", 70000, "Developer", "Java");
        Programmer programmer = new Programmer("Gopal", "Gaushala Chowk", 60000, "Programmer", "Python", "Project AP");

        System.out.println(manager.generatePerformanceReport());
        manager.manageProject("New Sales Strategy");

        System.out.println("\n" + developer.generatePerformanceReport());
        developer.developFeature("User  Authentication");

        System.out.println("\n" + programmer.generatePerformanceReport());
        programmer.code();
    }
}