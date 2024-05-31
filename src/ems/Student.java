/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ems;

/**
 *
 * @author Subhro Ghosh
 */
public class Student
{
    private int studentId;
    private String studentName;
    private int zPref1;
    private int zPref2;
    private String allocRoom;
    private int allocMark;

    public Student(int studentId, String studentName, int zPref1, int zPref2)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.zPref1 = zPref1;
        this.zPref2 = zPref2;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public int getzPref1()
    {
        return zPref1;
    }

    public int getzPref2()
    {
        return zPref2;
    }

    public String getAllocRoom()
    {
        return allocRoom;
    }

    public int getAllocMark()
    {
        return allocMark;
    }

    public void setAllocRoom(String allocRoom)
    {
        this.allocRoom = allocRoom;
    }

    public void setAllocMark(int allocMark)
    {
        this.allocMark = allocMark;
    }
    
    
}
