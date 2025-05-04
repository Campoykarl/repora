package HomePage;


import HomePage.login;
import admin.usersTable;
import config.dbConnector;
import config.passHash;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }
    
    public String destination = "";
    public static String usern;
    
    public boolean duplicateCheck(){
    
    dbConnector dbc = new dbConnector();   
    try{
           String query = "SELECT * FROM tbl_user  WHERE u_username = '" + user.getText() +  "'";
            ResultSet resultSet = dbc.getData(query);   
           
        if(resultSet.next()){              
            
             usern = resultSet.getString("u_username");
             if(usern.equals(user.getText())){
               JOptionPane.showMessageDialog(null,"Username already Exist!");
               user.setText("");
               }
          
             return true;    
        }else    
            return false;
    }catch(SQLException ex){
        System.out.println(""+ex);
        return false;
    }
    
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        user = new javax.swing.JTextField();
        fna = new javax.swing.JTextField();
        lna = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ct = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        ps = new javax.swing.JPasswordField();
        type = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 380, 40));

        fna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fna.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        fna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnaActionPerformed(evt);
            }
        });
        jPanel1.add(fna, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 380, 40));

        lna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lna.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnaActionPerformed(evt);
            }
        });
        jPanel1.add(lna, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 380, 40));

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Type of User:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 20));

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 20));

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 20));

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 20));

        ct.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctActionPerformed(evt);
            }
        });
        jPanel1.add(ct, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 380, 40));

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 20));

        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 380, 40));

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 20));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, 20));

        jButton1.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 140, 50));

        cancel.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 120, 50));

        ps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ps.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 380, 40));

        type.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel1.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 380, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 670, 560));

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRATION FORM");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void fnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnaActionPerformed

    private void lnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnaActionPerformed

    private void ctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String fistname = fna.getText();
    String lname = lna.getText();
    String username1 = user.getText();
    String contact = ct.getText();
    String ad = address.getText();
    String password1 = new String(ps.getPassword());
    String selectedRole = type.getSelectedItem().toString();

    if (fistname.isEmpty() || lname.isEmpty() || username1.isEmpty() || contact.isEmpty() || password1.isEmpty() || ad.isEmpty()){
        JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
    }else if(ps.getText().length() < 8){
        JOptionPane.showMessageDialog(null, "Password must be atleast 8 characters long");
         ps.setText("");
    }else if(!ct.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Contact number should contain only numbers!");
        ct.setText("");
    }else if(duplicateCheck()){
        System.out.println("Duplicate Exist");
    }else{
        dbConnector db = new dbConnector();
        
        try{
        String password = passHash.hashPassword(ps.getText());
            
        if(db.InsertData("INSERT INTO tbl_user (u_username, u_fname, u_lname, u_phone, u_address, u_pass, u_type, u_image, u_status)"  
            + "VALUES ('"+user.getText()+"', '"+fna.getText()+"', '"+lna.getText()+"', '"+ct.getText()+"', '"+address.getText()+"', '"+password+"', '"+type.getSelectedItem()+"', '"+destination+"', 'Pending')") == 1){
                        JOptionPane.showMessageDialog(this, "Account Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        login lf = new login();
                        lf.setVisible(true);
                        this.dispose();              
        }else{
            JOptionPane.showMessageDialog(this, "Connection Error!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(NoSuchAlgorithmException ex){
            System.out.println(""+ex);
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        login lf = new login();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField ct;
    private javax.swing.JTextField fna;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lna;
    private javax.swing.JPasswordField ps;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
