/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ems;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Subhro Ghosh
 */
public class GenRollPage extends javax.swing.JFrame
{

    /**
     * Creates new form RollNoGenPage
     */
    
    private ConnectionToDatabase cdb;
    private Connection conn;
    private DefaultListModel modelEligibleStudnts;
    private DefaultTableModel modelRoll;

    
    public GenRollPage()
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
        
        
        modelEligibleStudnts = new DefaultListModel();
        listEligibleStudent.setModel(modelEligibleStudnts);
        listEligibleStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        populateEligibleStudentList();
        
        Object cols[] = "Id,Name,Roll No".split(",");
        modelRoll = new DefaultTableModel(cols, 0);
        tableRollNo.setModel(modelRoll);
        
        populateRollTable();
        
        this.setVisible(true);
        
        if(tableRollNo.getRowCount()>0)
        {
            JOptionPane.showMessageDialog(this, "Roll No Already Generated!");
            btnGenerate.setEnabled(false);
        }
        
    }
    
    
    private void populateEligibleStudentList()
    {
        try
        {
            String fetch = "SELECT Student_Id,Name,Email FROM Student WHERE Roll_No !=0 ";
            
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(fetch);
            
            while(rs.next())
            {
                modelEligibleStudnts.addElement(rs.getInt("Student_Id")+". "+rs.getString("Name")+" | "+rs.getString("Email"));
            }
            
        } catch (SQLException ex)
        {
//            Logger.getLogger(EligibilityPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void genRoll()
    {
        
        try
        {
            PreparedStatement psmt = conn.prepareStatement("SELECT * FROM SeatAlloc");
            ResultSet rs = psmt.executeQuery();
            
            int count = 0;
            while(rs.next())
            {
                count++;
                int cid = rs.getInt("Center_Id");
                String rNo = rs.getString("Room_No");
                int sid = rs.getInt("Student_Id");
                String zRno = "0".repeat(5-rNo.length())+rNo;
                
                String out = String.format("%d%02d%5s%03d%03d", 24,cid,zRno,sid, count);
                updateRoll(out, sid);
            }
            
        } catch (SQLException ex)
        {
            Logger.getLogger(GenRollPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateRoll(String roll, int sid)
    {
        try
        {
            PreparedStatement psmt = conn.prepareStatement("UPDATE Student SET Roll_No = ? WHERE Roll_No = 1 AND Student_Id = ?");
            psmt.setString(1, roll);
            psmt.setInt(2, sid);
            
            int count = psmt.executeUpdate();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(GenRollPage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listEligibleStudent = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRollNo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Roll No Page");
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));

        jScrollPane2.setViewportView(listEligibleStudent);

        jScrollPane1.setViewportView(tableRollNo);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("List of All Students");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("List of Eligible Students");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 204, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                .addGap(16, 16, 16))
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
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(btnGenerate)
                        .addGap(27, 27, 27)
                        .addComponent(btnCancle)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancle)
                    .addComponent(btnGenerate))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGenerateActionPerformed
    {//GEN-HEADEREND:event_btnGenerateActionPerformed
        
        genRoll();
        populateRollTable();
        JOptionPane.showMessageDialog(this, "Roll No Generated Successfully!");
        btnGenerate.setEnabled(false);

    }//GEN-LAST:event_btnGenerateActionPerformed

    private void populateRollTable()
    {
        try
        {
            PreparedStatement psmt = conn.prepareStatement("SELECT Student_Id, Name, Roll_No FROM Student WHERE Roll_No != \"0\" ");
            
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next())
            {
                Object ar[] = {rs.getInt("Student_Id"), rs.getString("Name"), rs.getString("Roll_No")};
                modelRoll.addRow(ar);
            }
            
            
        } catch (SQLException ex)
        {
            Logger.getLogger(GenRollPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancleActionPerformed
    {//GEN-HEADEREND:event_btnCancleActionPerformed
        // TODO add your handling code here:
        cdb.closeConnection();
        this.setVisible(false);
        new AdminHomePage();

    }//GEN-LAST:event_btnCancleActionPerformed

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
            java.util.logging.Logger.getLogger(GenRollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GenRollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GenRollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GenRollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GenRollPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listEligibleStudent;
    private javax.swing.JTable tableRollNo;
    // End of variables declaration//GEN-END:variables
}
