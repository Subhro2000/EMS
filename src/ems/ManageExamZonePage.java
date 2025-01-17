/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ems;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Subhro Ghosh
 */
public class ManageExamZonePage extends javax.swing.JFrame
{

    /**
     * Creates new form AddExamZoneAndCenter
     */
    
    private ConnectionToDatabase cdb;
    private Connection conn;
    private DefaultListModel modelZone;
    
    public ManageExamZonePage()
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
        
        modelZone = new DefaultListModel();
        listZones.setModel(modelZone);
        listZones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        populateZoneList();
        
        this.setVisible(true);
        
    }
    
    private void populateZoneList()
    {
        
        modelZone.removeAllElements();
        
        String fetch = "SELECT * FROM ExamZone";
        try
        {
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(fetch);
            
            while(rs.next())
            {
                modelZone.addElement(rs.getInt("Zone_Id")+".    "+rs.getString("Name"));
            }
            
        } catch (SQLException ex)
        {
            System.out.println("Fetch data fail");
            Logger.getLogger(ManageExamZonePage.class.getName()).log(Level.SEVERE, null, ex);
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

        btnCLose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtZoneName = new javax.swing.JTextField();
        btnDeleteZone = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listZones = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnAddZone = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Zone Page");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        btnCLose.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCLose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images&icons/close.png"))); // NOI18N
        btnCLose.setText("Close");
        btnCLose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCLose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCLoseActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153), 3));

        txtZoneName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnDeleteZone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDeleteZone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images&icons/delete (1).png"))); // NOI18N
        btnDeleteZone.setText("Delete");
        btnDeleteZone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteZone.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteZoneActionPerformed(evt);
            }
        });

        listZones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(listZones);

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel1.setText("Enter Zone Name");

        btnAddZone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAddZone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images&icons/add-button - Copy.png"))); // NOI18N
        btnAddZone.setText("Add");
        btnAddZone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddZone.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddZoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddZone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteZone))
                    .addComponent(txtZoneName))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtZoneName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddZone)
                    .addComponent(btnDeleteZone))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnCLose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCLose)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddZoneActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddZoneActionPerformed
    {//GEN-HEADEREND:event_btnAddZoneActionPerformed
        // TODO add your handling code here:

        String zone = txtZoneName.getText();

        try
        {
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO ExamZone SET Name = ?");
            psmt.setString(1, zone);

            int count = psmt.executeUpdate();

            if(count>0)
            {
//                System.out.println("Insert Successfull");
                populateZoneList();
                txtZoneName.setText("");
            }
            else
                System.out.println("Insert Fail");

        } catch (SQLException ex)
        {
            Logger.getLogger(ManageExamZonePage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddZoneActionPerformed

    
    private void btnDeleteZoneActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteZoneActionPerformed
    {//GEN-HEADEREND:event_btnDeleteZoneActionPerformed
        // TODO add your handling code here:

        String selectedZoneName = listZones.getSelectedValue();
        int ind = selectedZoneName.indexOf(".");
        String s = selectedZoneName.substring(ind+1).trim();
        
        try
        {
            PreparedStatement psmtD = conn.prepareStatement("DELETE FROM ExamZone WHERE Name = ?");
            psmtD.setString(1, s);

            int n = psmtD.executeUpdate();

            if(n>0)
            {
                populateZoneList();
//                JOptionPane.showMessageDialog(this, "Record Deleted!");
            }
            else
            {
                System.out.println("Record Not Deleted");
                //                        JOptionPane.showMessageDialog(this, "Record Not Deleted");
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(ManageExamZonePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteZoneActionPerformed

    private void btnCLoseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCLoseActionPerformed
    {//GEN-HEADEREND:event_btnCLoseActionPerformed
        // TODO add your handling code here:

        cdb.closeConnection();
        this.setVisible(false);
        new AdminHomePage();

    }//GEN-LAST:event_btnCLoseActionPerformed

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
            java.util.logging.Logger.getLogger(ManageExamZonePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ManageExamZonePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ManageExamZonePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ManageExamZonePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ManageExamZonePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddZone;
    private javax.swing.JButton btnCLose;
    private javax.swing.JButton btnDeleteZone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listZones;
    private javax.swing.JTextField txtZoneName;
    // End of variables declaration//GEN-END:variables


}
