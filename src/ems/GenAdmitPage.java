/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ems;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Subhro Ghosh
 */
public class GenAdmitPage extends javax.swing.JFrame
{

    /**
     * Creates new form GenAdmitPage
     */
    
    private ConnectionToDatabase cdb;
    private Connection conn;
    private DefaultTableModel modelStudents;
    
    private final String PATH = "S:\\Javaprogram\\NetBeans\\ExaminationManagementSystem\\html&css\\admit";
    private final String OUTPUT_FILE_NAME = "generated-admit.html";
    private final String INPUT_HEADER_FILE_NAME = "master-admit-head.html";
    private final String INPUT_BODY_FILE_NAME = "master-admit-body.html";
    
    public GenAdmitPage()
    {
        initComponents();
        
        cdb = new ConnectionToDatabase();
        
        try
        {
            conn = cdb.startConnection();
        } catch (SQLException ex)
        {
//            Logger.getLogger(UserSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object cols[] = "Name,Gurdian Name,D.O.B,Gender,Roll No, Center Name".split(",");
        modelStudents = new DefaultTableModel(cols, 0);
        tableStudents.setModel(modelStudents);
        
        populateStudentTable();
        
        this.setVisible(true);
        
        File f = new File(PATH, OUTPUT_FILE_NAME);
        
        if(f.exists())
        {
            JOptionPane.showMessageDialog(this, "Admit Card Already Generated!");
            btnGenerate.setEnabled(false);
            btnView.setEnabled(true);
        }
        else
        {
            btnGenerate.setEnabled(true);
            btnView.setEnabled(false);
        }
    }
    
    
    private void populateStudentTable()
    {
        ResultSet rs = getStudentDetails();
//        int count =1;
        try
        {
            while(rs.next())            
            {
                Object ar[] = {rs.getString("sname"), rs.getString("s.Gurdian_Name"), rs.getDate("s.DOB").toString(), rs.getString("s.Gender"), 
                                         rs.getString("s.Roll_No"), rs.getString("cname")};
                modelStudents.addRow(ar);
                
//                InputStream ip = rs.getBinaryStream("s.Pic");
//                
//                FileOutputStream fos = new FileOutputStream("html&css\\admit\\PICC"+count+".jpg");
//                
//                for(int b = ip.read(); b!= -1; b=ip.read())
//                    fos.write(b);
//                fos.close();
//                count++;
                
            }
        } catch (Exception ex)
        {
            Logger.getLogger(GenAdmitPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void genAdmit() throws FileNotFoundException, SQLException
    {
        
        String examName = null;
        String examdate = null;
        String rpTime = null;
        String gcTime = null;
        String examTime = null;
        
        
        ResultSet rs2 = getPrefDetails();
        
        while(rs2.next())
        {
            examName = rs2.getString("Exam_Name");
            examdate = rs2.getDate("Exam_Date").toString();
            rpTime = rs2.getString("Reporting_Time");
            gcTime = rs2.getString("Gate_Closeing_Time");
            examTime = rs2.getString("Exam_Time");
        }
        
        
        //Save the header
        StringBuilder sb = readHtmlFile(PATH+"\\"+INPUT_HEADER_FILE_NAME);
        PrintWriter pw = new PrintWriter(new File(PATH, OUTPUT_FILE_NAME));
        pw.println(sb.toString());
        
        //Save the body
        pw.println("<body>");
        
        String strMasterBody = readHtmlFile(PATH+"\\"+INPUT_BODY_FILE_NAME).toString();
        record NameValue(String name, String value){}
         NameValue ar[] = new NameValue[12];
         
         ResultSet rs = getStudentDetails();
         
         while(rs.next())
         {
            sb = new StringBuilder(strMasterBody);
            
            ar[0] = new NameValue("name",rs.getString("sname"));
            ar[1] = new NameValue("gname",rs.getString("s.Gurdian_Name"));
            ar[2] = new NameValue("dob",rs.getDate("s.DOB").toString());
            ar[3] = new NameValue("gender",rs.getString("s.Gender"));
            ar[4] = new NameValue("roll",rs.getString("s.Roll_No"));
            ar[5] = new NameValue("centername",rs.getString("cname"));
            ar[6] = new NameValue("address",rs.getString("c.Address"));
            ar[7] = new NameValue("heading",examName);
            ar[8] = new NameValue("edate",examdate);
            ar[9] = new NameValue("rtime",rpTime);
            ar[10] = new NameValue("gtime",gcTime);
            ar[11] = new NameValue("etime",examTime);
//            ar[12] = new NameValue("pic","PICC"+count+".jpg");
            
            for (NameValue nv : ar)
            {
                replaceAll(sb, "%"+nv.name+"%", nv.value);
            }
            
            pw.println(sb.toString());
         }
        
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
    
    private StringBuilder readHtmlFile(String inputFileName) throws FileNotFoundException
    {
        StringBuilder sb = new StringBuilder();
        
        Scanner sc = new Scanner(new FileInputStream(inputFileName));
        while(sc.hasNextLine())
        {
            sb.append(sc.nextLine());
            sb.append("\n");
        }
        sc.close();
        return sb;
    }
    
    private void replaceAll(StringBuilder sb, String what, String with)
    {
        int p =0;
        while(true)
        {
            p = sb.indexOf(what,p);
            if(p<0)
                break;
            
            sb.replace(p, p+what.length(), with);
            p+= with.length();
        }
        
    }
    
//    private void replaceAll(StringBuilder sb, String what, String with)
//    {
//        
//        Pattern p = Pattern.compile("("+what+")");
//        Matcher m = p.matcher(sb);
//        while(m.find())
//        {
//            int start = m.start();
//            int end = m.end();
//            String s = sb.substring(start, end);
//            sb.replace(start, end, with);
//        }
//    }
    
    private ResultSet getStudentDetails()
    {
        String fetch = "SELECT s.Name AS sname, s.Gurdian_Name, s.DOB, s.Gender, s.Roll_no, s.Pic, c.Name AS cname, c.Address FROM SeatAlloc a, Student s, ExamCenter c "+
                                "WHERE s.Student_Id = a.Student_Id AND a.Center_Id = c.Center_Id";
        
        
        ResultSet rs = null;
        try
        {
            PreparedStatement psmt = conn.prepareStatement(fetch);
            
            rs = psmt.executeQuery();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(GenAdmitPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
        
    }
    
    private ResultSet getPrefDetails()
    {
        
        ResultSet rs = null;
        try
        {
            PreparedStatement psmt = conn.prepareStatement("SELECT * FROM Preferences");
            rs = psmt.executeQuery();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(GenAdmitPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admit Page");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 3));

        tableStudents.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(tableStudents);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("List of Eligible Students");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 204, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addGap(289, 289, 289))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btnGenerate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/pencil.png"))); // NOI18N
        btnGenerate.setText("Generate");
        btnGenerate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGenerateActionPerformed(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/view.png"))); // NOI18N
        btnView.setText("View");
        btnView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnView.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnViewActionPerformed(evt);
            }
        });

        btnCancle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/close.png"))); // NOI18N
        btnCancle.setText("Cancel");
        btnCancle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancle.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(btnGenerate)
                        .addGap(18, 18, 18)
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancle)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnGenerate)
                    .addComponent(btnCancle))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnViewActionPerformed
    {//GEN-HEADEREND:event_btnViewActionPerformed
        // TODO add your handling code here:
        if(!Desktop.isDesktopSupported())
            System.out.println("Desktop not supported");
        else
        {
            try
            {
                Desktop dtp = Desktop.getDesktop() ;
                
                dtp.open(new File(PATH, OUTPUT_FILE_NAME));
            } catch (IOException ex)
            {
                Logger.getLogger(GenAdmitPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancleActionPerformed
    {//GEN-HEADEREND:event_btnCancleActionPerformed
        // TODO add your handling code here:
        cdb.closeConnection();
        this.setVisible(false);
        new AdminHomePage();
    }//GEN-LAST:event_btnCancleActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGenerateActionPerformed
    {//GEN-HEADEREND:event_btnGenerateActionPerformed
        try
        {
            // TODO add your handling code here:
            genAdmit();
            JOptionPane.showMessageDialog(this, "Admit Card Generated");
            btnGenerate.setEnabled(false);
            btnView.setEnabled(true);
            
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(GenAdmitPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(GenAdmitPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        // TODO add your handling code here:
        cdb.closeConnection();
        new AdminHomePage();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(GenAdmitPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GenAdmitPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GenAdmitPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GenAdmitPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GenAdmitPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStudents;
    // End of variables declaration//GEN-END:variables
}
