/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnector;
import config.passHash;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Administrator
 */
public class createUserform extends javax.swing.JFrame {

    /**
     * Creates new form createUserform
     */
    public createUserform() {
        initComponents();
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    //public String answer = "No stored security answers";
   // public String question = "No stored security questions";

    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();

        Path filePath = Paths.get("src/userImages", fileName);
        boolean fileExists = Files.exists(filePath);

        if (fileExists) {
            return 1;
        } else {
            return 0;
        }

    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
    try {
        // Read the image file
        File imageFile = new File(imagePath);
        BufferedImage image = ImageIO.read(imageFile);

        // Get the original width and height of the image
        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();

        // Calculate the new height based on the desired width and the aspect ratio
        int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);

        return newHeight;
    } catch (IOException ex) {
        System.out.println("No image found!");
    }

    return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
    public void imageUpdater(String existingFilePath, String newFilePath){
    File existingFile = new File(existingFilePath);
    if (existingFile.exists()) {
        String parentDirectory = existingFile.getParent();
        File newFile = new File(newFilePath);
        String newFileName = newFile.getName();
        File updatedFile = new File(parentDirectory, newFileName);
        existingFile.delete();
        try {
            Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image updated successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while updating the image: "+e);
        }
    } else {
        try{
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            System.out.println("Error on update!");
        }
    }
   }
    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static String usern;
    
    public boolean duplicateCheck(){
        config.dbConnector db = new config.dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user WHERE u_username = '" + user.getText() + "'";
            ResultSet resultSet = db.getData(query);
            if(resultSet.next()){
                usern = resultSet.getString("u_username");
                if(usern.equals(user.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already in used");
                    user.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    public boolean updateCheck(){
        dbConnector db = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user WHERE (u_username = '"+user.getText()+"') AND u_id != '"+uid.getText()+"'";
            ResultSet resultSet = db.getData(query);
            if(resultSet.next()){
                usern = resultSet.getString("u_username");
                if(usern.equals(user.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already in used");
                    user.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        rm = new javax.swing.JButton();
        select = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        fna = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lna = new javax.swing.JTextField();
        ct = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        ps = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        uid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();

        jLabel2.setText("First Name: ");

        jScrollPane5.setViewportView(jTextPane5);

        jScrollPane6.setViewportView(jTextPane6);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(527, 473));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(30, 90, 90, 30);

        update.setText("Update");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(30, 150, 90, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Upload your Picture");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(700, 70, 110, 30);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel);
        cancel.setBounds(30, 210, 90, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 150, 520);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 260, 250));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(620, 100, 280, 270);

        add1.setText("Add");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel1.add(add1);
        add1.setBounds(30, 90, 90, 30);

        rm.setText("REMOVE");
        rm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmActionPerformed(evt);
            }
        });
        jPanel1.add(rm);
        rm.setBounds(773, 390, 90, 23);

        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select);
        select.setBounds(660, 390, 90, 23);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 80, 104, 20);

        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user);
        user.setBounds(270, 70, 330, 40);

        fna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fna.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        fna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnaActionPerformed(evt);
            }
        });
        jPanel1.add(fna);
        fna.setBounds(270, 120, 330, 40);

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(160, 130, 102, 20);

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(160, 180, 100, 20);

        lna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lna.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnaActionPerformed(evt);
            }
        });
        jPanel1.add(lna);
        lna.setBounds(270, 170, 330, 40);

        ct.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctActionPerformed(evt);
            }
        });
        jPanel1.add(ct);
        ct.setBounds(270, 220, 330, 40);

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(160, 230, 74, 20);

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(160, 280, 80, 20);

        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address);
        address.setBounds(270, 270, 330, 40);

        ps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ps.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(ps);
        ps.setBounds(270, 320, 330, 40);

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Password:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(160, 330, 93, 20);

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Type of User:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(150, 380, 119, 20);

        type.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel1.add(type);
        type.setBounds(270, 370, 330, 40);

        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel1.add(uid);
        uid.setBounds(270, 20, 330, 40);

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("User ID");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(160, 30, 64, 20);

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("User Status");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(150, 450, 101, 20);

        status.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel1.add(status);
        status.setBounds(270, 440, 330, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
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
            try{
                if(selectedFile != null && !destination.isEmpty()) {
                   Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                }

                    Session sess = Session.getInstance();
                    db.logActivity(sess.getUid(), "Created a user: " + username1);
                    JOptionPane.showMessageDialog(this, "Account Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    usersTable ut = new usersTable();
                    ut.setVisible(true);
                    this.dispose();
            }catch(IOException ex){
                System.out.println("Insert Image Error:"+ex);
                }
        }else{
            JOptionPane.showMessageDialog(this, "Connection Error!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(NoSuchAlgorithmException ex){
            System.out.println(""+ex);
        }
    }
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        usersTable ut = new usersTable();
        ut.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

     
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
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
    }else if(updateCheck()){
        System.out.println("Duplicate Exist");
    }else{
        dbConnector db = new dbConnector();

        db.updateData("UPDATE tbl_user SET u_username = '"+user.getText()+"', u_fname = '"+fna.getText()+"', u_lname = '"+lna.getText()+"', " +
                            "u_phone = '"+ct.getText()+"', u_address = '"+address.getText()+"', u_type = '"+type.getSelectedItem()+"', "
                                    + "u_image = '"+destination+"', u_status = '"+status.getSelectedItem()+"' WHERE u_id = '"+uid.getText()+"'");
        
            Session sess = Session.getInstance();
            db.logActivity(sess.getUid(), "Updated a user: " + user.getText());
            JOptionPane.showMessageDialog(null, "Account Updated Successfully!");            
            if(destination.isEmpty()){
                File existingFile = new File(oldpath);
                if(existingFile.exists()){
                    existingFile.delete();
                }
            }else{
                if(!(oldpath.equals(path))){    
                    imageUpdater(oldpath, path);
                }
            }
            usersTable ut = new usersTable();
            ut.setVisible(true);
            this.dispose();
        }
    
    }//GEN-LAST:event_updateActionPerformed

    
    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add1ActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userImages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    image.setIcon(ResizeImage(path, null, image));
                    select.setEnabled(true);
                    rm.setEnabled(false);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectActionPerformed

    private void rmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmActionPerformed
        image.setIcon(null);
        destination = "";
        path = "";
        select.setEnabled(true);
        rm.setEnabled(false);        
    }//GEN-LAST:event_rmActionPerformed

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

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(createUserform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    public javax.swing.JButton add1;
    public javax.swing.JTextField address;
    private javax.swing.JButton cancel;
    public javax.swing.JTextField ct;
    public javax.swing.JTextField fna;
    public javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    public javax.swing.JTextField lna;
    public javax.swing.JPasswordField ps;
    public javax.swing.JButton rm;
    public javax.swing.JButton select;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JComboBox<String> type;
    public javax.swing.JTextField uid;
    public javax.swing.JButton update;
    public javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
