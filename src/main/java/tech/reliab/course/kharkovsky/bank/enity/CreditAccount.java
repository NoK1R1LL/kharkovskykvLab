package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreditAccount {
    private String accountId;
    private User user;
    private String bankName;
    private Date startDate;
    private Date endDate;
    private int durationMonths;
    private double loanAmount;
    private double monthlyPayment;
    private double interestRate;
    private Employee issuingEmployee;
    private PaymentAccount paymentAccount;
    private double balance;

    public CreditAccount(String accountId, User user, String bankName, Date startDate, int durationMonths, double loanAmount, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        this.accountId = accountId;
        this.user = user;
        this.bankName = bankName;
        this.startDate = startDate;
        this.durationMonths = durationMonths;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.issuingEmployee = issuingEmployee;
        this.paymentAccount = paymentAccount;
        this.endDate = calculateEndDate(startDate, durationMonths);
        this.monthlyPayment = calculateMonthlyPayment(loanAmount, durationMonths, interestRate);
        this.balance = loanAmount;
    }

    private Date calculateEndDate(Date startDate, int durationMonths) {
        Date endDate = new Date(startDate.getTime());
        endDate.setMonth(endDate.getMonth() + durationMonths);
        return endDate;
    }

    private double calculateMonthlyPayment(double loanAmount, int durationMonths, double interestRate) {
        double monthlyInterestRate = interestRate / 100 / 12;
        return loanAmount * (monthlyInterestRate + monthlyInterestRate / (Math.pow(1 + monthlyInterestRate, durationMonths) - 1));
    }

}
