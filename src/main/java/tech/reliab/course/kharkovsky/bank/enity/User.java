package tech.reliab.course.kharkovsky.bank.enity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private String userId;
    private String name;
    private Date dateOfBirth;
    private String job;
    private double salary; // Можно оставить, если планируете использовать это поле
    private int creditScore; // Поле для кредитного рейтинга

    // Конструктор для всех полей
    public User(String userId, String name, Date dateOfBirth, String job, double salary, int creditScore) {
        this.userId = userId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.job = job;
        this.salary = salary;
        this.creditScore = creditScore;
    }

    // Конструктор без зарплаты
    public User(String userId, String name, Date dateOfBirth, String job, int creditScore) {
        this.userId = userId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.job = job;
        this.salary = 0; // Значение по умолчанию
        this.creditScore = creditScore;
    }
}
