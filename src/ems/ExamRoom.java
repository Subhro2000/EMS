/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ems;

/**
 *
 * @author Subhro Ghosh
 */
public class ExamRoom
{
    private int centerId;
    private int zoneId;
    private String roomNo;
    private int capacity;
    private int filledCapacity;

    public ExamRoom(int centerId, int zoneId, String roomNo, int capacity)
    {
        this.centerId = centerId;
        this.zoneId = zoneId;
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.filledCapacity = 0;
    }

    public int getCenterId()
    {
        return centerId;
    }

    public int getZoneId()
    {
        return zoneId;
    }

    public String getRoomNo()
    {
        return roomNo;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public int getFilledCapacity()
    {
        return filledCapacity;
    }

    public void setFilledCapacity(int filledCapacity)
    {
        this.filledCapacity = filledCapacity;
    }
    
}
