package task5;

public class Person {
    private String fullName;
    public String position;
    public String email;
    public String phoneNumber;
    public float salary;
    public int age;

    public Person(String fullName, String position, String email, String phoneNumber, float salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInformation(int number){
        System.out.printf("Person №%7$d:%n Full Name:  %1$s%n Position:  %2$s%n email:  %3$s%n Phone number:  %4$s%n Salary:  %5$.0f%n Age:  %6$d%n%n", fullName, position, email, phoneNumber, salary, age, number);
    }

}
