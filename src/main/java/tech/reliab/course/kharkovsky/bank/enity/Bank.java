package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

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
    }

    private double generateInterestRate() {
        double maxInterestRate = 20.0;
        double ratingScale = 100.0;
        double scaledRating = (double) bankRating / ratingScale;
        return maxInterestRate * (1 - scaledRating);
    }
}
