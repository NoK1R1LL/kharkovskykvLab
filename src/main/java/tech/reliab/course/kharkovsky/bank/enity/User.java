package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class User {
    private String userId;
    private String fullName;
    private Date dateOfBirth;
    private String job;
    private double monthlyIncome;
    private Bank[] banksUsed;
    private CreditAccount[] creditAccounts;
    private PaymentAccount[] paymentAccounts;
    private int creditRating;

    public User(String userId, String fullName, Date dateOfBirth, String job, double monthlyIncome) {
        this.userId = userId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.job = job;
        this.monthlyIncome = monthlyIncome;
        this.creditRating = calculateCreditRating(monthlyIncome);
        this.banksUsed = new Bank[0];
        this.creditAccounts = new CreditAccount[0];
        this.paymentAccounts = new PaymentAccount[0];
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
}

