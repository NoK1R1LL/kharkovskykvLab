package tech.reliab.course.kharkovsky.bank.setvice;

import tech.reliab.course.kharkovsky.bank.enity.BankOffice;

import java.util.List;

public interface BankOfficeService {
    void addBankOffice(BankOffice bankOffice);
    void removeBankOffice(BankOffice bankOffice);
    List<BankOffice> getAllBankOffices();
    List<BankOffice> getBankOfficesByBank(String bankId);
}
