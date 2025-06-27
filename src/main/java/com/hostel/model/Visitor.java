package com.hostel.model;

import java.time.LocalDateTime;

public class Visitor {
    private String visitorName;
    private String purpose;
    private int visitingStudentId;
    private LocalDateTime visitTime;

    public Visitor(String visitorName, String purpose, int visitingStudentId, LocalDateTime visitTime) {
        this.visitorName = visitorName;
        this.purpose = purpose;
        this.visitingStudentId = visitingStudentId;
        this.visitTime = visitTime;
    }


    @Override
    public String toString() {
        return "Visitor{" +
                ", visitorName='" + visitorName + '\'' +
                ", purpose='" + purpose + '\'' +
                ", visitingStudentId=" + visitingStudentId +
                ", visitTime=" + visitTime +
                '}';
    }
}
