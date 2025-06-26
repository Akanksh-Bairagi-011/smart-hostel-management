package com.hostel.model;

public class Room {
    private int roomId;
    private String roomNumber;
    private String blockName;
    private int capacity;
    private String status;

    public Room(int roomId, String roomNumber, String blockName, int capacity, String status) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.blockName = blockName;
        this.capacity = capacity;
        this.status = status;
    }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getBlockName() { return blockName; }
    public void setBlockName(String blockName) { this.blockName = blockName; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", blockName='" + blockName + '\'' +
                ", capacity=" + capacity +
                ", status='" + status + '\'' +
                '}';
    }
}
