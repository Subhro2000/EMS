/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ems;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Subhro Ghosh
 */

public class FormFillupPage extends javax.swing.JFrame implements ListSelectionListener
{

    /**
     * Creates new form FormFillupPage
     */
    
    private ConnectionToDatabase cdb;
    private Connection conn;
    
    private DefaultComboBoxModel modelZone1;
    private DefaultComboBoxModel modelZone2;
    private DefaultComboBoxModel modelQual;
    
    private char AEN;
    
    private byte picBytes[];
    private byte sigBytes[];
    
    private DefaultListModel modelStudent;
    private int sid;

    
    public FormFillupPage()
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
        
        modelZone1 = new DefaultComboBoxModel();
        comboZone1.setModel(modelZone1);
        modelZone1.addElement("Select Preferred Zone 1");
        
        modelZone2 = new DefaultComboBoxModel();
        comboZone2.setModel(modelZone2);
        modelZone2.addElement("Select Preferred Zone 2");
        
        modelQual = new DefaultComboBoxModel();
        comboQual.setModel(modelQual);
        modelQual.addElement("Select Highest Education");
        
        spQualYear.setModel(new SpinnerNumberModel(2000, 1980, 2022, 1));
        
        modelStudent = new DefaultListModel();
        listStudents.setModel(modelStudent);
        listStudents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        try
        {
            getZoneNames();
            getQualifications();
            populateStudentList();
        } catch (SQLException ex)
        {
            Logger.getLogger(FormFillupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listStudents.addListSelectionListener(this);
        listStudents.setSelectedIndex(0);
        
        AEN = 'N';
        enableThem(false);
        
        this.setVisible(true);
        
    }
    
    
    private void getZoneNames() throws SQLException
    {
        String fetch = "SELECT * FROM ExamZone";

        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery(fetch);

        while(rs.next())
        {
            modelZone1.addElement(rs.getString("Name"));
            modelZone2.addElement(rs.getString("Name"));
        }
            
    }    
    
    private void getQualifications() throws SQLException
    {
        
        String fetch = "SELECT * FROM Qualification";
        
        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery(fetch);

        while(rs.next())
        {
            modelQual.addElement(rs.getString("Name"));
        }
            
    }    

    private void populateStudentList() throws SQLException
    {
        
        modelStudent.removeAllElements();
        
        String fetch = "SELECT Student_Id,Name,Email FROM Student";
        
        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery(fetch);

        while(rs.next())
        {
            modelStudent.addElement(rs.getInt("Student_Id")+". "+rs.getString("Name")+" | "+rs.getNString("Email"));
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

        grpGender = new javax.swing.ButtonGroup();
        compPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGurdianName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTransctionId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDOB = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        btnFemale = new javax.swing.JRadioButton();
        btnMale = new javax.swing.JRadioButton();
        comboQual = new javax.swing.JComboBox<>();
        lblPic = new javax.swing.JLabel();
        btnChoosePic = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblSig = new javax.swing.JLabel();
        btnChooseSig = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel15 = new javax.swing.JLabel();
        comboZone1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        comboZone2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        spQualYear = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        txtTransctionDt = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listStudents = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form FillUp Page");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        compPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0), 3));

        jLabel2.setText("Name");

        jLabel3.setText("Gurdian's Name");

        jLabel4.setText("Picture");

        jLabel5.setText("Transction Id.");

        jLabel6.setText("Mobile No.");

        jLabel7.setText("Qualification");

        jLabel8.setText("Email Id.");

        jLabel9.setText("Address");

        jLabel10.setText("D.O.B");

        jLabel11.setText("Gender");

        grpGender.add(btnFemale);
        btnFemale.setText("Female");

        grpGender.add(btnMale);
        btnMale.setText("Male");

        lblPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        btnChoosePic.setText("Choose...");
        btnChoosePic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChoosePic.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnChoosePicActionPerformed(evt);
            }
        });

        jLabel13.setText("Signature");

        lblSig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51)));

        btnChooseSig.setText("Choose...");
        btnChooseSig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChooseSig.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnChooseSigActionPerformed(evt);
            }
        });

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jLabel15.setText("Exam Zone 1");

        jLabel16.setText("Exam Zone 2");

        jLabel12.setText("Qualification Year");

        jLabel14.setText("Transction Date");

        javax.swing.GroupLayout compPanelLayout = new javax.swing.GroupLayout(compPanel);
        compPanel.setLayout(compPanelLayout);
        compPanelLayout.setHorizontalGroup(
            compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(336, 336, 336)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(txtGurdianName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(compPanelLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(compPanelLayout.createSequentialGroup()
                            .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGap(26, 26, 26)
                            .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(compPanelLayout.createSequentialGroup()
                                        .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88)
                                        .addComponent(jLabel11)
                                        .addGap(72, 72, 72)
                                        .addComponent(btnMale)
                                        .addGap(41, 41, 41)
                                        .addComponent(btnFemale)
                                        .addGap(50, 50, 50))
                                    .addGroup(compPanelLayout.createSequentialGroup()
                                        .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, compPanelLayout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnChoosePic)
                                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(compPanelLayout.createSequentialGroup()
                        .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(compPanelLayout.createSequentialGroup()
                                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel7))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, compPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboZone1, 0, 198, Short.MAX_VALUE)
                                .addComponent(comboQual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTransctionId, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSig, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(compPanelLayout.createSequentialGroup()
                                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnChooseSig)
                                    .addComponent(txtTransctionDt, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboZone2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spQualYear, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        compPanelLayout.setVerticalGroup(
            compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(txtGurdianName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(compPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(compPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel11))
                    .addComponent(btnMale)
                    .addComponent(btnFemale)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(compPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(compPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9)))
                .addGap(31, 31, 31)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboQual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(spQualYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTransctionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel14))
                    .addComponent(txtTransctionDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboZone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(comboZone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChoosePic)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(btnChooseSig))
                .addGap(29, 29, 29)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSig, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setText("List Of Students");
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 0)));

        listStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(listStudents);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(94, 94, 94))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/edit (1).png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/delete (1).png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/add-button - Copy.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/close.png"))); // NOI18N
        btnCancle.setText("Cancel");
        btnCancle.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnCancle)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSave)
                    .addComponent(btnEdit)
                    .addComponent(btnCancle)
                    .addComponent(btnDelete))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(compPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(compPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEditActionPerformed
    {//GEN-HEADEREND:event_btnEditActionPerformed
        // TODO add your handling code here:
        AEN = 'E';
        enableThem(true);
        txtName.requestFocus();
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteActionPerformed
    {//GEN-HEADEREND:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int index = listStudents.getSelectedIndex();
        int nextInd = index;
        if(index == modelStudent.getSize() -1)
            nextInd = index-1;
        
        try
        {
            PreparedStatement psmtD = conn.prepareStatement("DELETE FROM Student WHERE Student_ID = ?");
            psmtD.setInt(1, sid);

            int n = psmtD.executeUpdate();

            if(n>0)
            {
                reset();
                modelStudent.remove(index);
                listStudents.setSelectedIndex(nextInd);
            }

        } catch (SQLException ex)
        {
//            Logger.getLogger(ManageLibrarianPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        // TODO add your handling code here:
        reset();
        AEN = 'A';
        enableThem(true);
    }//GEN-LAST:event_btnAddActionPerformed

    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaveActionPerformed
    {//GEN-HEADEREND:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(isValidFields())
            saveToDB();
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void saveToDB()
    {
        String name = txtName.getText();
        String gName = txtGurdianName.getText();
        
        java.util.Date dob = txtDOB.getDate();
        Date sqlDob = new Date(dob.getTime());
        
        String gender;
        if(btnMale.isSelected())
            gender = "M";
        else
            gender = "F";
        
        String mobile = txtMobile.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String trnsId = txtTransctionId.getText();
        
        java.util.Date tranDt = txtTransctionDt.getDate();
        Date sqltranDt = new Date(tranDt.getTime());
        
        String pZone1 = (String) comboZone1.getSelectedItem();
        int ezId1 = getExamZoneId(pZone1);
        
        String pZone2 = (String) comboZone2.getSelectedItem();
        int ezId2 = getExamZoneId(pZone2);
        
        String qual = (String) comboQual.getSelectedItem();
        int qId = getQualificationId(qual);
        int qYear = (Integer)spQualYear.getValue();
        
        try
        {
            PreparedStatement psmt =null;
            
            if(AEN == 'A')
            {
                psmt = conn.prepareStatement("INSERT INTO Student (Name,Gurdian_Name,DOB,Gender,Mob_No,Email,"
                                                            + "Address,Qual_Id,Qual_Year,Transction_Id,Transction_Date,EPref_Zone1_Id,EPref_Zone2_Id,Pic,Sig) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            }
            
            else if(AEN == 'E')
            {
                psmt = conn.prepareStatement("UPDATE Student SET Name=?, Gurdian_Name=?, DOB=?, Gender=?, Mob_No=?, Email=?, Address=?,"
                    + "Qual_Id=?, Qual_Year=?,Transction_Id=?, Transction_Date=?, EPref_Zone1_Id=?, EPref_Zone2_Id=?, Pic=?, Sig=? WHERE Student_Id = ?");
                
                psmt.setInt(16, sid);
            }

            
            psmt.setString(1, name);
            psmt.setString(2, gName);
            psmt.setDate(3, sqlDob);
            psmt.setString(4, gender);
            psmt.setString(5, mobile);
            psmt.setString(6, email);
            psmt.setString(7, address);
            psmt.setInt(8, qId);
            psmt.setInt(9, qYear);
            psmt.setString(10, trnsId);
            psmt.setDate(11, sqltranDt);
            psmt.setInt(12, ezId1);
            psmt.setInt(13, ezId2);
            psmt.setBlob(14, new ByteArrayInputStream(picBytes));
            psmt.setBlob(15, new ByteArrayInputStream(sigBytes));
            
            int count = psmt.executeUpdate();

            if(count>0)
            {
                if(AEN == 'A')
                {
//                    JOptionPane.showMessageDialog(this, "Record Added!!!", "Successfull", JOptionPane.PLAIN_MESSAGE);
                    populateStudentList();
                    enableThem(false);
                }
                else if(AEN == 'E')
                {
//                    JOptionPane.showMessageDialog(this, "Record Updated!!!", "Successfull", JOptionPane.PLAIN_MESSAGE);
                    populateStudentList();
                    enableThem(false);
                }
            }
            
        } catch (SQLException ex)
        {
            Logger.getLogger(FormFillupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private boolean isValidFields()
    {
        if(isEmptyFields())
        {
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty!", "Error!!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        Pattern p;
        Matcher m;
        
        String namePattern = "(\\b[A-Z](([A-Z]*)|([a-z]*))\\b) (\\b[A-Z](([A-Z]*)|([a-z]*))\\b)";
        p = Pattern.compile(namePattern);
        m = p.matcher(txtName.getText());
        if(!m.matches())
        {
            JOptionPane.showMessageDialog(this, "Invalid Name Format!");
            txtName.requestFocus();
            return false;
        }
        
        m = p.matcher(txtGurdianName.getText());
        if(!m.matches())
        {
            JOptionPane.showMessageDialog(this, "Invalid Name Format!");
            txtGurdianName.requestFocus();
            return false;
        }
        
        String mobPattern = "((\\+?\\d{2}\\ ?)?(\\d{5}\\ ?\\d{5}))";
        p = Pattern.compile(mobPattern);
        m = p.matcher(txtMobile.getText());
        if(!m.matches())
        {
            JOptionPane.showMessageDialog(this, "Invalid Mobile Number");
            txtMobile.requestFocus();
            return false;
        }
        
        String emailPattern = "(\\w+\\.)*\\w+@\\w+\\.\\w+(\\.\\w+)?";
        p = Pattern.compile(emailPattern);
        m = p.matcher(txtEmail.getText());
        if(!m.matches())
        {
            JOptionPane.showMessageDialog(this, "Invalid Email");
            txtEmail.requestFocus();
            return false;
        }
        
        
        return true;
    }
     
    
    private boolean isEmptyFields()
    {
//        Component comp[] = compPanel.getComponents();
        for(Component comp : compPanel.getComponents())
        {
            if(comp instanceof JTextField)
            {
                if(((JTextField) comp).getText().isEmpty())
                    return true;
            }
            
//            if(comp instanceof JDateChooser)
//            {
//                if(((JDateChooser) comp).getDate() == null)
//            }
        }
        
        return false;
    }
    
    
    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancleActionPerformed
    {//GEN-HEADEREND:event_btnCancleActionPerformed
        // TODO add your handling code here:
        populateStudentForm(sid);
        enableThem(false);
    }//GEN-LAST:event_btnCancleActionPerformed

    private void btnChoosePicActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChoosePicActionPerformed
    {//GEN-HEADEREND:event_btnChoosePicActionPerformed
        // TODO add your handling code here:

        FileInputStream fis = chooseImage();

        picBytes = toByteArray(fis);
        try
        {
            fis.close();
            setPictureToLabel(new ByteArrayInputStream(picBytes), lblPic);
        } catch (IOException ex)
        {
            Logger.getLogger(FormFillupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnChoosePicActionPerformed

    private void btnChooseSigActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChooseSigActionPerformed
    {//GEN-HEADEREND:event_btnChooseSigActionPerformed
        // TODO add your handling code here:

        FileInputStream fis = chooseImage();

        sigBytes = toByteArray(fis);
        try
        {
            fis.close();
            setPictureToLabel(new ByteArrayInputStream(sigBytes), lblSig);
        } catch (IOException ex)
        {
            Logger.getLogger(FormFillupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnChooseSigActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        // TODO add your handling code here:
        cdb.closeConnection();
        new AdminHomePage();
        
    }//GEN-LAST:event_formWindowClosing

    private FileInputStream chooseImage()
    {
        File f = null;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("S:\\Javaprogram\\NetBeans\\ExaminationManagementSystem\\Sample Pic And Sig"));
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter1  = new FileNameExtensionFilter("JPEG Files", "JPG", "JPEG", "jpe", "jiff");
        chooser.addChoosableFileFilter(filter1);
        
        FileFilter filter2 = new FileNameExtensionFilter("BITMAP Files", ".bmp");
        chooser.addChoosableFileFilter(filter2);
        int result = chooser.showOpenDialog(this);
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
            f =chooser.getSelectedFile();            
        }
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(f);
            
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(FormFillupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fis;
    }
    
    private void setPictureToLabel(InputStream in, JLabel lbl)
    {
        try
        {
            BufferedImage bimg = ImageIO.read(in);
            
            double scale = getResizedScale(lbl.getWidth(), lbl.getHeight(), bimg.getWidth(),bimg.getHeight()) ;
            Image img = bimg.getScaledInstance((int)(bimg.getWidth() * scale), (int)(bimg.getHeight()*scale), Image.SCALE_SMOOTH) ;
            lbl.setIcon(new ImageIcon(img));
            
        } catch (IOException ex)
        {
            Logger.getLogger(FormFillupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private double getResizedScale(int vWd, int vHt, int iWd, int iHt)
    {                                 // viewPortWidth-Heigt and imageWidth-Height
        
        if(iWd <= vWd && iHt <= vHt)
            return 1 ;
        
        double vRatio = (double) vHt / vWd ;
        double iRatio = (double) iHt / iWd ;
        double scale ;
        
        if(vRatio > iRatio)
            // fit to width
            scale = (double) vWd / iWd ;
        else
            // fit to height
            scale = (double) vHt / iHt ;
            
        return scale ;
    }
    
    private int getExamZoneId(String zone)
    {
        int zid = 0;
        
        try
        {
            PreparedStatement psmt = conn.prepareStatement("SELECT Zone_Id FROM ExamZone WHERE Name = ?");
            psmt.setString(1, zone);
            ResultSet rs = psmt.executeQuery();
            
            if(rs.next())
            {
                zid = rs.getInt("Zone_Id");
            }
            
        } catch (SQLException ex)
        {
            Logger.getLogger(UserSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return zid;
    }

    private int getQualificationId(String qual)
    {
        int qid = 0;
        
        try
        {
            PreparedStatement psmt = conn.prepareStatement("SELECT Qual_Id FROM Qualification WHERE Name = ?");
            psmt.setString(1, qual);
            ResultSet rs = psmt.executeQuery();
            
            if(rs.next())
            {
                qid = rs.getInt("Qual_Id");
            }
            
        } catch (SQLException ex)
        {
            Logger.getLogger(UserSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return qid;
    }
    
    
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        String s = listStudents.getSelectedValue();
        if(s!=null)
        {
            int index = s.indexOf('.');
            sid = Integer.parseInt(s.substring(0, index));
            populateStudentForm(sid);
        }
        
    }
    
    private void populateStudentForm(int sid)
    {
        
        try
        {
            PreparedStatement psmt = conn.prepareStatement("SELECT * FROM Student WHERE Student_Id = ?");
            psmt.setInt(1, sid);
            ResultSet rs = psmt.executeQuery();
            
            if(rs.next())
            {
                txtName.setText(rs.getString("Name"));
                txtGurdianName.setText(rs.getString("Gurdian_Name"));
                txtMobile.setText(rs.getString("Mob_No"));
                txtEmail.setText(rs.getString("Email"));
                txtAddress.setText(rs.getString("Address"));
                txtTransctionId.setText(rs.getString("Transction_Id"));
                txtDOB.setDate(rs.getDate("DOB"));
                txtTransctionDt.setDate(rs.getDate("Transction_Date"));
                
                char gen = rs.getString("Gender").charAt(0);
                if(gen == 'M')
                    btnMale.setSelected(true);
                else
                    btnFemale.setSelected(true);
                
                comboQual.setSelectedIndex(rs.getInt("Qual_Id"));
                comboZone1.setSelectedIndex(rs.getInt("EPref_Zone1_Id"));
                comboZone2.setSelectedIndex(rs.getInt("EPref_Zone2_Id"));
                
                spQualYear.setValue(rs.getInt("Qual_Year"));
                
                InputStream iP = rs.getBinaryStream("Pic");
                InputStream iS = rs.getBinaryStream("Sig");
                
                picBytes = toByteArray(iP);
                sigBytes = toByteArray(iS);
                
                iP.close();
                iS.close();
                
                setPictureToLabel(new ByteArrayInputStream(picBytes), lblPic);
                setPictureToLabel(new ByteArrayInputStream(sigBytes), lblSig);
                
            }
            
        } catch (SQLException | IOException  ex)
        {
            Logger.getLogger(UserSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }
    
    private byte[] toByteArray(InputStream in)
    {
        try
        {
            ByteArrayOutputStream bos = new ByteArrayOutputStream(in.available());
            for(int b=in.read(); b!=-1; b=in.read() )
            {
                bos.write(b);
            }
            
            return bos.toByteArray();
        } catch (IOException ex)
        {
            Logger.getLogger(FormFillupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    private void reset()
    {
        Component c[] = compPanel.getComponents();
        for(Component cmp : c)
        {
            if(cmp instanceof JTextField)
                ((JTextField) cmp).setText("");
//            else if(cmp instanceof JTextArea)
//                ((JTextArea) cmp).setText("");
            else if(cmp instanceof JRadioButton)
                btnMale.setSelected(true);
            else if(cmp instanceof JComboBox)
                ((JComboBox) cmp).setSelectedIndex(0);
            else if(cmp instanceof JDateChooser)
            {
                GregorianCalendar gc = new GregorianCalendar();
                ((JDateChooser) cmp).setDate(gc.getTime());
//                txtDOB.setDate(gc.getTime());
            }
            else if(cmp instanceof JLabel)
                    ((JLabel) cmp).setIcon(null);
//            else if(cmp instanceof JSpinner)
//                cmp.setV
        }
        txtName.requestFocus();
        txtAddress.setText("");
//        listStudents.setSelectedValue(null, false);
    }
    
    
    private void enableThem(boolean enabled)
    {
        Component c[] = compPanel.getComponents();
        for(Component cmp : c)
        {
            if(cmp instanceof JTextField)
                ((JTextField) cmp).setEditable(enabled);
            else if(cmp instanceof JRadioButton)
                cmp.setEnabled(enabled);
            else if(cmp instanceof JComboBox )
                ((JComboBox)cmp).setEnabled(enabled);
            else if(cmp instanceof JDateChooser)
                cmp.setEnabled(enabled);
            else if(cmp instanceof JButton)
                cmp.setEnabled(enabled);
            else if(cmp instanceof JSpinner)
                cmp.setEnabled(enabled);
        }
        txtAddress.setEditable(enabled);
        
        btnAdd.setEnabled(!enabled);
        btnEdit.setEnabled(!enabled);
        btnDelete.setEnabled(!enabled);
        
        btnSave.setEnabled(enabled);
        btnCancle.setEnabled(enabled);
        
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
            java.util.logging.Logger.getLogger(FormFillupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FormFillupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FormFillupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FormFillupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new FormFillupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnChoosePic;
    private javax.swing.JButton btnChooseSig;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JRadioButton btnFemale;
    private javax.swing.JRadioButton btnMale;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboQual;
    private javax.swing.JComboBox<String> comboZone1;
    private javax.swing.JComboBox<String> comboZone2;
    private javax.swing.JPanel compPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.ButtonGroup grpGender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPic;
    private javax.swing.JLabel lblSig;
    private javax.swing.JList<String> listStudents;
    private javax.swing.JSpinner spQualYear;
    private javax.swing.JTextArea txtAddress;
    private com.toedter.calendar.JDateChooser txtDOB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGurdianName;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private com.toedter.calendar.JDateChooser txtTransctionDt;
    private javax.swing.JTextField txtTransctionId;
    // End of variables declaration//GEN-END:variables


}
