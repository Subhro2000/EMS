/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Subhro Ghosh
 */
public class SeatAllocation
{
    private ConnectionToDatabase cdb;
    private Connection conn;
    private ArrayList<Student> studentList;
    private ArrayList<ExamRoom> roomList;

    public SeatAllocation()
    {
        cdb = new ConnectionToDatabase();
        
        try
        {
            conn = cdb.startConnection();
        } catch (SQLException ex)
        {
//            Logger.getLogger(UserSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        studentList = new ArrayList<>();
        roomList = new ArrayList<>();
        
        try
        {
            fillStudentList();
            fillRoomList();
        } catch (SQLException ex)
        {
            Logger.getLogger(SeatAllocationPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        seatAlloc(studentList, roomList);
        
    }
    
        private void fillStudentList() throws SQLException
    {
//        String fetch = "SELECT Student_Id, Name, EPref_Zone1_Id, EPref_Zone2_Id FROM Student WHERE Roll_No = 1";
        String fetch = "SELECT Student_Id, Name, EPref_Zone1_Id, EPref_Zone2_Id FROM Student";
        
        PreparedStatement psmt = conn.prepareStatement(fetch);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next())
        {
            int id = rs.getInt("Student_Id");
            String name = rs.getString("Name");
//            System.out.println(name);
            int zone1 = rs.getInt("EPref_Zone1_Id");
            int zone2 = rs.getInt("EPref_Zone2_Id");
            Student stu = new Student(id, name, zone1, zone2);
            studentList.add(stu);
        }
        
    }
    
    private void fillRoomList() throws SQLException
    {
        String fetch = "SELECT r.Center_Id, r.Room_No, r.Capacity, c.Zone_Id FROM CenterRoom r, ExamCenter c WHERE c.Center_Id = r.Center_Id";
        
        PreparedStatement psmt = conn.prepareStatement(fetch);
        
        ResultSet rs = psmt.executeQuery();
        
        while(rs.next())
        {
            int cid = rs.getInt("r.Center_Id");
            String name = rs.getString("r.Room_No");
            int cap = rs.getInt("r.Capacity");
            int zid = rs.getInt("c.Zone_Id");
            
            ExamRoom room = new ExamRoom(cid, zid, name, cap);
            roomList.add(room);
        }
        
    }
    
    
    
    private void seatAlloc(ArrayList<Student> sList, ArrayList<ExamRoom> rList)
    {
        // For allocate seat based on 1st preference zone
        for (ExamRoom room : rList)
        {
            for (Student student : sList)
            {
                if(student.getAllocMark() == 0)
                {
                    int zid1 = student.getzPref1();
                    int roomZone = room.getZoneId();

                    if(room.getFilledCapacity() < room.getCapacity())
                    {
                        if(roomZone == zid1)
                        {
                            room.setFilledCapacity((room.getFilledCapacity())+1);
                            student.setAllocRoom(room.getRoomNo());
                            student.setAllocMark(1);
                        }
                    }
                }
            }
        }
        
        for (ExamRoom room2 : rList)
        {
            for (Student student2 : sList)
            {
                if(student2.getAllocMark() == 0)
                {
                    int zid2 = student2.getzPref2();
                    int roomZone = room2.getZoneId();
                    if(room2.getFilledCapacity() < room2.getCapacity())
                    {
                        if(roomZone == zid2)
                        {
                            room2.setFilledCapacity((room2.getFilledCapacity())+1);
                            student2.setAllocRoom(room2.getRoomNo());
                            student2.setAllocMark(1);
                        }
                    }
                    
                }
            }
        }
        
        
        for (ExamRoom room3 : rList)
        {
            if(room3.getFilledCapacity() < room3.getCapacity())
            {
                for (Student student3 : sList)
                {
                    if(student3.getAllocMark() == 0)
                    {
                        room3.setFilledCapacity((room3.getFilledCapacity())+1);
                        student3.setAllocRoom(room3.getRoomNo());
                        student3.setAllocMark(1);
                    }
                }
            }
        }
        
        for (Student stu : sList)
        {
            System.out.println(stu.getStudentName()+" | "+stu.getzPref1()+" | "+stu.getzPref2()+" | "+stu.getAllocRoom());
        }
        
        for (ExamRoom rm : rList)
        {
            System.out.println(rm.getRoomNo()+" | "+rm.getCapacity()+" | "+rm.getFilledCapacity()+" | "+rm.getZoneId());
        }
        
        
    }
    
    
    public static void main(String[] args)
    {
        new SeatAllocation();
    }
    
}
