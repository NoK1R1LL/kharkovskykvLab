package tech.reliab.course.kharkovsky.bank.setvice.impl;

import tech.reliab.course.kharkovsky.bank.enity.BankOffice;
import tech.reliab.course.kharkovsky.bank.setvice.BankOfficeService;

import java.util.ArrayList;
import java.util.List;

public class BankOfficeServiceImpl implements BankOfficeService {
    private List<BankOffice> bankOfficeList;

    public BankOfficeServiceImpl() {
        this.bankOfficeList = new ArrayList<>();
    }

    @Override
    public void addBankOffice(BankOffice bankOffice) {
        bankOfficeList.add(bankOffice);
    }

    @Override
    public void removeBankOffice(BankOffice bankOffice) {
        bankOfficeList.remove(bankOffice);
    }

    @Override
    public List<BankOffice> getAllBankOffices() {
        return bankOfficeList;
    }

    @Override
    public List<BankOffice> getBankOfficesByBank(String bankId) {
        List<BankOffice> officesByBank = new ArrayList<>();
        for (BankOffice office : bankOfficeList) {
            if (office.getBank().getBankId().equals(bankId)) {
                officesByBank.add(office);
            }
        }
        return officesByBank;
    }
}
