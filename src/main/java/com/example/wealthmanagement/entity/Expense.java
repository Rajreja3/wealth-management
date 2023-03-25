package com.example.wealthmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(nullable = false)
    private int expenseId;
    @Column(length=20, nullable = false)
    private String date;
    @Column(length=20, nullable = false)
    private String description;
    @Column(length=20, nullable = false)
    private String location;
    @Column(nullable = false)
    private int categoryId;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "Id=" + Id +
                ", expenseId=" + expenseId +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
