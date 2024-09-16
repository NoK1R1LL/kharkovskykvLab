package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BankOffice {
    private String officeId;
    private String name;
    private String address;
    private Bank bank;
    private double availableMoney;
    private String status = "Работает";
    private boolean creditIssuanceAllowed;
    private List<BankAtm> bankAtms = new ArrayList<>();

    public BankOffice(String officeId, String name, String address, Bank bank) {
        this.officeId = officeId;
        this.name = name;
        this.address = address;
        this.bank = bank;
    }

    public void addBankAtm(BankAtm atm) {
        this.bankAtms.add(atm);
    }

    public List<BankAtm> getBankAtms() {
        return bankAtms;
    }
}
