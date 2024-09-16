package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Bank {
    private String bankId;
    private String name;
    private int numberOfATMs;
    private int numberOfEmployees;
    private int numberOfOffices;
    private double interestRate;
    private int numberOfCustomers;
    private List<BankOffice> bankOffices;
    private List<Employee> employees;

    public Bank(String bankId, String name) {
        this.bankId = bankId;
        this.name = name;
        this.bankOffices = new ArrayList<>();
        this.employees = new ArrayList<>(); // Инициализация списка сотрудников
    }
    public double getTotalMoney() {
        double totalMoney = 0;
        for (BankOffice office : bankOffices) {
            totalMoney += office.getAvailableMoney();
        }
        return totalMoney;
    }
}
