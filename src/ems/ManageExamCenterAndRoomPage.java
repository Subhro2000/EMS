/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ems;

import java.awt.Component;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Subhro Ghosh
 */
public class ManageExamCenterAndRoomPage extends javax.swing.JFrame implements ListSelectionListener
{

    /**
     * Creates new form AddExamCenterAndRoomPage
     */
    
    private ConnectionToDatabase cdb;
    private Connection conn;
    
    private DefaultComboBoxModel modelZone;
    private DefaultComboBoxModel modelCenter;
    
    DefaultTableModel modelCenterTable;
    DefaultTableModel modelRoomTable;
    
    private char AEN;
    private int cidC;
    private int rowC;
    
    private String rNo;
    private int rowR;
    private int cidR;
    
    public ManageExamCenterAndRoomPage()
    {
        initComponents();
        this.setVisible(true);
        
        cdb = new ConnectionToDatabase();
        
        try
        {
            conn = cdb.startConnection();
        } catch (SQLException ex)
        {
//            Logger.getLogger(UserSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modelZone = new DefaultComboBoxModel();
        comboZone.setModel(modelZone);
        modelZone.addElement("Select Zone");
        
        modelCenter = new DefaultComboBoxModel();
        comboCenter.setModel(modelCenter);
        modelCenter.addElement("Select Center");
        
        String colNames[] = "Center Id,Name,Address,Center No,Zone".split(",");
        modelCenterTable = new DefaultTableModel(colNames, 0);
        tableCenter.setModel(modelCenterTable);
        
        String colNamesRoom[] = "Center Id,Name,Room No,Capacity".split(",");
        modelRoomTable = new DefaultTableModel(colNamesRoom, 0);
        tableRoom.setModel(modelRoomTable);
        
        try
        {
            populateZone();
            populateCenter();
            populateCenterTable();
            populateRoomTable();
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageExamCenterAndRoomPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableCenter.getSelectionModel().addListSelectionListener(this);
        tableCenter.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableCenter.setRowSelectionInterval(0, 0);
        
        tableRoom.getSelectionModel().addListSelectionListener(this);
        tableRoom.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableRoom.setRowSelectionInterval(0, 0);
        
        AEN ='N';
        enableCnterForm(false);
        enableRoomForm(false);
        
        enablePanel(true);

    }
    
    private void populateZone() throws SQLException
    {
        
        String fetch = "SELECT * FROM ExamZone";

        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery(fetch);

        while(rs.next())
        {
            modelZone.addElement(rs.getString("Name"));
        }
    }
    
    private void populateCenter() throws SQLException
    {
        
        String fetch = "SELECT Name FROM ExamCenter";

        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery(fetch);

        while(rs.next())
        {
            modelCenter.addElement(rs.getString("Name"));
        }
    }
    
    private void populateCenterTable() throws SQLException
    {
        modelCenterTable.setRowCount(0);
        
        String fetch = "SELECT c.Center_ID, c.Name, c.Address, c.Center_No, z.Name  FROM ExamCenter c, ExamZone z WHERE c.Zone_Id = z.Zone_id";

        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery(fetch);

        while(rs.next())
        {
            Object recArr [] = { rs.getInt("c.Center_Id"), rs.getString("c.Name"), rs.getString("c.Address"), rs.getString("c.Center_No"), rs.getString("z.Name")};
            modelCenterTable.addRow(recArr);
        }
        
    }
    
    private void populateRoomTable() throws SQLException
    {
     
        modelRoomTable.setRowCount(0);
        
        String fetch = "SELECT r.Center_ID, c.Name, r.Room_No, r.Capacity FROM ExamCenter c, CenterRoom r WHERE c.Center_Id = r.Center_id";

        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery(fetch);

        while(rs.next())
        {
            Object recArr [] = { rs.getInt("r.Center_Id"), rs.getString("c.Name"), rs.getString("r.Room_No"), rs.getInt("r.Capacity")};
            modelRoomTable.addRow(recArr);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        centerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboZone = new javax.swing.JComboBox<>();
        txtCenterName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCenterAddress = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCenter = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtCenterNo = new javax.swing.JTextField();
        panelCenterBtn = new javax.swing.JPanel();
        btnAddCenter = new javax.swing.JButton();
        btnSaveCenter = new javax.swing.JButton();
        btnDeleteCenter = new javax.swing.JButton();
        btnEditCenter = new javax.swing.JButton();
        btnCancelCenter = new javax.swing.JButton();
        roomPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboCenter = new javax.swing.JComboBox<>();
        txtRoomNo = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableRoom = new javax.swing.JTable();
        txtCapacity = new javax.swing.JTextField();
        panelRoomBtn = new javax.swing.JPanel();
        btnDeleteRoom = new javax.swing.JButton();
        btnEditRoom = new javax.swing.JButton();
        btnCancelRoom = new javax.swing.JButton();
        btnAddRoom = new javax.swing.JButton();
        btnSaveRoom = new javax.swing.JButton();
        btnManageCenter = new javax.swing.JButton();
        btnManageRoom = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        centerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 3), "Manage Exam Center", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 24), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Select Zone");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Center Name");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Address");

        txtCenterAddress.setColumns(20);
        txtCenterAddress.setRows(5);
        jScrollPane1.setViewportView(txtCenterAddress);

        tableCenter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane3.setViewportView(tableCenter);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Center No.");

        btnAddCenter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/add-button - Copy.png"))); // NOI18N
        btnAddCenter.setText("Add");
        btnAddCenter.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddCenterActionPerformed(evt);
            }
        });

        btnSaveCenter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaveCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/save.png"))); // NOI18N
        btnSaveCenter.setText("Save");
        btnSaveCenter.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSaveCenterActionPerformed(evt);
            }
        });

        btnDeleteCenter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/delete (1).png"))); // NOI18N
        btnDeleteCenter.setText("Delete");
        btnDeleteCenter.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteCenterActionPerformed(evt);
            }
        });

        btnEditCenter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/edit (1).png"))); // NOI18N
        btnEditCenter.setText("Edit");
        btnEditCenter.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEditCenterActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelCenterBtnLayout = new javax.swing.GroupLayout(panelCenterBtn);
        panelCenterBtn.setLayout(panelCenterBtnLayout);
        panelCenterBtnLayout.setHorizontalGroup(
            panelCenterBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddCenter)
                .addGap(18, 18, 18)
                .addComponent(btnEditCenter)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteCenter)
                .addGap(18, 18, 18)
                .addComponent(btnSaveCenter)
                .addGap(18, 18, 18)
                .addComponent(btnCancelCenter)
                .addContainerGap())
        );
        panelCenterBtnLayout.setVerticalGroup(
            panelCenterBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCenterBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCenter)
                    .addComponent(btnSaveCenter)
                    .addComponent(btnEditCenter)
                    .addComponent(btnCancelCenter)
                    .addComponent(btnDeleteCenter))
                .addContainerGap())
        );

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(panelCenterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(txtCenterName)
                            .addComponent(comboZone, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCenterNo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboZone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCenterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(centerPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel5))
                            .addGroup(centerPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCenterNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(panelCenterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        roomPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0), 3), "Manage Center Room", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 24), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Select Center");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Room No.");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Capacity");

        jScrollPane5.setViewportView(tableRoom);

        btnDeleteRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/delete (1).png"))); // NOI18N
        btnDeleteRoom.setText("Delete");
        btnDeleteRoom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteRoomActionPerformed(evt);
            }
        });

        btnEditRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/edit (1).png"))); // NOI18N
        btnEditRoom.setText("Edit");
        btnEditRoom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEditRoomActionPerformed(evt);
            }
        });

        btnCancelRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/close.png"))); // NOI18N
        btnCancelRoom.setText("Cancel");
        btnCancelRoom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelRoomActionPerformed(evt);
            }
        });

        btnAddRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/add-button - Copy.png"))); // NOI18N
        btnAddRoom.setText("Add");
        btnAddRoom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddRoomActionPerformed(evt);
            }
        });

        btnSaveRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaveRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/save.png"))); // NOI18N
        btnSaveRoom.setText("Save");
        btnSaveRoom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSaveRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoomBtnLayout = new javax.swing.GroupLayout(panelRoomBtn);
        panelRoomBtn.setLayout(panelRoomBtnLayout);
        panelRoomBtnLayout.setHorizontalGroup(
            panelRoomBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoomBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddRoom)
                .addGap(18, 18, 18)
                .addComponent(btnEditRoom)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteRoom)
                .addGap(18, 18, 18)
                .addComponent(btnSaveRoom)
                .addGap(18, 18, 18)
                .addComponent(btnCancelRoom)
                .addContainerGap())
        );
        panelRoomBtnLayout.setVerticalGroup(
            panelRoomBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoomBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoomBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddRoom)
                    .addComponent(btnSaveRoom)
                    .addComponent(btnEditRoom)
                    .addComponent(btnCancelRoom)
                    .addComponent(btnDeleteRoom))
                .addContainerGap())
        );

        javax.swing.GroupLayout roomPanelLayout = new javax.swing.GroupLayout(roomPanel);
        roomPanel.setLayout(roomPanelLayout);
        roomPanelLayout.setHorizontalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRoomNo)
                    .addComponent(comboCenter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(panelRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomPanelLayout.createSequentialGroup()
                        .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(comboCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnManageCenter.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        btnManageCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/up-arrow.png"))); // NOI18N
        btnManageCenter.setText("Manage Centers");
        btnManageCenter.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnManageCenterActionPerformed(evt);
            }
        });

        btnManageRoom.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        btnManageRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images&Icons/down-arrow (1).png"))); // NOI18N
        btnManageRoom.setText("Manage Rooms");
        btnManageRoom.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnManageRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(btnManageCenter)
                .addGap(70, 70, 70)
                .addComponent(btnManageRoom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageCenter)
                    .addComponent(btnManageRoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCenterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddCenterActionPerformed
    {//GEN-HEADEREND:event_btnAddCenterActionPerformed
        // TODO add your handling code here:
        resetCenterForm();
        AEN = 'A';
        enableCnterForm(true);
    }//GEN-LAST:event_btnAddCenterActionPerformed

    private void btnEditCenterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEditCenterActionPerformed
    {//GEN-HEADEREND:event_btnEditCenterActionPerformed
        // TODO add your handling code here:
        AEN = 'E';
        enableCnterForm(true);
        txtCenterName.requestFocus();
    }//GEN-LAST:event_btnEditCenterActionPerformed

    private void btnDeleteCenterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteCenterActionPerformed
    {//GEN-HEADEREND:event_btnDeleteCenterActionPerformed
        // TODO add your handling code here:
        
        int index = tableCenter.getSelectedRow();
        int nxtInd = index;
        if(index == tableCenter.getRowCount())
            nxtInd = index-1;
        
        
        try
        {
            PreparedStatement psmtD = conn.prepareStatement("DELETE FROM ExamCenter WHERE Center_Id = ?");
            psmtD.setInt(1, cidC);

            int n = psmtD.executeUpdate();

            if(n>0)
            {
                resetCenterForm();
                modelCenterTable.removeRow(index);
                tableCenter.getSelectionModel().setSelectionInterval(nxtInd, nxtInd);
            }
            else
            {
//                JOptionPane.showMessageDialog(this, "Record Not Deleted");
            }

        } catch (SQLException ex)
        {
//            Logger.getLogger(ManageLibrarianPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDeleteCenterActionPerformed

    private void btnSaveCenterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaveCenterActionPerformed
    {//GEN-HEADEREND:event_btnSaveCenterActionPerformed
        // TODO add your handling code here:

        String name = txtCenterName.getText();
        String address = txtCenterAddress.getText();
        String centerNo = txtCenterNo.getText();
        String zone = (String)comboZone.getSelectedItem();

        try
        {
            PreparedStatement psmt =null;
            String query;
            
            if(AEN == 'A')
            {
                query = "INSERT INTO ExamCenter(Name,Address,Zone_Id,Center_No) "
                                        + "VALUES(?, ?, (SELECT Zone_Id FROM ExamZone WHERE Name = ?), ?)";
                
                psmt = conn.prepareStatement(query);
                
            }

            else if(AEN == 'E')
            {
                query = "UPDATE ExamCenter SET Name = ?, Address = ?, Zone_Id  = (SELECT Zone_Id FROM ExamZone WHERE Name = ?), Center_No = ?"
                        + "WHERE Center_Id = ?";
                
                psmt = conn.prepareStatement(query);
                
                psmt.setInt(5, cidC);
            }

            psmt.setString(1, name);
            psmt.setString(2, address);
            psmt.setString(3, zone);
            psmt.setString(4, centerNo);
            
            int count = psmt.executeUpdate();

            if(count>0)
            {
                if(AEN == 'A')
                {
                    populateCenterTable();
                    enableCnterForm(false);
                    modelCenter.addElement(name);
                }
                else if(AEN == 'E')
                {
                    populateCenterTable();
                    enableCnterForm(false);
                }
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(FormFillupPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSaveCenterActionPerformed

    private void btnCancelCenterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelCenterActionPerformed
    {//GEN-HEADEREND:event_btnCancelCenterActionPerformed
        // TODO add your handling code here:
        enableCnterForm(false);
        populateCenterDetails();
    }//GEN-LAST:event_btnCancelCenterActionPerformed

    
    private void resetCenterForm()
    {
        Component cCenter[] = centerPanel.getComponents();
        for (Component comp : cCenter)
        {
            if(comp instanceof JTextField)
                ((JTextField) comp).setText(" ");
            else if(comp instanceof JComboBox)
                ((JComboBox) comp).setSelectedIndex(0);
        
            txtCenterAddress.setText(" ");
            txtCenterName.requestFocus();
        }
            
    }
    
    private void enableCnterForm(boolean enabled)
    {
        txtCenterName.setEditable(enabled);
        txtCenterNo.setEditable(enabled);
        txtCenterAddress.setEditable(enabled);
        
        comboZone.setEnabled(enabled);
        
        btnAddCenter.setEnabled(!enabled);
        btnEditCenter.setEnabled(!enabled);
        btnDeleteCenter.setEnabled(!enabled);

        btnSaveCenter.setEnabled(enabled);
        btnCancelCenter.setEnabled(enabled);
        
    }
    
    private void btnAddRoomActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddRoomActionPerformed
    {//GEN-HEADEREND:event_btnAddRoomActionPerformed
        // TODO add your handling code here:
        resetRoomForm();
        AEN = 'A';
        enableRoomForm(true);
    }//GEN-LAST:event_btnAddRoomActionPerformed

    private void btnEditRoomActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEditRoomActionPerformed
    {//GEN-HEADEREND:event_btnEditRoomActionPerformed
        // TODO add your handling code here:
        AEN = 'E';
        enableRoomForm(true);
        txtRoomNo.requestFocus();
    }//GEN-LAST:event_btnEditRoomActionPerformed

    private void btnDeleteRoomActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteRoomActionPerformed
    {//GEN-HEADEREND:event_btnDeleteRoomActionPerformed
        // TODO add your handling code here:
        int index = tableRoom.getSelectedRow();
        int nxtInd = index;
        if(index == tableRoom.getRowCount())
            nxtInd = index-1;
        
        
        try
        {
            PreparedStatement psmtD = conn.prepareStatement("DELETE FROM CenterRoom WHERE Center_Id = ?");
            psmtD.setInt(1, cidC);

            int n = psmtD.executeUpdate();

            if(n>0)
            {
                resetCenterForm();
                modelCenterTable.removeRow(index);
                tableCenter.getSelectionModel().setSelectionInterval(nxtInd, nxtInd);
            }
            else
            {
//                JOptionPane.showMessageDialog(this, "Record Not Deleted");
            }

        } catch (SQLException ex)
        {
//            Logger.getLogger(ManageLibrarianPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteRoomActionPerformed

    private void btnSaveRoomActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaveRoomActionPerformed
    {//GEN-HEADEREND:event_btnSaveRoomActionPerformed
        // TODO add your handling code here:
        String roomNo = txtRoomNo.getText();
        int cap = Integer.parseInt(txtCapacity.getText());
        String center = (String)comboCenter.getSelectedItem();

        PreparedStatement psmt = null;
        String query ;
        
        try
        {
            
            if(AEN == 'A')
            {
                query = "INSERT INTO CenterRoom(Center_Id,Room_No,Capacity) "
                        + "VALUES((SELECT Center_Id FROM ExamCenter WHERE Name = ?), ?, ?)";
                
                psmt = conn.prepareStatement(query);
            }
            else if(AEN == 'E')
            {
                query = "UPDATE CenterRoom SET Center_id  = (SELECT Center_Id FROM ExamCenter WHERE Name = ?), Room_No = ?, Capacity = ? "
                        + "WHERE Center_Id = ? AND Room_No = ?";
                
                psmt = conn.prepareStatement(query);
                
                psmt.setInt(4, cidR);
                psmt.setString(5, rNo);
            }
            
            psmt.setString(1, center);
            psmt.setString(2, roomNo);
            psmt.setInt(3, cap);
            
            int count = psmt.executeUpdate();
            
            if(count>0)
            {
                
                if(AEN == 'A')
                {
                    
                    populateRoomTable();
                    enableRoomForm(false);
                }
                else if(AEN == 'E')
                {
                    populateRoomTable();
                    enableRoomForm(false);
                }
            }
            
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageExamCenterAndRoomPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveRoomActionPerformed

    private void btnCancelRoomActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelRoomActionPerformed
    {//GEN-HEADEREND:event_btnCancelRoomActionPerformed
        // TODO add your handling code here:
        enableRoomForm(false);
        populateRoomDetails();
    }//GEN-LAST:event_btnCancelRoomActionPerformed

    
    private void resetRoomForm()
    {
        Component cCenter[] = roomPanel.getComponents();
        for (Component comp : cCenter)
        {
            if(comp instanceof JTextField)
                ((JTextField) comp).setText(" ");
            else if(comp instanceof JComboBox)
                ((JComboBox) comp).setSelectedIndex(0);
        
            txtRoomNo.requestFocus();
        }
            
    }
    
    private void enableRoomForm(boolean enabled)
    {
        txtRoomNo.setEditable(enabled);
        txtCapacity.setEditable(enabled);
        
        comboCenter.setEnabled(enabled);
        
        btnAddRoom.setEnabled(!enabled);
        btnEditRoom.setEnabled(!enabled);
        btnDeleteRoom.setEnabled(!enabled);

        btnSaveRoom.setEnabled(enabled);
        btnCancelRoom.setEnabled(enabled);
        
    }    
    
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if(e.getSource() == tableCenter.getSelectionModel())
        {
            if(e.getValueIsAdjusting())
            {
                rowC = tableCenter.getSelectedRow();
                cidC = (Integer)modelCenterTable.getValueAt(rowC, 0);
                populateCenterDetails();
            }
        }
        else if(e.getSource() == tableRoom.getSelectionModel())
        {
            if(e.getValueIsAdjusting())
            {
                rowR = tableRoom.getSelectedRow();
                cidR = (Integer)modelRoomTable.getValueAt(rowR, 0);
                populateRoomDetails();
                
            }
        }
        
    }
    
    private void populateCenterDetails()
    {
        txtCenterName.setText((String) modelCenterTable.getValueAt(rowC, 1));
        txtCenterAddress.setText((String) modelCenterTable.getValueAt(rowC, 2));
        txtCenterNo.setText((String) modelCenterTable.getValueAt(rowC, 3));
        comboZone.setSelectedItem(modelCenterTable.getValueAt(rowC, 4));
    }
    
    private void populateRoomDetails()
    {
        comboCenter.setSelectedItem(modelRoomTable.getValueAt(rowR, 1));
        rNo  = (String) modelRoomTable.getValueAt(rowR, 2);
        txtRoomNo.setText(rNo);
        txtCapacity.setText((Integer) modelRoomTable.getValueAt(rowR, 3)+"");
    }
    
    private void btnManageCenterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnManageCenterActionPerformed
    {//GEN-HEADEREND:event_btnManageCenterActionPerformed
        // TODO add your handling code here:
        enablePanel(true);
        AEN = 'N';
    }//GEN-LAST:event_btnManageCenterActionPerformed

    private void btnManageRoomActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnManageRoomActionPerformed
    {//GEN-HEADEREND:event_btnManageRoomActionPerformed
        // TODO add your handling code here:
        enablePanel(false);
        AEN = 'N';
    }//GEN-LAST:event_btnManageRoomActionPerformed

    private void enablePanel(boolean enabled)
    {
        Component cCenter[] = panelCenterBtn.getComponents();
        for (Component component : cCenter)
        {
            component.setEnabled(enabled);
        }
            btnSaveCenter.setEnabled(false);
            btnCancelCenter.setEnabled(false);
        
        Component cRoom[] = panelRoomBtn.getComponents();
        for (Component component : cRoom)
        {
            component.setEnabled(!enabled);
        }
        btnSaveRoom.setEnabled(false);
        btnCancelRoom.setEnabled(false);
        
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
            java.util.logging.Logger.getLogger(ManageExamCenterAndRoomPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ManageExamCenterAndRoomPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ManageExamCenterAndRoomPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ManageExamCenterAndRoomPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ManageExamCenterAndRoomPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCenter;
    private javax.swing.JButton btnAddRoom;
    private javax.swing.JButton btnCancelCenter;
    private javax.swing.JButton btnCancelRoom;
    private javax.swing.JButton btnDeleteCenter;
    private javax.swing.JButton btnDeleteRoom;
    private javax.swing.JButton btnEditCenter;
    private javax.swing.JButton btnEditRoom;
    private javax.swing.JButton btnManageCenter;
    private javax.swing.JButton btnManageRoom;
    private javax.swing.JButton btnSaveCenter;
    private javax.swing.JButton btnSaveRoom;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JComboBox<String> comboCenter;
    private javax.swing.JComboBox<String> comboZone;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelCenterBtn;
    private javax.swing.JPanel panelRoomBtn;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JTable tableCenter;
    private javax.swing.JTable tableRoom;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextArea txtCenterAddress;
    private javax.swing.JTextField txtCenterName;
    private javax.swing.JTextField txtCenterNo;
    private javax.swing.JTextField txtRoomNo;
    // End of variables declaration//GEN-END:variables




}
