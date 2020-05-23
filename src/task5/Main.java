package task5;

public class Main {

    public static void main(String[] args) {
        doTask();
    }

    public static void doTask(){
        Person[] persArray = new Person[5];

        persArray[0] = new Person("Ivanov Ivan", "Teacher", "ivivan@nemail.ne", "+04325246780", 12000, 25);
        persArray[1] = new Person("Petrov Petr", "Engineer", "pepetr@nemail.ne", "+04326847920", 15200, 43);
        persArray[2] = new Person("Maximov Maxim", "Janitor", "maxmax@nemail.ne", "+06525548902", 480000, 28);
        persArray[3] = new Person("Cepish Vlad", "Director", "vlad@nemail.ne", "+04326660130", 32000, 81);
        persArray[4] = new Person("Sergayev Sergey", "Unemployed", "seserga@nemail.ne", "+06523225881", 13302, 48);

        printPersonList(persArray, 40);

    }

    private static void printPersonList(Person[] persArray,int age) {
        for (int i = 0; i < persArray.length; i++) {
            if(persArray[i].age>=40) persArray[i].printInformation(i);
        }
    }

}
