package com.hostel.model;

import java.time.LocalDate;

public class FeeRecord {
    private int feeId;
    private int studentId;
    private double amount;
    private LocalDate dueDate;
    private boolean isPaid;

    public FeeRecord(int feeId, int studentId, double amount, LocalDate dueDate, boolean isPaid) {
        this.feeId = feeId;
        this.studentId = studentId;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
    }

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "FeeRecord{" +
                "feeId=" + feeId +
                ", studentId=" + studentId +
                ", amount=" + amount +
                ", dueDate=" + dueDate +
                ", isPaid=" + isPaid +
                '}';
    }
}
