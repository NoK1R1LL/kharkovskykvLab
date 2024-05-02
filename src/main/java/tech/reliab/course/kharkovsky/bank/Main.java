package tech.reliab.course.kharkovsky.bank;

import tech.reliab.course.kharkovsky.bank.enity.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Bank> banks = initializeBanks();
        for (Bank bank : banks.values()) {
            printBankData(bank);
        }
    }

    private static Map<String, Bank> initializeBanks() {
        Map<String, Bank> banks = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            Bank bank = new Bank(Integer.toString(i), "Банк " + i);
            bank.setAtms(initializeBankAtms(bank));
            bank.setBankOffices(initializeBankOffices(bank));
            bank.setUsers(initializeUsers(bank)); // добавлено инициализация клиентов
            banks.put(Integer.toString(i), bank);
        }
        return banks;
    }

    private static List<BankAtm> initializeBankAtms(Bank bank) {
        List<BankAtm> atms = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            BankAtm atm = new BankAtm(Integer.toString(i), "Банкомат " + i, "Адрес " + i, bank);
            atms.add(atm);
        }
        return atms;
    }

    private static List<BankOffice> initializeBankOffices(Bank bank) {
        List<BankOffice> offices = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            BankOffice office = new BankOffice(Integer.toString(i), "Офис " + i, "Адрес " + i);
            office.setEmployees(initializeEmployees(office));
            offices.add(office);
        }
        return offices;
    }

    private static List<Employee> initializeEmployees(BankOffice office) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Employee employee = new Employee(Integer.toString(i), "Сотрудник " + i, new Date(), "Должность " + i, office, true, office, true, 5000);
            employees.add(employee);
        }
        return employees;
    }


    private static List<User> initializeUsers(Bank bank) {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            User user = new User(Integer.toString(i), "Клиент " + i, new Date(), "Работа " + i, 5000 * i);
            user.setPaymentAccounts(initializePaymentAccounts(user));
            user.setCreditAccounts(initializeCreditAccounts(user));
            users.add(user);
        }
        return users;
    }

    private static List<PaymentAccount> initializePaymentAccounts(User user) {
        List<PaymentAccount> paymentAccounts = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            PaymentAccount account = new PaymentAccount(Integer.toString(i), user, "Bank");
            paymentAccounts.add(account);
        }
        return paymentAccounts;
    }


    private static List<CreditAccount> initializeCreditAccounts(User user) {
        List<CreditAccount> creditAccounts = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            CreditAccount account = new CreditAccount(Integer.toString(i), user, "Банк", new Date(), 12, 10000 * i, 5.0 * i, null, null);
            creditAccounts.add(account);
        }
        return creditAccounts;
    }

    private static void printBankData(Bank bank) {
        System.out.println("\nДанные о банке " + bank.getName() + ":");
        System.out.println("Банкоматы:");
        for (BankAtm atm : bank.getAtms()) {
            System.out.println("  " + atm.getName() + ", Адрес: " + atm.getAddress());
        }
        System.out.println("Офисы:");
        for (BankOffice office : bank.getBankOffices()) {
            System.out.println("  " + office.getName() + ", Адрес: " + office.getAddress());
            System.out.println("  Сотрудники:");
            for (Employee employee : office.getEmployees()) {
                System.out.println("    " + employee.getFullName() + ", Должность: " + employee.getPosition());
            }
        }
        System.out.println("Клиенты:");
        for (User user : bank.getUsers()) {
            printUserData(user);
        }
    }

    private static void printUserData(User user) {
        System.out.println("  " + user.getFullName() + ", Работа: " + user.getJob());
        System.out.println("  Платежные счета:");
        for (PaymentAccount account : user.getPaymentAccounts()) {
            System.out.println("    " + account.getAccountId() + ". Баланс: " + account.getBalance());
        }
        System.out.println("  Кредитные счета:");
        for (CreditAccount account : user.getCreditAccounts()) {
            System.out.println("    " + account.getAccountId() + ". Баланс: " + account.getBalance());
        }
    }
}
