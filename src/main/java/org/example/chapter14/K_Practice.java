package org.example.chapter14;

// == 직원 관리 시스템 ==

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 직원 데이터 정의
@AllArgsConstructor // @Setter 역할
@Getter
@ToString
class Employee {
    private String department;
    private String name;
    private int salary;
}

public class K_Practice {
    public static void main(String[] args) {
        List<Employee> emloyees = Arrays.asList(
                new Employee("IT", "이승아", 300),
                new Employee("HR", "조승범", 500),
                new Employee("IT", "김준일", 400),
                new Employee("OP", "전예찬", 350),
                new Employee("HR", "윤대휘", 380)
        );
//        1)
        List<Employee> filteredEmployee = emloyees.stream()
                .filter(e -> e.getSalary() >= 400)
                .collect(Collectors.toList());

        System.out.println("급여가 400 이상인 직원");
        filteredEmployee.forEach(System.out::println);

//        2)
        List<String> employeeNames = emloyees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\n부서가 'IT' 인 직원");
        System.out.println(employeeNames);

//        3)
        List<Employee> filteredDepartmentName = emloyees.stream()
                .filter(e -> e.getDepartment().equals("HR"))
                .filter(e->e.getName().contains("조"))
                .collect(Collectors.toList());

        System.out.println("\n'HR' 부서 직원 중 '조' 가 포함된 직원");
        filteredDepartmentName.forEach(System.out::println);
        System.out.println();

        Map<String, List<Employee>> filteredDepartment = emloyees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        filteredDepartment.forEach((department, group) -> {
//            List<String> employeeName = group.stream().map(Employee::getName).collect(Collectors.toList());
//            System.out.println("부서" + department + " | 직원: " + employeeName);

//            for(Map.Entry<String, List<Employee>> entry: filteredDepartment.entrySet()) {
//                String department1 = entry.getKey();
//                List<Employee> employeeInDept = entry.getValue();
//
//                System.out.println(department1 + ": ");
//                for(Employee employee: employeeInDept) {
//                    System.out.println(employee.getName() + " ");
//                }
//                System.out.println();
//            }
            String name = group.stream()
                    .map(Employee::getName)
                    .collect(Collectors.joining(" "));

            System.out.println(department + " | " + name);
        });

//        5) 부서별(그룹화) 평균 급여 계산
//        Collectors 클래스 - groupingBy
//                         - averaging 타입: 해당 타입의 평균을 계산 (averagingInt(각 직원의 급여 전달))
        Map<String, Double> avgSalaryByDept = emloyees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));

        System.out.println(avgSalaryByDept);

    }
}
