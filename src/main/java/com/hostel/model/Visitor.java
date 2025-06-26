package com.hostel.model;

import java.time.LocalDateTime;

public class Visitor {
    private int visitorId;
    private String visitorName;
    private String purpose;
    private int visitingStudentId;
    private LocalDateTime visitTime;

    public Visitor(int visitorId, String visitorName, String purpose, int visitingStudentId, LocalDateTime visitTime) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.purpose = purpose;
        this.visitingStudentId = visitingStudentId;
        this.visitTime = visitTime;
    }

    public int getVisitorId() { return visitorId; }
    public void setVisitorId(int visitorId) { this.visitorId = visitorId; }

    public String getVisitorName() { return visitorName; }
    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public int getVisitingStudentId() { return visitingStudentId; }
    public void setVisitingStudentId(int visitingStudentId) { this.visitingStudentId = visitingStudentId; }

    public LocalDateTime getVisitTime() { return visitTime; }
    public void setVisitTime(LocalDateTime visitTime) { this.visitTime = visitTime; }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorId=" + visitorId +
                ", visitorName='" + visitorName + '\'' +
                ", purpose='" + purpose + '\'' +
                ", visitingStudentId=" + visitingStudentId +
                ", visitTime=" + visitTime +
                '}';
    }
}
