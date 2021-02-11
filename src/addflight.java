
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class addflight extends javax.swing.JInternalFrame {

  /** Creates new form addflight */
  public addflight() {
    initComponents();
    autoID();
  }

  PreparedStatement pst;

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    txtflightid = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    txtflightname = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    txtdate = new com.toedter.calendar.JDateChooser();
    jLabel7 = new javax.swing.JLabel();
    txtdtime = new javax.swing.JTextField();
    txtarrtime = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    txtflightcharge = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    txtsource = new javax.swing.JComboBox<>();
    txtdepart = new javax.swing.JComboBox<>();

    jPanel1.setBackground(new java.awt.Color(51, 51, 255));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Flight ID");

    txtflightid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    txtflightid.setForeground(new java.awt.Color(255, 255, 0));
    txtflightid.setText("jLabel2");

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Flight Name");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Source");

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("Departure");

    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("Date");

    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("Dep Time");

    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Arr Time");

    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("Flight Charge");

    jButton1.setText("Add");
    jButton1.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
          }
        });

    jButton2.setText("Cancel");
    jButton2.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
          }
        });

    txtsource.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[] {"India\t", "Srilanka", "Uk", "Usa", "Canada", "Chinna"}));

    txtdepart.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[] {"India\t", "Srilanka", "Uk", "Usa", "Canada", "Chinna"}));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                jPanel1Layout
                                                    .createSequentialGroup()
                                                    .addGap(38, 38, 38)
                                                    .addComponent(txtflightid))
                                            .addGroup(
                                                jPanel1Layout
                                                    .createSequentialGroup()
                                                    .addGap(28, 28, 28)
                                                    .addComponent(
                                                        txtflightname,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        136,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtsource, 0, 136, Short.MAX_VALUE)
                                            .addComponent(
                                                txtdepart,
                                                0,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))))
                    .addGap(103, 103, 103)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                    .addGap(62, 62, 62)
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(
                                                txtdate,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                174,
                                                Short.MAX_VALUE)
                                            .addComponent(txtdtime)
                                            .addComponent(txtarrtime)))
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(52, 52, 52)
                                    .addComponent(
                                        txtflightcharge,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        172,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(
                        jButton1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        117,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(
                        jButton2,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        110,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                jPanel1Layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtflightid)
                                    .addComponent(jLabel6))
                            .addComponent(
                                txtdate,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(
                                txtflightname,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(
                                txtdtime,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(
                                txtarrtime,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(
                                txtsource,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(
                                                txtdepart,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(
                                                txtflightcharge,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                jButton1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                46,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                jButton2,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                46,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(43, 43, 43)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(
                        jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(
                        jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  public void autoID() {
    try {
      Database.getConnection();
      Statement s = Database.connection.createStatement();
      ResultSet rs = s.executeQuery("select MAX(id) from flight");
      rs.next();
      rs.getString("MAX(id)");
      if (rs.getString("MAX(id)") == null) {
        txtflightid.setText("FO001");
      } else {
        long id =
            Long.parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
        id++;
        txtflightid.setText("FO" + String.format("%03d", id));
      }

    } catch (SQLException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void jButton1ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:

    String id = txtflightid.getText();
    String flightname = txtflightname.getText();

    String source = txtsource.getSelectedItem().toString().trim();
    String depart = txtdepart.getSelectedItem().toString().trim();

    DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
    String date = da.format(txtdate.getDate());

    String departtime = txtdtime.getText();
    String arrtime = txtarrtime.getText();
    String flightcharge = txtflightcharge.getText();

    try {
      Database.getConnection();
      pst =
          Database.connection.prepareStatement(
              "insert into flight(id,flightname,source,depart,date,deptime,arrtime,flightcharge)values(?,?,?,?,?,?,?,?)");

      pst.setString(1, id);
      pst.setString(2, flightname);
      pst.setString(3, source);
      pst.setString(4, depart);
      pst.setString(5, date);
      pst.setString(6, departtime);
      pst.setString(7, arrtime);
      pst.setString(8, flightcharge);

      pst.executeUpdate();

      JOptionPane.showMessageDialog(null, "Flight Created.........");
    } catch (SQLException ex) {
      Logger.getLogger(addflight.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:

    this.hide();
  } // GEN-LAST:event_jButton2ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField txtarrtime;
  private com.toedter.calendar.JDateChooser txtdate;
  private javax.swing.JComboBox<String> txtdepart;
  private javax.swing.JTextField txtdtime;
  private javax.swing.JTextField txtflightcharge;
  private javax.swing.JLabel txtflightid;
  private javax.swing.JTextField txtflightname;
  private javax.swing.JComboBox<String> txtsource;
  // End of variables declaration//GEN-END:variables
}
