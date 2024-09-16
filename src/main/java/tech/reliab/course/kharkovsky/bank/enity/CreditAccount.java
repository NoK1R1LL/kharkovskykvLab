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
    private Date issueDate;
    private int termMonths;
    private double loanAmount;
    private double interestRate;
    private Employee issuingEmployee;
    private BankAtm servicingAtm; // Добавляем поле для банкомата

    // Обновляем конструктор
    public CreditAccount(String accountId, User user, String bankName, Date issueDate, int termMonths, double loanAmount, double interestRate, Employee issuingEmployee, BankAtm servicingAtm) {
        this.accountId = accountId;
        this.user = user;
        this.bankName = bankName;
        this.issueDate = issueDate;
        this.termMonths = termMonths;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.issuingEmployee = issuingEmployee;
        this.servicingAtm = servicingAtm; // Инициализируем банкомат
    }
}
