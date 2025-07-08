package org.example.chapter07;

class Employee {
    private final String EMPLOYEE_ID;
    private String name;
    private String position;
    private int salary;

    Employee(String EMPLOYEE_ID, String name, String position, int salary){
        this.EMPLOYEE_ID = EMPLOYEE_ID;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    void displayInfo() {
        System.out.println("사원의 ID: " + EMPLOYEE_ID + ", 이름: " + name + ", 직급: " + position
                            + ", 급여: " + salary);
    }
    public void setName(String name) {
        if(name.isEmpty()) {
            setName(this.name);
        } else {
            this.name = name;
        }
    }
    public void setPosition(String position) {
        if(position.isEmpty()) {
            setName(this.position);
        } else {
            this.position = position;
        }
    }
    public void setSalary(int salary) {
        if(salary < 0 ) {
            setSalary(this.salary);
            System.out.println("급여를 " + salary+ "으로 변경을 시도합니다.");
        } else {
            this.salary = salary;
            System.out.println("급여를 " + salary + "으로 변경을 시도합니다.");
        }
    }
    public String getEmployee(){
        return EMPLOYEE_ID;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public int getSalary() {
        return salary;
    }
}
class Manager extends Employee{
    int teamSize;

    Manager(String EMPLOYEE_ID, String name, String position, int salary, int teamSize) {
        super(EMPLOYEE_ID, name, position, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("TeamSize: " + teamSize);
    }
}
public class Z_Review {
    public static void main(String[] args) {
        Employee employee = new Employee("E001", "조성민", "대리", 3500000);
        employee.displayInfo();
        employee.setName("조승범");
        employee.setSalary(-500000);
        employee.displayInfo();

        Manager manager = new Manager("E002", "권민현", "사원", 2500000, 3);
        manager.displayInfo();
    }
}
