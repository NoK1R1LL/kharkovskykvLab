package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Employee {
    private String employeeId;
    private String name;
    private Date hireDate;
    private String position;
    private BankOffice office;
    private boolean canIssueCredits; // Поле для проверки права на выдачу кредитов
    private double salary;

    public Employee(String employeeId, String name, Date hireDate, String position, BankOffice office, boolean canIssueCredits, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.hireDate = hireDate;
        this.position = position;
        this.office = office;
        this.canIssueCredits = canIssueCredits;
        this.salary = salary;
    }

    // Метод для проверки, может ли сотрудник выдавать кредиты
    public boolean isCreditIssuanceAllowed() {
        return canIssueCredits;
    }
}
