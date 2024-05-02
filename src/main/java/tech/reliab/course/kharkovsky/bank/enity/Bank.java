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
    private int numberOfOffices;
    private int numberOfATMs;
    private int numberOfEmployees;
    private int numberOfCustomers;
    private int bankRating;
    private double totalMoney;
    private double interestRate;
    private List<User> users;
    private List<BankAtm> atms;
    private List<BankOffice> bankOffices;

    public Bank(String bankId, String name) {
        this.bankId = bankId;
        this.name = name;
        this.numberOfOffices = 0;
        this.numberOfATMs = 0;
        this.numberOfEmployees = 0;
        this.numberOfCustomers = 0;
        this.bankRating = (int) (Math.random() * 100);
        this.totalMoney = Math.random() * 1_000_000;
        this.interestRate = generateInterestRate();
        this.users = new ArrayList<>();
        this.atms = new ArrayList<>();
        this.bankOffices = new ArrayList<>();
    }

    private double generateInterestRate() {
        double maxInterestRate = 20.0;
        double ratingScale = 100.0;
        double scaledRating = (double) bankRating / ratingScale;
        return maxInterestRate * (1 - scaledRating);
    }

    public void addAtm(BankAtm atm) {
        atms.add(atm);
        numberOfATMs++;
    }

    public void addBankOffice(BankOffice office) {
        bankOffices.add(office);
        numberOfOffices++;
    }
}
