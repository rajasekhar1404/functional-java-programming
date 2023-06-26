package com.functional;

import java.util.*;
import java.util.stream.Collectors;

import com.functional.modal.Employee;

public class StreamAPIExamples {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("59-385-1088","Zacharias","Schwerin","zchwerin@gmail.com","Male","True",101146,0),
                new Employee("73-274-6476","Kyle","Frudd","kfrudd1@ovh.net","Male","FALSE",29310,2),
                new Employee("85-939-9584","Axe","Gumb","agumb2@twitter.com","Female","FALSE",62291,4),
                new Employee("08-180-8292","Robinet","Batterham","rbatterham3@last.fm","Male","FALSE",142439,4),
                new Employee("21-825-2623","Ulick","Burrel","uburrel4@google.ru","Male","FALSE",128764,5),
                new Employee("66-708-5539","Tailor","Ridding","Ridding","Female","FALSE",152924,4),
                new Employee("81-697-2363","Joete","Braybrooke","jbraybrooke6@prnewswire.com","Male","TRUE",128907,0),
                new Employee("63-019-1110","Elroy","Baverstock","ebaverstock7@ehow.com","Male","TRUE",2510,0)
        );

        // Females
        employees.stream().filter(emp -> "Female".equals(emp.getGender()));
//                .forEach(System.out::println);

        // New joined
        employees.stream().filter(emp -> "TRUE".equals(emp.getNewJoiner()));
//                .forEach(System.out::println);

        // Sored by rating
        employees.stream().sorted(Comparator.comparing(Employee::getRating));
//                .forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(Employee::getRating).reversed());
//                .forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(Employee::getRating)
                .thenComparing(Employee::getSalary));
//                .forEach(System.out::println);

        employees.stream().anyMatch(emp -> emp.getSalary() > 1000);

        Optional<Employee> max = employees.stream().max(Comparator.comparing(Employee::getSalary));
//        System.out.println(max.get());

        Optional<Employee> max1 = employees.stream().sorted(Comparator.comparing(Employee::getSalary))
                .max(Comparator.comparing(Employee::getRating));
//        System.out.println(max1.get());

        Employee employee = employees.stream().min(Comparator.comparing(Employee::getSalary)).get();
//        System.out.println(employee);

        employees.stream().collect(Collectors.groupingBy(Employee::getGender));
//                .forEach((key, value) -> System.out.println(key + " | " + value));

    }
}
