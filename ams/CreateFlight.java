/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import com.sun.org.apache.xml.internal.security.utils.XMLUtils;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.prompt.PromptSupport;


/**
 *
 * @author kushagra
 */
public class CreateFlight extends javax.swing.JFrame {
    private Connection con;
    private Flight flight1,flight2;
    int modify;
    /**
     * Creates new form CreateFlight
     */
    public CreateFlight(){
        initComponents();
    }
    public CreateFlight(Connection co,int mo) {
        initComponents();
        btn_confirm.setEnabled(false);
        modify = mo;
        con = co;
        flight1 = new Flight();
        flight2 = new Flight();
        PromptSupport.setPrompt("HH-mm-ss", text_arr_time);
        PromptSupport.setPrompt("HH-mm-ss", text_dep_time);
        PromptSupport.setPrompt("HH-mm-ss", text_arr_time1);
        PromptSupport.setPrompt("HH-mm-ss", text_dep_time1);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, text_dep_time);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, text_dep_time);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, text_dep_time);        
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, text_dep_time);
    
        cmb_planeID.setEnabled(false);
        
        try {
            ArrayList<String> str = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select name from cities");
            int i = 0;
            while(rs.next()) {
                str.add(rs.getString("name"));
                i++;
            }
            from.setModel(new javax.swing.DefaultComboBoxModel(str.toArray()));
            to.setModel(new javax.swing.DefaultComboBoxModel(str.toArray()));
            to.setSelectedIndex(2);
        } catch (SQLException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public CreateFlight(Connection co,int mo,Flight flt1, Flight flt2) {
        initComponents();
        btn_confirm.setEnabled(false);
        modify = mo;
        con = co;
 
        flight1 = flt1;
        flight2 = flt2;
        
        if(Integer.parseInt(flight1.getId())>Integer.parseInt(flight2.getId())){
            Flight tmp = flight1;
            flight1 = flight2;
            flight2 = tmp;
        }
        cmb_planeID.setEnabled(false);
        DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        DateFormat output = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            ArrayList<String> str1 = new ArrayList<>();
            ArrayList<String> str2 = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = "select start,dest from route WHERE id = '"+flight1.getRouteid()+"'";
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            if(rs.next()){
                str1.add(rs.getString("start"));
                str2.add(rs.getString("dest"));
            }
            else{
                JOptionPane.showMessageDialog(this, "Change to this flight is not allowed!");
            }
            from.setModel(new javax.swing.DefaultComboBoxModel(str1.toArray()));
            to.setModel(new javax.swing.DefaultComboBoxModel(str2.toArray()));
            from.setSelectedIndex(0);
            to.setSelectedIndex(0);
            
            
            str1 = new ArrayList<>();
            str1.add(flight1.getPlaneid());
            cmb_planeID.setModel(new javax.swing.DefaultComboBoxModel(str1.toArray()));
            cmb_planeID.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            on_dep_date.setDate(output.parse(flight1.getDeparture()));
            on_arr_date.setDate(output.parse(flight1.getArrival()));
            ret_dep_date.setDate(output.parse(flight2.getDeparture()));
            ret_arr_date.setDate(output.parse(flight2.getArrival()));
        } catch (ParseException ex) {
            Logger.getLogger(CreateFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
        name.setText(flight1.getName());
        fare_b.setText(flight1.getFare_b());
        fare_f.setText(flight1.getFare_f());
        fare_e.setText(flight1.getFare_e());
        
        basic.setText(flight1.getBasic_cost());
        try {
            System.out.println(flight1.getDeparture().replace(':', '-').substring(0, 19));
            text_dep_time.setText(flight1.getDeparture().replace(':', '-').substring(0, 19).split(" ")[1]);
            text_arr_time.setText(flight1.getArrival().replace(':', '-').substring(0, 19).split(" ")[1]);
            text_dep_time1.setText(flight2.getDeparture().replace(':', '-').substring(0, 19).split(" ")[1]);
            text_arr_time1.setText(flight2.getArrival().replace(':', '-').substring(0, 19).split(" ")[1]);
        } catch (Exception ex) {
            Logger.getLogger(CreateFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btn_confirm.setText("Update");
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        basic = new javax.swing.JTextField();
        text_dep_time = new javax.swing.JTextField();
        text_arr_time = new javax.swing.JTextField();
        btn_cancel = new javax.swing.JButton();
        btn_confirm = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        fare_f = new javax.swing.JTextField();
        fare_b = new javax.swing.JTextField();
        fare_e = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_planeID = new javax.swing.JComboBox<>();
        on_dep_date = new org.jdesktop.swingx.JXDatePicker();
        on_arr_date = new org.jdesktop.swingx.JXDatePicker();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ret_dep_date = new org.jdesktop.swingx.JXDatePicker();
        ret_arr_date = new org.jdesktop.swingx.JXDatePicker();
        text_dep_time1 = new javax.swing.JTextField();
        text_arr_time1 = new javax.swing.JTextField();
        check_planes = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        from = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        to = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Flight", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        jLabel1.setText("Name:");

        jLabel2.setText("Business Class Fare:");

        jLabel3.setText("Economy Class fare:");

        jLabel4.setText("Basic Cost:");

        jLabel6.setText("Plane ID:");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        text_dep_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_dep_timeActionPerformed(evt);
            }
        });

        text_arr_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_arr_timeActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_confirm.setText("Confirm");
        btn_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmActionPerformed(evt);
            }
        });

        jLabel7.setText("First Class Fare:");

        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Onward", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel8.setText("Departure Time: ");

        jLabel9.setText("Arrival Time: ");

        cmb_planeID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_planeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_planeIDActionPerformed(evt);
            }
        });

        on_dep_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                on_dep_dateActionPerformed(evt);
            }
        });

        on_arr_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                on_arr_dateActionPerformed(evt);
            }
        });

        jSeparator4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Return ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel10.setText("Departure Time: ");

        jLabel11.setText("Arrival Time: ");

        ret_dep_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ret_dep_dateActionPerformed(evt);
            }
        });

        ret_arr_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ret_arr_dateActionPerformed(evt);
            }
        });

        text_dep_time1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_dep_time1ActionPerformed(evt);
            }
        });

        text_arr_time1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_arr_time1ActionPerformed(evt);
            }
        });

        check_planes.setText("Check Schedule");
        check_planes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_planesActionPerformed(evt);
            }
        });

        jLabel5.setText("From:");

        from.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });

        jLabel12.setText("To:");

        to.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ret_dep_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ret_arr_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(text_arr_time1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_dep_time1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fare_f, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fare_b, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fare_e, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(basic, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(on_arr_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(on_dep_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_arr_time, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(text_dep_time)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(check_planes, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_planeID, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fare_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fare_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fare_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(basic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(text_dep_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(on_dep_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_arr_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(on_arr_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ret_dep_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_dep_time1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_arr_time1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ret_arr_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_planeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(check_planes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_confirm))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_arr_time1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_arr_time1ActionPerformed
        text_arr_time1.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_text_arr_time1ActionPerformed

    private void text_dep_time1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_dep_time1ActionPerformed
        text_dep_time1.setText("");
        btn_confirm.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_text_dep_time1ActionPerformed

    private void cmb_planeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_planeIDActionPerformed

     
    }//GEN-LAST:event_cmb_planeIDActionPerformed

    private void btn_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmActionPerformed
        java.sql.Date arr ;
        java.sql.Date dep ;
        java.util.Date dep_d;
        java.util.Date arr_d;
        java.sql.Date arr_e ;
        java.sql.Date dep_s ;
        java.util.Date dep_d_s;
        java.util.Date arr_d_e;
        DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        DateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{     
            arr = new java.sql.Date(on_arr_date.getDate().getTime());
            dep = new java.sql.Date(ret_dep_date.getDate().getTime());          
            dep_d = dtf.parse(dep.toString()+" "+text_dep_time1.getText());   //d3
            arr_d = dtf.parse(arr.toString()+" " +text_arr_time.getText());   //d2
            arr_e = new java.sql.Date(ret_arr_date.getDate().getTime());
            dep_s = new java.sql.Date(on_dep_date.getDate().getTime());
            dep_d_s = dtf.parse(dep_s.toString()+" "+text_dep_time.getText());    //d1
            arr_d_e = dtf.parse(arr_e.toString()+" " +text_arr_time1.getText());   //d4
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Enter Time in correct format");
            return;
        }
        
//        if(!(dep_d_s.before(arr_d) && arr_d.before(dep_d) && dep_d.before(arr_d_e))){
//            JOptionPane.showMessageDialog(this, "DateTime combination not feasible");
//            return;
//        }
        System.out.println(dep_d_s + "--> "+output.format(dep_d_s) );
        flight1.setArrival(output.format(arr_d));
        flight1.setDeparture(output.format(dep_d_s));
        flight2.setDeparture(output.format(dep_d));      
        flight2.setArrival(output.format(arr_d_e));
        
        
        
        if(name.getText().toString().equals("")){
            JOptionPane.showMessageDialog(this, "Name field can't be empty!");
            return;
        }
        flight1.setName(name.getText());
        flight2.setName(name.getText());
        
        
        if(fare_b.getText().toString().equals("")){
            JOptionPane.showMessageDialog(this, "Fare for business Class field can't be empty!");
            return;
        }
        try{
        flight1.setFare_b(String.valueOf(Integer.parseInt(fare_b.getText())));
        flight2.setFare_b(String.valueOf(Integer.parseInt(fare_b.getText())));
        
        
        if(fare_f.getText().toString().equals("")){
            JOptionPane.showMessageDialog(this, "Fare for First Class field can't be empty!");
            return;
        }
        flight1.setFare_f(String.valueOf(Integer.parseInt(fare_f.getText())));
        flight2.setFare_f(String.valueOf(Integer.parseInt(fare_f.getText())));
        
        if(fare_e.getText().toString().equals("")){
            JOptionPane.showMessageDialog(this, "Fare for economy Class field can't be empty!");
            return;
        }
        flight1.setFare_e(String.valueOf(Integer.parseInt(fare_e.getText())));
        flight2.setFare_e(String.valueOf(Integer.parseInt(fare_e.getText())));
        
        
        if(basic.getText().toString().equals("")){
            JOptionPane.showMessageDialog(this, "Basic Cost field can't be empty!");
            return;
        }
        flight1.setBasic_cost(String.valueOf(Integer.parseInt(basic.getText())));
        flight2.setBasic_cost(String.valueOf(Integer.parseInt(basic.getText())));
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Please Enter fare in integer format only");
            return;
        }
        if(modify == 1){
            String qry = "UPDATE flight SET name = '"+flight1.getName()+"', departure = '"+ flight1.getDeparture()+"', arrival = '"+flight1.getArrival()+
                    "', planeID ='"+flight1.getPlaneid()+"', vac_f = '"+flight1.getVac_f()+"', vac_b = '"+flight1.getVac_b()+"', vac_e = '"+flight1.getVac_e()+
                    "', fare_f = '"+flight1.getFare_f()+"', fare_b = '"+flight1.getFare_b()+"', fare_e = '"+flight1.getFare_e()+"', basic='"+flight1.getBasic_cost()+
                    "', bookinglist='"+flight1.getBookinglist()+"', routeID ='"+flight1.getRouteid()+"' WHERE id ='"+flight1.getId()+"'";
            System.out.println(qry);
            try{
                Statement st = con.createStatement();
                st.executeUpdate(qry);
            
                qry = "UPDATE flight SET name = '"+flight2.getName()+"', departure = '"+ flight2.getDeparture()+"', arrival = '"+flight2.getArrival()+
                    "', planeID ='"+flight2.getPlaneid()+"', vac_f = '"+flight2.getVac_f()+"', vac_b = '"+flight2.getVac_b()+"', vac_e = '"+flight2.getVac_e()+
                    "', fare_f = '"+flight2.getFare_f()+"', fare_b = '"+flight2.getFare_b()+"', fare_e = '"+flight2.getFare_e()+"', basic='"+flight2.getBasic_cost()+
                    "', bookinglist='"+flight2.getBookinglist()+"', routeID ='"+flight2.getRouteid()+"' WHERE id ='"+flight2.getId()+"'";
                
                st.executeUpdate(qry);
            
            }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Unsuccessfull Modification!");
                    System.out.println(ex);
                    return;
            }
            JOptionPane.showMessageDialog(this,"The corresponding flight Updated!");
            this.dispose();
            return;
        }
        
        flight1.setPlaneid(cmb_planeID.getSelectedItem().toString());
        flight2.setPlaneid(cmb_planeID.getSelectedItem().toString());
        
        
        flight1.setBookinglist("");
        flight2.setBookinglist("");
        
        
        try{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM plane WHERE id = '"+flight1.getPlaneid()+"'");
        if(rs.next()){
            flight1.setVac_b(rs.getString("capacity_b"));
            flight2.setVac_b(rs.getString("capacity_b"));
            flight1.setVac_e(rs.getString("capacity_e"));
            flight2.setVac_e(rs.getString("capacity_e"));
            flight1.setVac_f(rs.getString("capacity_f"));
            flight2.setVac_f(rs.getString("capacity_f"));
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Some database1 error occured");
            return;
        }
        try{
            String qry = "INSERT INTO flight (name, departure, arrival, planeID, vac_f, vac_b, vac_e, fare_f, fare_b, fare_e, basic, bookinglist, routeID) values('"+
                             flight1.getName() + "','" + flight1.getDeparture() + "','" + flight1.getArrival()+ "','" + 
                             flight1.getPlaneid() + "','" + flight1.getVac_f() + "','" + flight1.getVac_b() + "','" + flight1.getVac_e()+
                             "','" + flight1.getFare_f() + "','" + flight1.getFare_b() + "','" + flight1.getFare_e() + "','"+ 
                             flight1.getBasic_cost() + "','" + flight1.getBookinglist() + "','" + flight1.getRouteid() +"')";
            Statement st = con.createStatement();
            st.executeUpdate(qry);
            
            String flightid = null;
            qry = "SELECT id FROM flight ORDER BY id DESC LIMIT 1";
            ResultSet rs = st.executeQuery(qry);
            if(rs.next()){
                flightid = rs.getString("id");
            }
            else{
                System.out.println("Error!");
            }
            
            qry = "SELECT flightlist FROM route WHERE id = '"+flight1.getRouteid()+"'";
            rs = st.executeQuery(qry);
            if(rs.next()){
                String ftlist;
                if(rs.getString("flightlist").length()!=0)
                    ftlist = rs.getString("flightlist") + " " + flightid;
                else
                    ftlist = flightid;
                qry = "UPDATE route SET flightlist = '"+ftlist+"' WHERE id='"+flight1.getRouteid()+"'";
                st.executeUpdate(qry);
            }
             qry = "SELECT flightlist FROM plane WHERE id = '"+flight1.getPlaneid()+"'";
            rs = st.executeQuery(qry);
            if(rs.next()){
                String ftlist;
                if(rs.getString("flightlist").length()!=0)
                    ftlist = rs.getString("flightlist") + " " + flightid;
                else
                    ftlist = flightid;
                qry = "UPDATE plane SET flightlist = '"+ftlist+"' WHERE id='"+flight1.getPlaneid()+"'";
                st.executeUpdate(qry);
            }
            
            
            
            qry = "INSERT INTO flight (name, departure, arrival, planeID, vac_f, vac_b, vac_e, fare_f, fare_b, fare_e, basic, bookinglist, routeID) values('"+
                             flight2.getName() + "','" + flight2.getDeparture() + "','" + flight2.getArrival()+ "','" + 
                             flight2.getPlaneid() + "','" + flight2.getVac_f() + "','" + flight2.getVac_b() + "','" + flight2.getVac_e()+
                             "','" + flight2.getFare_f() + "','" + flight2.getFare_b() + "','" + flight2.getFare_e() + "','"+ 
                             flight2.getBasic_cost() + "','" + flight2.getBookinglist() + "','" + flight2.getRouteid() +"')"; 
            st = con.createStatement();
            st.executeUpdate(qry);
            
            
            qry = "SELECT id FROM flight ORDER BY id DESC LIMIT 1";
            rs = st.executeQuery(qry);
            if(rs.next()){
                flightid = rs.getString("id");
            }
            
            qry = "SELECT flightlist FROM route WHERE id = '"+flight2.getRouteid()+"'";
            rs = st.executeQuery(qry);
            if(rs.next()){
               String ftlist;
                if(rs.getString("flightlist").length()!=0)
                    ftlist = rs.getString("flightlist") + " " + flightid;
                else
                    ftlist = flightid;
                qry = "UPDATE route SET flightlist = '"+ftlist+"' WHERE id='"+flight2.getRouteid()+"'";
                st.executeUpdate(qry);
            }
             qry = "SELECT flightlist FROM plane WHERE id = '"+flight2.getPlaneid()+"'";
            rs = st.executeQuery(qry);
            if(rs.next()){
                String ftlist;
                if(rs.getString("flightlist").length()!=0)
                    ftlist = rs.getString("flightlist") + " " + flightid;
                else
                    ftlist = flightid;
                qry = "UPDATE plane SET flightlist = '"+ftlist+"' WHERE id='"+flight2.getPlaneid()+"'";
                st.executeUpdate(qry);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Some database error occured");
            return;
        }
        
        
        this.dispose();
    }//GEN-LAST:event_btn_confirmActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void text_arr_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_arr_timeActionPerformed
        btn_confirm.setEnabled(false);
        text_arr_time.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_text_arr_timeActionPerformed

    private void text_dep_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_dep_timeActionPerformed
        btn_confirm.setEnabled(false);        
        text_dep_time.setText("");
    }//GEN-LAST:event_text_dep_timeActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void ret_arr_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ret_arr_dateActionPerformed
        btn_confirm.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_ret_arr_dateActionPerformed

    private void check_planesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_planesActionPerformed
       HashMap<String,Integer> rt_ids = new HashMap<>(); 
        ArrayList<String> planes = new ArrayList<>();
        java.sql.Date dep ;
        java.sql.Date arr ;
        java.util.Date dep_d;
        java.util.Date arr_d;
        java.sql.Date arr_e ;
        java.sql.Date dep_s ;
        java.util.Date dep_d_s;
        java.util.Date arr_d_e;
        DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        DateFormat output = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        String from_sta = from.getSelectedItem().toString();
        String to_sta = to.getSelectedItem().toString();
        try{     
            dep = new java.sql.Date(ret_dep_date.getDate().getTime());
            arr = new java.sql.Date(on_arr_date.getDate().getTime());
            dep_d = dtf.parse(dep.toString()+" "+text_dep_time1.getText());   //d3
            arr_d = dtf.parse(arr.toString()+" " +text_arr_time.getText());   //d2
            arr_e = new java.sql.Date(ret_arr_date.getDate().getTime());
            dep_s = new java.sql.Date(on_dep_date.getDate().getTime());
            dep_d_s = dtf.parse(dep_s.toString()+" "+text_dep_time.getText());    //d1
            arr_d_e = dtf.parse(arr_e.toString()+" " +text_arr_time1.getText());   //d4
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Enter Time in correct format");
            return;
        }
        
        //ensure correct ordering of dates
        if(!(dep_d_s.before(arr_d) && arr_d.before(dep_d) && dep_d.before(arr_d_e))){
            System.out.println(dep_d_s.toString()+" "+arr_d.toString() + " " +dep_d.toString()+" "+arr_d_e.toString() );
            JOptionPane.showMessageDialog(this, "DateTime combination not feasible");
            return;
        }
        
        try{
            //System.out.println("Modify is"+modify);
         if(modify == 1){
             //check if there is any overlap
            String quer = "SELECT id FROM flight WHERE planeID = '"+flight1.getPlaneid()+"' AND ( NOT (( departure > '"+
                    output.format(dep_d)+"' AND arrival > '" + output.format(dep_d) + "') OR ( departure < '"+
                    output.format(arr_d)+"' AND arrival < '" + output.format(arr_d) + "')) ) AND (id!='"+flight1.getId() +"' AND id!= '"+flight2.getId()+"')";
             System.out.println(quer);
            Statement st = con.createStatement();
            ResultSet rs2 = st.executeQuery(quer);
            if(rs2.next()){
                JOptionPane.showMessageDialog(this, "The schedule is not feasible!");
                return;
            }
            
            quer = "SELECT routeID FROM flight WHERE planeID = '"+flight1.getPlaneid()+"' AND arrival < '"+
                    output.format(dep_d)+"'AND (id!='"+flight1.getId() +"' AND id!= '"+flight2.getId()+"') ORDER BY arrival DESC LIMIT 1";
            st = con.createStatement();
            
            
            
            ResultSet k = st.executeQuery("SELECT id FROM route WHERE dest = '"+from_sta+"'");
            while(k.next()){          //storing all the routes which have end point at the from station of flight to b added
                rt_ids.put(k.getString("id"), 0);  
            }
            
            rs2 = st.executeQuery(quer);
            if(rs2.next()){
                //if the found entry has last arrival at the starting pt of the flight to be added, then it can be used as a plane
                if(rt_ids.containsKey(rs2.getString("routeID"))) {
                    JOptionPane.showMessageDialog(this, "Schedule Feasible");
                    btn_confirm.setEnabled(true);
                    return;
                }  
                else{
                    JOptionPane.showMessageDialog(this, "Schedule not feasible as plane is unavailable");
                    return;
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Schedule Feasible");
                btn_confirm.setEnabled(true);
                return;
            }
           
         }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Some error");
            System.out.println(ex);
             Logger.getLogger(CreateFlight.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        
     
        //if not modify
        
        String qry = "SELECT id FROM route WHERE start = '"+from_sta+"' AND dest = '"+to_sta+"'";
           
        try{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(qry);    
        String routeid;
        if(rs.next()){               //if the given route exists
            routeid = rs.getString("id");
            st = con.createStatement();
//            ResultSet k = st.executeQuery("SELECT id FROM route WHERE dest = '"+from_sta+"'");
//            while(k.next()){          //storing all the routes which have end point at the from station of flight to b added
//                rt_ids.put(k.getString("id"), 0);  
//            }
            System.out.println(routeid);
            flight1.setRouteid(routeid);
        }else{
            JOptionPane.showMessageDialog(this, "No such route added");
            return;
        }
        
        st = con.createStatement();
        rs = st.executeQuery("SELECT id FROM route WHERE start = '"+to_sta+"' AND dest = '"+from_sta+"'");
        if(rs.next()){
            flight2.setRouteid(rs.getString("id"));
        }
        else{
            JOptionPane.showMessageDialog(this, "No such route added");
            return;
        }
        
        qry = "SELECT id FROM plane";
        Statement st3 = con.createStatement();
        ResultSet rs1 = st3.executeQuery(qry);
        flight1.setDeparture(output.format(dep_d));
        flight2.setArrival(output.format(arr_d));
        //finding the possiblity of each plane
        while(rs1.next()){
            //System.out.println("yes");
            String planeid = rs1.getString("id");
            Statement ts = con.createStatement();
            ResultSet sr = st.executeQuery("SELECT * FROM plane WHERE id= '"+planeid+"'");
            if(sr.next()){
                if(sr.getString("flightlist").equals("")){
                    planes.add(planeid);
                    continue;
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Some unexpected error occured");
            }
            //check if interval overlaps with any already created flight
            String quer = "SELECT id FROM flight WHERE planeID = '"+planeid+"' AND ( NOT (( departure > '"+
                    output.format(dep_d)+"' AND arrival > '" + output.format(dep_d) + "') OR ( departure < '"+
                    output.format(arr_d)+"' AND arrival < '" + output.format(arr_d) + "')) )";
            st = con.createStatement();
            ResultSet rs2 = st.executeQuery(quer);
            if(rs2.next())
                continue;
            //now check if it is available at the place 
            
            quer = "SELECT routeID FROM flight WHERE planeID = '"+planeid+"' AND arrival < '"+
                    output.format(dep_d)+"' ORDER BY arrival DESC LIMIT 1";
            st = con.createStatement();
            rs2 = st.executeQuery(quer);
            
            if(rs2.next()){
                //if he found entry has last arrival at the starting pt of the flight to be added, then it can be used as a plane
                if(rt_ids.containsKey(rs2.getString("routeID")))   
                   planes.add(planeid);
            }
        }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        cmb_planeID.setModel(new javax.swing.DefaultComboBoxModel(planes.toArray()));
        cmb_planeID.setEnabled(true);
        
        btn_confirm.setEnabled(true);
// TODO add your handling code here:
    }//GEN-LAST:event_check_planesActionPerformed

    private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
        btn_confirm.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_fromActionPerformed

    private void toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toActionPerformed
        btn_confirm.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_toActionPerformed

    private void on_dep_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_on_dep_dateActionPerformed
        btn_confirm.setEnabled(false);
    }//GEN-LAST:event_on_dep_dateActionPerformed

    private void on_arr_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_on_arr_dateActionPerformed
        btn_confirm.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_on_arr_dateActionPerformed

    private void ret_dep_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ret_dep_dateActionPerformed
        btn_confirm.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_ret_dep_dateActionPerformed
      
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateFlight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField basic;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_confirm;
    private javax.swing.JButton check_planes;
    private javax.swing.JComboBox<String> cmb_planeID;
    private javax.swing.JTextField fare_b;
    private javax.swing.JTextField fare_e;
    private javax.swing.JTextField fare_f;
    private javax.swing.JComboBox from;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField name;
    private org.jdesktop.swingx.JXDatePicker on_arr_date;
    private org.jdesktop.swingx.JXDatePicker on_dep_date;
    private org.jdesktop.swingx.JXDatePicker ret_arr_date;
    private org.jdesktop.swingx.JXDatePicker ret_dep_date;
    private javax.swing.JTextField text_arr_time;
    private javax.swing.JTextField text_arr_time1;
    private javax.swing.JTextField text_dep_time;
    private javax.swing.JTextField text_dep_time1;
    private javax.swing.JComboBox to;
    // End of variables declaration//GEN-END:variables
}
