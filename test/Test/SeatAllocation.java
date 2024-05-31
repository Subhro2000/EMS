/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.util.Random;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Subhro Ghosh
 */
public class SeatAllocation
{
    
    private Connection con;
    private Student[] studentsAr;
    private Zone[] zoneAr;

    public SeatAllocation(Student[] sAr, Zone[] zAr)
    {
        
        this.studentsAr = sAr;
        this.zoneAr = zAr;
        
        seatAlloc(studentsAr, zoneAr);
        printList();
    }
    
    
    private void seatAlloc(Student[] sar, Zone[] zar)
    {
        
        // For allocate seat based on 1st preference zone
        for (int i = 0; i < zar.length; i++)
        {
            for (Student sar1 : sar)
            {
                int zid1 = sar1.getzPref1Id() - 1;
                if(zar[zid1].getFilledCap() < zar[zid1].getCapacity())
                {
                    if (i == zid1)
                    {
                        zar[zid1].setFilledCap((zar[zid1].getFilledCap())+1);
                        zar[zid1].setAssignStudent(sar1);
                        sar1.setGotZone(zid1+1);
                        sar1.setMark(1);
                    }
                }
            }
        }
        
        //To allocate seats based on 2nd preference zone
        for(int i = 0; i < zar.length; i++)
        {
            for (Student sar2 : sar)
            {
                if(sar2.getMark() == 0)
                {
                    int zid2 = sar2.getzPref2Id() - 1;
                    if(zar[zid2].getFilledCap() < zar[zid2].getCapacity())
                    {
                        if (i == zid2)
                        {
                            zar[zid2].setFilledCap((zar[zid2].getFilledCap())+1);
                            zar[zid2].setAssignStudent(sar2);
                            sar2.setGotZone(zid2+1);
                            sar2.setMark(1);
                        }
                    }
                }
                
            }
        }
        
        // To allocate seats to the remaining students who didn't get theie prefered zone
        for(int i = 0; i < zar.length; i++)
        {
            if(zar[i].getFilledCap()<zar[i].getCapacity())
            {
                for (Student sar3 : sar)
                {
                    if(sar3.getMark() == 0)
                    {
                        zar[i].setFilledCap((zar[i].getFilledCap())+1);
                        zar[i].setAssignStudent(sar3);
                        sar3.setGotZone(i+1);
                        sar3.setMark(1);
                    }
                }
            }
        }
        
        
        for (Student student : sar)
        {
            System.out.println(student.getName()+" | "+student.getzPref1Id()+" | "+student.getzPref2Id()+" | "+student.getGotZone());
        }
        
        for (Zone zone : zar)
        {
            int cap = zone.getCapacity();
            int fill = zone.getFilledCap();
            System.out.println(zone.getZoneId()+" is filled "+fill+" out of "+cap+" Studs are -> ");
        }
        
    }
    
    private void printList()
    {
        for (int i = 0; i < zoneAr.length; i++)
        {
            ArrayList<Student> sList= zoneAr[i].getAssignStuList();
            int id = zoneAr[i].getZoneId();
            int cap = zoneAr[i].getCapacity();
            int fCap = zoneAr[i].getFilledCap();
            for (Student student : sList)
            {
                System.out.println(id+" | "+cap+" | "+fCap+" | "+student.getsID()+" | "+student.getName()+" | "+student.getzPref1Id()+" | "+student.getzPref2Id());
            }
        }
    }
    
    public static void main(String[] args)
    {
        
        Student sAr[] = new Student[30];
        int lb = 1;
        int ub = 5;
        
        Random gen = new Random(56);
        
        for (int i = 0; i < sAr.length; i++)
        {
            sAr[i] = new Student("Student"+(i+1), (i+1), 0, 0);
            
            int z1Id = gen.nextInt(lb,ub+1);
            int z2Id;   
            while(true)
            {
                z2Id = gen.nextInt(lb, ub+1);
                if(z1Id != z2Id)
                    break;
            }
            
            sAr[i].setzPref1Id(z1Id );
            sAr[i].setzPref2Id(z2Id);
        }
        
        Zone zAr[] = new Zone[ub];
        zAr[0] = new Zone(1, 5, 6);
        zAr[1] = new Zone(2, 3, 10);
        zAr[2] = new Zone(3, 3, 5);
        zAr[3] = new Zone(4, 10, 12);
        zAr[4] = new Zone(5, 8, 7);
        
        SeatAllocation alloc = new SeatAllocation(sAr, zAr);
        
    }
    
}

class Student
{
    private String name;
    private int sID;
    private int zPref1Id;
    private int zPref2Id;
    private int gotZone;
    private int mark;

    public Student(String name, int sID, int zPref1Id, int zPref2Id)
    {
        this.name = name;
        this.sID = sID;
        this.zPref1Id = zPref1Id;
        this.zPref2Id = zPref2Id;
        this.mark = 0;
    }

    public void setGotZone(int gotZone)
    {
        this.gotZone = gotZone;
    }

    public int getGotZone()
    {
        return gotZone;
    }

    public String getName()
    {
        return name;
    }

    public int getsID()
    {
        return sID;
    }

    public int getzPref1Id()
    {
        return zPref1Id;
    }

    public int getzPref2Id()
    {
        return zPref2Id;
    }

    public void setzPref1Id(int zPref1Id)
    {
        this.zPref1Id = zPref1Id;
    }

    public void setzPref2Id(int zPref2Id)
    {
        this.zPref2Id = zPref2Id;
    }

    public int getMark()
    {
        return mark;
    }

    public void setMark(int mark)
    {
        this.mark = mark;
    }
    
    
    
}

class Zone
{
    private int zoneId;
    private int roomNo;
    private int capacity;
    private int filledCap;
    ArrayList<Student> assignedStu;

    public Zone(int zoneId, int roomNo, int capacity)
    {
        this.zoneId = zoneId;
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.filledCap = 0;
        this.assignedStu = new ArrayList<>();
    }

    public int getZoneId()
    {
        return zoneId;
    }

    public int getRoomNo()
    {
        return roomNo;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setFilledCap(int filledCap)
    {
        this.filledCap = filledCap;
    }
    
    public int getFilledCap()
    {
        return filledCap;
    }
    
    public void setAssignStudent(Student s)
    {
        assignedStu.add(s);
    }
    
    public  ArrayList getAssignStuList()
    {
        return assignedStu;
    }
    
}