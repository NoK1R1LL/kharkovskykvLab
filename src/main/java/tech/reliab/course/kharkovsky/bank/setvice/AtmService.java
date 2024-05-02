package tech.reliab.course.kharkovsky.bank.setvice;

import tech.reliab.course.kharkovsky.bank.enity.BankAtm;

import java.util.List;

public interface AtmService {
    void addAtm(BankAtm atm);
    void removeAtm(BankAtm atm);
    List<BankAtm> getAllAtms();
    List<BankAtm> getAtmsByBank(String bankId);
}
