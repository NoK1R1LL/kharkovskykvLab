package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User {
    private String userId;
    private String fullName;
    private Date dateOfBirth;
    private String job;
    private double monthlyIncome;
    private Bank[] banksUsed;
    private List<CreditAccount> creditAccounts;
    private List<PaymentAccount> paymentAccounts;
    private int creditRating;

    public User(String userId, String fullName, Date dateOfBirth, String job, double monthlyIncome) {
        this.userId = userId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.job = job;
        this.monthlyIncome = monthlyIncome;
        this.creditRating = calculateCreditRating(monthlyIncome);
        this.banksUsed = new Bank[0];
        this.creditAccounts = new ArrayList<>();
        this.paymentAccounts = new ArrayList<>();
    }

    private int calculateCreditRating(double monthlyIncome) {
        if (monthlyIncome < 1000) {
            return 100;
        } else if (monthlyIncome >= 1000 && monthlyIncome < 2000) {
            return 200;
        } else {
            return 300;
        }
    }

    public void addPaymentAccount(PaymentAccount account) {
        this.paymentAccounts.add(account);
    }

    public void addCreditAccount(CreditAccount account) {
        this.creditAccounts.add(account);
    }
}
