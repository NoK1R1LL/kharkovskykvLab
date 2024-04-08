package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankOffice {
    private String officeId;
    private String name;
    private String address;
    private String status;
    private boolean atmPlacementAllowed;
    private int numberOfATMs;
    private boolean creditIssuanceAllowed;
    private boolean cashWithdrawalEnabled;
    private boolean cashDepositEnabled;
    private double availableMoney;
    private double rentCost;
    private Bank bank;

    public BankOffice(String officeId, String name, String address) {
        this.officeId = officeId;
        this.name = name;
        this.address = address;
        this.status = "Работает";
        this.atmPlacementAllowed = true;
        this.creditIssuanceAllowed = true;
        this.cashWithdrawalEnabled = true;
        this.cashDepositEnabled = true;
        this.availableMoney = 0;
        this.rentCost = Math.random() * 2000;
        this.bank = bank;
    }
}
