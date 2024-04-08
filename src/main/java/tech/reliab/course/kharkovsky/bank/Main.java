package tech.reliab.course.kharkovsky.bank;

import tech.reliab.course.kharkovsky.bank.enity.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        User user = new User("1", "John Doe", new Date(), "Software Engineer", 5000);
        Bank bank = new Bank("1", "MyBank");
        BankOffice bankOffice = new BankOffice("1", "Main Office", "123 Main St");
        Employee employee = new Employee("1", "Alice Smith", new Date(), "Loan Officer", bankOffice, true, bankOffice, true, 5000);
        PaymentAccount paymentAccount = new PaymentAccount("1", user, "MyBank");
        CreditAccount creditAccount = new CreditAccount("1", user, "MyBank", new Date(), 12, 10000, 5.0, employee, paymentAccount);
        BankAtm bankAtm = new BankAtm("1", "ATM1", "123 Main St", bank);

        System.out.println("Пользователь:");
        System.out.println("  Идентификатор пользователя: " + user.getUserId() +
                "\n  Полное имя: " + user.getFullName() +
                "\n  Дата рождения: " + user.getDateOfBirth() +
                "\n  Работа: " + user.getJob() +
                "\n  Ежемесячный доход: " + user.getMonthlyIncome() +
                "\n  Кредитный рейтинг: " + user.getCreditRating());

        System.out.println("\nБанк:");
        System.out.println("  Идентификатор банка: " + bank.getBankId() +
                "\n  Название: " + bank.getName() +
                "\n  Количество офисов: " + bank.getNumberOfOffices() +
                "\n  Количество банкоматов: " + bank.getNumberOfATMs() +
                "\n  Количество сотрудников: " + bank.getNumberOfEmployees() +
                "\n  Количество клиентов: " + bank.getNumberOfCustomers() +
                "\n  Рейтинг банка: " + bank.getBankRating() +
                "\n  Всего денег: " + bank.getTotalMoney() +
                "\n  Процентная ставка: " + bank.getInterestRate());

        System.out.println("\nСотрудник:");
        System.out.println("  Идентификатор сотрудника: " + employee.getEmployeeId() +
                "\n  Полное имя: " + employee.getFullName() +
                "\n  Дата рождения: " + employee.getDateOfBirth() +
                "\n  Должность: " + employee.getPosition() +
                "\n  Работает в офисе банка: " + employee.getWorksAtOffice().getName() +
                "\n  Является сотрудником офиса: " + (employee.isOfficeEmployee() ? "Да" : "Нет") +
                "\n  Офис: " + (employee.isOfficeEmployee() ? employee.getOffice().getName() : "Удаленный") +
                "\n  Может выдавать кредиты: " + (employee.isCanIssueCredits() ? "Да" : "Нет") +
                "\n  Зарплата: " + employee.getSalary());

        System.out.println("\nПлатежный счет:");
        System.out.println("  Идентификатор счета: " + paymentAccount.getAccountId() +
                "\n  Пользователь: " + paymentAccount.getUser().getFullName() +
                "\n  Название банка: " + paymentAccount.getBankName() +
                "\n  Баланс: " + paymentAccount.getBalance());

        System.out.println("\nКредитный счет:");
        System.out.println("  Идентификатор счета: " + creditAccount.getAccountId() +
                "\n  Пользователь: " + creditAccount.getUser().getFullName() +
                "\n  Название банка: " + creditAccount.getBankName() +
                "\n  Дата начала: " + creditAccount.getStartDate() +
                "\n  Дата окончания: " + creditAccount.getEndDate() +
                "\n  Продолжительность месяцев: " + creditAccount.getDurationMonths() +
                "\n  Сумма кредита: " + creditAccount.getLoanAmount() +
                "\n  Ежемесячный платеж: " + creditAccount.getMonthlyPayment() +
                "\n  Процентная ставка: " + creditAccount.getInterestRate() +
                "\n  Сотрудник, выдавший кредит: " + creditAccount.getIssuingEmployee().getFullName() +
                "\n  Платежный счет: " + creditAccount.getPaymentAccount().getAccountId());

        System.out.println("\nБанковский банкомат:");
        System.out.println("  Идентификатор банкомата: " + bankAtm.getAtmId() +
                "\n  Название: " + bankAtm.getName() +
                "\n  Адрес: " + bankAtm.getAddress() +
                "\n  Статус: " + bankAtm.getStatus() +
                "\n  Банк: " + bankAtm.getBank().getName() +
                "\n  Местоположение: " + bankAtm.getLocation() +
                "\n  Обслуживающий сотрудник: " + bankAtm.getServicingEmployee() +
                "\n  Возможность снятия наличных: " + bankAtm.isCashWithdrawalEnabled() +
                "\n  Возможность внесения наличных: " + bankAtm.isCashDepositEnabled() +
                "\n  Доступные деньги: " + bankAtm.getAvailableMoney() +
                "\n  Стоимость обслуживания: " + bankAtm.getMaintenanceCost());

    }
}
