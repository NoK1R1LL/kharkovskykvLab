package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAtm {
    private String atmId;
    private String name;
    private String address;
    private String status;
    private Bank bank;
    private String location;
    private Employee servicingEmployee;
    private boolean cashWithdrawalEnabled;
    private boolean cashDepositEnabled;
    private double availableMoney;
    private double maintenanceCost;

    public BankAtm(String atmId, String name, String address, Bank bank) {
        this.atmId = atmId;
        this.name = name;
        this.address = address;
        this.bank = bank;
        this.status = getStatusDescription();
        this.location = bank.getName() + " " + address;
        this.cashWithdrawalEnabled = true;
        this.cashDepositEnabled = true;
        this.availableMoney = bank.getTotalMoney();
        this.maintenanceCost = Math.random() * 500;
    }

    public String getStatusDescription() {
        if (availableMoney > 0) {
            return "Работает";
        } else if (availableMoney == 0) {
            return "Нет денег";
        } else {
            return "Не работает";
        }
    }
}
