package com.hostel.model;

import java.time.LocalDate;

public class Complaint {
    private int complaintId;
    private int studentId;
    private String complaintType;
    private String description;
    private String status;
    private LocalDate dateFiled;

    public Complaint(int complaintId, int studentId, String complaintType, String description, String status, LocalDate dateFiled) {
        this.complaintId = complaintId;
        this.studentId = studentId;
        this.complaintType = complaintType;
        this.description = description;
        this.status = status;
        this.dateFiled = dateFiled;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateFiled() {
        return dateFiled;
    }

    public void setDateFiled(LocalDate dateFiled) {
        this.dateFiled = dateFiled;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", studentId=" + studentId +
                ", complaintType='" + complaintType + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", dateFiled=" + dateFiled +
                '}';
    }
}
