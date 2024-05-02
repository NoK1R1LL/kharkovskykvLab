package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Employee {
    private String employeeId;
    private String fullName;
    private Date dateOfBirth;
    private String position;
    private BankOffice worksAtOffice; // Изменение типа переменной на BankOffice
    private boolean isOfficeEmployee;
    private BankOffice office;
    private boolean canIssueCredits;
    private double salary;

    public Employee(String employeeId, String fullName, Date dateOfBirth, String position, BankOffice worksAtOffice, boolean isOfficeEmployee, BankOffice office, boolean canIssueCredits, double salary) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.worksAtOffice = worksAtOffice; // Изменение инициализации переменной
        this.isOfficeEmployee = isOfficeEmployee;
        this.office = office;
        this.canIssueCredits = canIssueCredits;
        this.salary = salary;
    }
}
