import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class addCustomer extends javax.swing.JInternalFrame {

  /** Creates new form addCustomer */
  public addCustomer() {
    initComponents();
    autoID();
  }

  PreparedStatement pst;

  String path = null;
  byte[] userimage = null;

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    txtlastname = new javax.swing.JTextField();
    txtfirstname = new javax.swing.JTextField();
    txtnic = new javax.swing.JTextField();
    txtpassport = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtaddress = new javax.swing.JTextArea();
    jLabel6 = new javax.swing.JLabel();
    txtid = new javax.swing.JLabel();
    txtdate = new com.toedter.calendar.JDateChooser();
    jPanel2 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    r1 = new javax.swing.JRadioButton();
    r2 = new javax.swing.JRadioButton();
    txtcontact = new javax.swing.JTextField();
    txtphoto = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();

    jPanel1.setBackground(new java.awt.Color(51, 0, 255));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("FirstName");

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("LastName");

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Nic No");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Passport ID");

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("Address");

    txtlastname.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtlastnameActionPerformed(evt);
          }
        });

    txtpassport.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtpassportActionPerformed(evt);
          }
        });

    txtaddress.setColumns(20);
    txtaddress.setRows(5);
    jScrollPane1.setViewportView(txtaddress);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(
                                                jPanel1Layout
                                                    .createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addGap(47, 47, 47)
                                                    .addComponent(txtfirstname))
                                            .addGroup(
                                                jPanel1Layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        jPanel1Layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addComponent(jLabel5)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLabel3))
                                                    .addGap(38, 38, 38)
                                                    .addGroup(
                                                        jPanel1Layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING,
                                                                false)
                                                            .addComponent(jScrollPane1)
                                                            .addComponent(txtpassport)
                                                            .addComponent(txtnic))))
                                    .addContainerGap(
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(48, 48, 48)
                                    .addComponent(
                                        txtlastname,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        166,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(
                                txtfirstname,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(
                                txtlastname,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(
                                txtnic,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(
                                txtpassport,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(
                                jScrollPane1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                62,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)));

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setText("Customer ID");

    txtid.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    txtid.setForeground(new java.awt.Color(255, 0, 0));
    txtid.setText("jLabel7");

    jPanel2.setBackground(new java.awt.Color(51, 0, 255));

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Date of Birth");

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("Gender");

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("Contact");

    r1.setText("Male");

    r2.setText("Female");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(
                                jPanel2Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel2Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                    .addGap(43, 43, 43)
                                    .addGroup(
                                        jPanel2Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(
                                                txtdate,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                255,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(
                                                jPanel2Layout
                                                    .createSequentialGroup()
                                                    .addComponent(r1)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(r2))
                                            .addComponent(txtcontact))))
                    .addContainerGap(41, Short.MAX_VALUE)));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(
                                txtdate,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(r1)
                            .addComponent(r2))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(
                                txtcontact,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(108, Short.MAX_VALUE)));

    txtphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jButton1.setText("Browse");
    jButton1.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
          }
        });

    jButton2.setText("Add");
    jButton2.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
          }
        });

    jButton3.setText("Cancel");
    jButton3.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(jLabel6)
                                    .addGap(50, 50, 50)
                                    .addComponent(txtid))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(
                                        jPanel1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(
                                                                        jPanel2,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout
                                                                            .DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(
                                                                        txtphoto,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        250,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE))
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGap(337, 337, 337)
                                                                    .addComponent(
                                                                        jButton1,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        87,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE))))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(39, 39, 39)
                                                    .addComponent(
                                                        jButton2,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        105,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(
                                                        jButton3,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(24, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtid))
                    .addGap(41, 41, 41)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                jPanel1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(
                                                txtphoto,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                250,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                jPanel2,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addComponent(
                                        jButton1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        33,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                jButton2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                38,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                jButton3,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                38,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(49, 49, 49)));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  public void autoID() {
    try {
      Database.getConnection();
      Statement s = Database.connection.createStatement();
      ResultSet rs = s.executeQuery("select MAX(id) from customer");
      rs.next();
      rs.getString("MAX(id)");
      if (rs.getString("MAX(id)") == null) {
        txtid.setText("CS001");
      } else {
        long id =
            Long.parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
        id++;
        txtid.setText("CS" + String.format("%03d", id));
      }
    } catch (SQLException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void txtlastnameActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtlastnameActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtlastnameActionPerformed

  private void txtpassportActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtpassportActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtpassportActionPerformed

  private void jButton1ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:

    try {
      JFileChooser picchooser = new JFileChooser();
      picchooser.showOpenDialog(null);
      File pic = picchooser.getSelectedFile();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "png", "jpg");
      picchooser.addChoosableFileFilter(filter);
      path = pic.getAbsolutePath();
      BufferedImage img;
      img = ImageIO.read(picchooser.getSelectedFile());
      ImageIcon imageIcon =
          new ImageIcon(
              new ImageIcon(img).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
      txtphoto.setIcon(imageIcon);

      File image = new File(path);
      FileInputStream fis = new FileInputStream(image);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] buff = new byte[1024];
      for (int readNum; (readNum = fis.read(buff)) != -1; ) {
        baos.write(buff, 0, readNum);
      }
      userimage = baos.toByteArray();

    } catch (IOException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:

    String id = txtid.getText();
    String firstname = txtfirstname.getText();
    String lastname = txtlastname.getText();
    String nic = txtnic.getText();
    String passport = txtpassport.getText();
    String address = txtaddress.getText();

    DateFormat da = new SimpleDateFormat("yyyy-MM-dd");

    // To be fixed! txtdob doesn't exist
    // String date = da.format("2020-03-15");
    String date = da.format(txtdate.getDate());
    String Gender;

    if (r1.isSelected()) {
      Gender = "Male";
    } else {
      Gender = "FeMale";
    }

    String contact = txtcontact.getText();

    try {
      Database.getConnection();
      pst =
          Database.connection.prepareStatement(
              "insert into customer(id,firstname,lastname,nic,passport,address,dob,gender,contact,photo)values(?,?,?,?,?,?,?,?,?,?)");

      pst.setString(1, id);
      pst.setString(2, firstname);
      pst.setString(3, lastname);
      pst.setString(4, nic);
      pst.setString(5, passport);
      pst.setString(6, address);
      pst.setString(7, date);
      pst.setString(8, Gender);
      pst.setString(9, contact);
      pst.setBytes(10, userimage);
      pst.executeUpdate();

      JOptionPane.showMessageDialog(null, "Registration Created.........");

    } catch (SQLException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:

    this.hide();
  } // GEN-LAST:event_jButton3ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JRadioButton r1;
  private javax.swing.JRadioButton r2;
  private javax.swing.JTextArea txtaddress;
  private javax.swing.JTextField txtcontact;
  private javax.swing.JTextField txtfirstname;
  private com.toedter.calendar.JDateChooser txtdate;
  private javax.swing.JLabel txtid;
  private javax.swing.JTextField txtlastname;
  private javax.swing.JTextField txtnic;
  private javax.swing.JTextField txtpassport;
  private javax.swing.JLabel txtphoto;
  // End of variables declaration//GEN-END:variables
}
