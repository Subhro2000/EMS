/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Subhro Ghosh
 */
public class UploadQuestionPage extends javax.swing.JFrame
{

    /**
     * Creates new form UploadQuestionPage
     */
    
    private ConnectionToDatabase cdb;
    private Connection conn;
    
    FileInputStream fisQ;
    DefaultTableModel modelPapers;
    
    
    public UploadQuestionPage()
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
        
        String colName[] = "ID, Paper Name, Examiner Name, Upload Date".split(",");
        modelPapers = new DefaultTableModel(colName, 0);
        tableQuestions.setModel(modelPapers);
        
        populateQuestionsTable();
        
        this.setVisible(true);
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
        jLabel2 = new javax.swing.JLabel();
        txtPaperName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableQuestions = new javax.swing.JTable();
        btnCancelCenter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Upload Question Page");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Paper Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Select Paper");

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBrowseActionPerformed(evt);
            }
        });

        btnUpload.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/upload.png"))); // NOI18N
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPath, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPaperName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addComponent(btnUpload)
                .addGap(223, 223, 223))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaperName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnUpload)
                .addGap(23, 23, 23))
        );

        jScrollPane1.setViewportView(tableQuestions);

        btnCancelCenter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/close.png"))); // NOI18N
        btnCancelCenter.setText("Cancel");
        btnCancelCenter.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelCenterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnCancelCenter)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelCenter)
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelCenterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelCenterActionPerformed
    {//GEN-HEADEREND:event_btnCancelCenterActionPerformed
        // TODO add your handling code here:
        cdb.closeConnection();
        this.setVisible(false);
        new ExaminerHomePage();

    }//GEN-LAST:event_btnCancelCenterActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBrowseActionPerformed
    {//GEN-HEADEREND:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        File f = null;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("S:\\Javaprogram\\NetBeans\\ExaminationManagementSystem\\Sample Pic And Sig"));
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter1  = new FileNameExtensionFilter("PDF Files", "PDF");
        chooser.addChoosableFileFilter(filter1);
        
        int result = chooser.showOpenDialog(this);
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
            f =chooser.getSelectedFile();  
            txtPath.setText(f.getPath());
        }
        
//        FileInputStream fis = null;
        try
        {
            fisQ = new FileInputStream(f);
            
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(FormFillupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnBrowseActionPerformed

    private int getUserId(String uName)
    {
        int uId = 0;
        
        try
        {
            PreparedStatement psmt = conn.prepareStatement("SELECT Id FROM Users WHERE Name = ?");
            psmt.setString(1, uName);
            ResultSet rs = psmt.executeQuery();
            
            if(rs.next())
            {
                uId = rs.getInt("Id");
            }
            
        } catch (SQLException ex)
        {
            Logger.getLogger(UserSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return uId;
    }
    
    
    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUploadActionPerformed
    {//GEN-HEADEREND:event_btnUploadActionPerformed
        // TODO add your handling code here:
        
        String paperName = txtPaperName.getText();
        String uName = ExaminerLoginPage.name;
        int userId = getUserId(uName);
        
        GregorianCalendar gcd = new GregorianCalendar();
        Date dt = new Date(gcd.getTimeInMillis());
        
        try
        {
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO QuestionPaper (Paper_Name, User_Id, Upload_Date, Paper) VALUES(?,?,?,?)");
            
            psmt.setString(1, paperName);
            psmt.setInt(2, userId);
            psmt.setDate(3, dt);
            psmt.setBlob(4, fisQ);
            
            int c = psmt.executeUpdate();
            if(c>0)
            {
                populateQuestionsTable();
            }
            else
                System.out.println("Wromg");
                    
                    
        } catch (SQLException ex)
        {
            Logger.getLogger(UploadQuestionPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnUploadActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        // TODO add your handling code here:
        cdb.closeConnection();
        new ExaminerHomePage();
        
    }//GEN-LAST:event_formWindowClosing

    private void populateQuestionsTable()
    {
        try
        {
            modelPapers.setRowCount(0);
            
            String fetch = "SELECT Question_Id, Paper_Name, u.Name, Upload_Date FROM QuestionPaper p, Users u WHERE p.User_Id = u.Id ";
            
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(fetch);
            
            while(rs.next())
            {
                Object recArr [] = { rs.getInt("Question_Id"), rs.getString("Paper_Name"), rs.getString("u.Name"), rs.getDate("Upload_Date")};
                modelPapers.addRow(recArr);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(UploadQuestionPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(UploadQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(UploadQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(UploadQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(UploadQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new UploadQuestionPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancelCenter;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableQuestions;
    private javax.swing.JTextField txtPaperName;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}