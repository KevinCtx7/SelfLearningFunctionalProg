import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class JavaStreamChallenge1 {
    static class Person {
        public final String name;
        public final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Car {
        public final String make;
        public final String color;
        public final Float price;

        public Car(String make, String color, Float price) {
            this.make = make;
            this.color = color;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "make='" + make + '\'' +
                    ", color='" + color + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Person[] peopleArr = {
                new Person("Brandon", 23),
                new Person("Hank", 43),
                new Person("Jenna", 33),
                new Person("Veronica", 56),
                new Person("Jack", 27),
        };
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArr));

        // Answer 1 goes here - get a list that contains all the people's name
        List<String> peopleNames = people.stream().map(p->p.name).collect(Collectors.toList());
        System.out.println(peopleNames);


        Car[] carsArr = {
                new Car("Chevy", "red", 45000f),
                new Car("Ford", "blue", 23000f),
                new Car("Toyota", "grey", 14000f),
                new Car("Lamborghini", "blue", 150000f),
                new Car("Renault", "blue", 150000f),
        };
        List<Car> cars = new ArrayList<>(Arrays.asList(carsArr));

        // Answer 2 goes here - return only blue cars
        List<Car> blueCars = cars.stream().filter(car->car.color.equals("blue")).collect(Collectors.toList());
        System.out.println(blueCars);



        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));
        // Answer 3 goes here - sum all salaries
        Float sum = employees.stream().map(e->e.salary).reduce(0f,(acc,salary)->acc+salary);
        System.out.println(sum);

    }
}
