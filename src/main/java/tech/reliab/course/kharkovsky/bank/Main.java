package tech.reliab.course.kharkovsky.bank;

import tech.reliab.course.kharkovsky.bank.enity.Bank;
import tech.reliab.course.kharkovsky.bank.enity.BankAtm;
import tech.reliab.course.kharkovsky.bank.enity.BankOffice;
import tech.reliab.course.kharkovsky.bank.enity.CreditAccount;
import tech.reliab.course.kharkovsky.bank.enity.Employee;
import tech.reliab.course.kharkovsky.bank.enity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем список банков
        List<Bank> banks = new ArrayList<>();

        // Создаем банки
        Bank bank1 = new Bank("1", "Тинькофф");
        bank1.setNumberOfATMs(6);
        bank1.setNumberOfEmployees(6);
        bank1.setNumberOfOffices(6);
        bank1.setInterestRate(5.0);
        bank1.setNumberOfCustomers(10000);
        bank1.setBankOffices(initializeBankOffices(bank1));
        initializeEmployees(bank1);

        Bank bank2 = new Bank("2", "Сбер");
        bank2.setNumberOfATMs(4);
        bank2.setNumberOfEmployees(4);
        bank2.setNumberOfOffices(4);
        bank2.setInterestRate(4.5);
        bank2.setNumberOfCustomers(20000);
        bank2.setBankOffices(initializeBankOffices(bank2));
        initializeEmployees(bank2);

        Bank bank3 = new Bank("3", "ВТБ");
        bank3.setNumberOfATMs(2);
        bank3.setNumberOfEmployees(2);
        bank3.setNumberOfOffices(2);
        bank3.setInterestRate(4.8);
        bank3.setNumberOfCustomers(15000);
        bank3.setBankOffices(initializeBankOffices(bank3));
        initializeEmployees(bank3);

        banks.add(bank1);
        banks.add(bank2);
        banks.add(bank3);

        // Отображаем информацию о банках
        System.out.println("Выберите банк из списка:");
        for (int i = 0; i < banks.size(); i++) {
            Bank bank = banks.get(i);
            System.out.println((i + 1) + ". " + bank.getName() +
                    " - Банкоматы: " + bank.getNumberOfATMs() +
                    ", Сотрудники: " + bank.getNumberOfEmployees() +
                    ", Офисы: " + bank.getNumberOfOffices() +
                    ", Процентная ставка: " + bank.getInterestRate());
        }

        // Запрашиваем выбор пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер банка для выбора (1, 2, или 3): ");
        int bankChoice = scanner.nextInt();

        // Проверяем, что выбор корректный
        if (bankChoice < 1 || bankChoice > 3) {
            System.out.println("Некорректный выбор. Пожалуйста, выберите номер от 1 до 3.");
            return;
        }

        Bank selectedBank = banks.get(bankChoice - 1);
        List<BankOffice> workingOffices = getWorkingOffices(selectedBank);

        // Отображаем информацию о рабочих офисах
        System.out.println("\nВыберите банковский офис из списка:");
        for (int i = 0; i < workingOffices.size(); i++) {
            BankOffice office = workingOffices.get(i);
            System.out.println((i + 1) + ". " + office.getName() +
                    " - Адрес: " + office.getAddress() +
                    ", Баланс: " + office.getAvailableMoney());
        }

        // Запрашиваем выбор пользователя
        System.out.print("Введите номер офиса для выбора: ");
        int officeChoice = scanner.nextInt();

        // Проверяем, что выбор корректный
        if (officeChoice < 1 || officeChoice > workingOffices.size()) {
            System.out.println("Некорректный выбор. Пожалуйста, выберите корректный номер офиса.");
            return;
        }

        BankOffice selectedOffice = workingOffices.get(officeChoice - 1);

        // Запрашиваем сумму кредита
        System.out.print("Введите сумму кредита: ");
        double loanAmount = scanner.nextDouble();

        // Проверяем, доступна ли сумма в офисе
        if (loanAmount > selectedOffice.getAvailableMoney()) {
            System.out.println("Сумма кредита превышает доступную сумму в офисе. Вам нужен другой офис!");
            return;
        }

        // Запрашиваем кредитный рейтинг клиента
        System.out.print("Введите кредитный рейтинг клиента: ");
        int creditScore = scanner.nextInt();

        // Проверяем условия для выдачи кредита
        if (creditScore < 5000 && selectedBank.getInterestRate() > 50) {
            System.out.println("Кредит не выдается: кредитный рейтинг клиента слишком низкий и процентная ставка банка слишком высокая.");
            return;
        }

        // Запрашиваем список сотрудников, которые могут выдавать кредиты
        List<Employee> creditEmployees = getCreditEmployees(selectedBank);

        // Отображаем информацию о сотрудниках
        System.out.println("\nВыберите сотрудника из списка:");
        for (int i = 0; i < creditEmployees.size(); i++) {
            Employee employee = creditEmployees.get(i);
            System.out.println((i + 1) + ". " + employee.getName() +
                    " - Должность: " + employee.getPosition());
        }

        // Запрашиваем выбор пользователя
        System.out.print("Введите номер сотрудника для выбора: ");
        int employeeChoice = scanner.nextInt();

        // Проверяем, что выбор корректный
        if (employeeChoice < 1 || employeeChoice > creditEmployees.size()) {
            System.out.println("Некорректный выбор. Пожалуйста, выберите корректный номер сотрудника.");
            return;
        }

        Employee selectedEmployee = creditEmployees.get(employeeChoice - 1);

        // Проверяем доступность денег в банкоматах выбранного офиса
        checkAtmsAvailability(selectedOffice, loanAmount);

        // Создаем кредитный аккаунт
        User user = new User("1", "Клиент", new Date(), "Работа", 5000, creditScore);
        CreditAccount creditAccount = new CreditAccount(
                "1",
                user,
                selectedBank.getName(),
                new Date(),
                12,
                loanAmount,
                selectedBank.getInterestRate(),
                selectedEmployee,
                null
        );

        // Обновляем баланс офиса
        selectedOffice.setAvailableMoney(selectedOffice.getAvailableMoney() - loanAmount);

        // Выводим информацию о созданном кредите
        System.out.println("\nКредитный аккаунт создан:");
        System.out.println("Сумма кредита: " + creditAccount.getLoanAmount());
        System.out.println("Процентная ставка: " + creditAccount.getInterestRate());

        scanner.close();
    }

    private static List<BankOffice> initializeBankOffices(Bank bank) {
        List<BankOffice> offices = new ArrayList<>();
        for (int i = 1; i <= bank.getNumberOfOffices(); i++) {
            BankOffice office = new BankOffice(Integer.toString(i), "Офис " + i, "Адрес " + i, bank);
            office.setAvailableMoney(10000 * i); // Устанавливаем доступные деньги
            office.setStatus("Работает"); // Устанавливаем статус
            office.setCreditIssuanceAllowed(true); // Разрешаем выдачу кредита
            initializeBankAtms(office, bank);
            offices.add(office);
        }
        return offices;
    }

    private static void initializeBankAtms(BankOffice office, Bank bank) {
        for (int i = 1; i <= bank.getNumberOfATMs(); i++) {
            BankAtm atm = new BankAtm(
                    Integer.toString(i),
                    "Банкомат " + i,
                    "Адрес банкомата " + i,
                    office // Передаем офис вместо банка
            );
            atm.setAvailableMoney(10000 * i); // Устанавливаем доступные деньги в банкомате
            office.addBankAtm(atm);
        }
    }


    private static void initializeEmployees(Bank bank) {
        for (int i = 1; i <= bank.getNumberOfEmployees(); i++) {
            Employee employee = new Employee(
                    Integer.toString(i),
                    "Сотрудник " + i,
                    new Date(),
                    "Кредитный менеджер",
                    null, // Поскольку работаем с одним офисом, можно оставить null
                    true,
                    5000
            );
            bank.getEmployees().add(employee); // Теперь список не null
        }
    }

    private static List<BankOffice> getWorkingOffices(Bank bank) {
        List<BankOffice> workingOffices = new ArrayList<>();
        for (BankOffice office : bank.getBankOffices()) {
            if ("Работает".equals(office.getStatus()) && office.isCreditIssuanceAllowed()) {
                workingOffices.add(office);
            }
        }
        return workingOffices;
    }

    private static List<Employee> getCreditEmployees(Bank bank) {
        List<Employee> creditEmployees = new ArrayList<>();
        for (Employee employee : bank.getEmployees()) {
            if (employee.isCreditIssuanceAllowed()) {
                creditEmployees.add(employee);
            }
        }
        return creditEmployees;
    }


    private static void checkAtmsAvailability(BankOffice office, double loanAmount) {
        for (BankAtm atm : office.getBankAtms()) {
            if (atm.getAvailableMoney() >= loanAmount) {
                atm.setAvailableMoney(atm.getAvailableMoney() - loanAmount);
                System.out.println("Кредит выдан через банкомат " + atm.getName() + " в офисе " + office.getName());
                return;
            }
        }

        // Если в банкоматах в этом офисе нет денег, ищем в другом офисе
        for (BankOffice otherOffice : office.getBank().getBankOffices()) {
            if (!otherOffice.equals(office)) {
                for (BankAtm atm : otherOffice.getBankAtms()) {
                    if (atm.getAvailableMoney() >= loanAmount) {
                        atm.setAvailableMoney(atm.getAvailableMoney() - loanAmount);
                        System.out.println("Кредит выдан через банкомат " + atm.getName() + " в офисе " + otherOffice.getName());
                        return;
                    }
                }
            }
        }

        System.out.println("Кредит не может быть выдан: в доступных банкоматах недостаточно средств.");
    }
}
