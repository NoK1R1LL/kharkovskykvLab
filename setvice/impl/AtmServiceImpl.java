package tech.reliab.course.kharkovsky.bank.setvice.impl;

import tech.reliab.course.kharkovsky.bank.enity.BankAtm;
import tech.reliab.course.kharkovsky.bank.setvice.AtmService;

import java.util.ArrayList;
import java.util.List;

public class AtmServiceImpl implements AtmService {
    private List<BankAtm> atmList;

    public AtmServiceImpl() {
        this.atmList = new ArrayList<>();
    }

    @Override
    public void addAtm(BankAtm atm) {
        atmList.add(atm);
    }

    @Override
    public void removeAtm(BankAtm atm) {
        atmList.remove(atm);
    }

    @Override
    public List<BankAtm> getAllAtms() {
        return atmList;
    }

    @Override
    public List<BankAtm> getAtmsByBank(String bankId) {
        List<BankAtm> atmsByBank = new ArrayList<>();
        for (BankAtm atm : atmList) {
            if (atm.getBank().getBankId().equals(bankId)) {
                atmsByBank.add(atm);
            }
        }
        return atmsByBank;
    }
}
