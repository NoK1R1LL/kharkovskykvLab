package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentAccount {
    private String accountId;
    private User user;
    private String bankName;
    private double balance;

    public PaymentAccount(String accountId, User user, String bankName) {
        this.accountId = accountId;
        this.user = user;
        this.bankName = bankName;
        this.balance = 0;
    }
}
