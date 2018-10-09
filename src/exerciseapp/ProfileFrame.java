package exerciseapp;

import java.awt.BorderLayout;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProfileFrame extends javax.swing.JFrame {

    DataHandler dh;
    String profileData;

    public ProfileFrame(DataHandler cdh) {
        initComponents();

        dh = cdh;

        setLocationRelativeTo(null);

        setBackground();

        setTitle("Exercise App");
        setIconImage(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/IconImage.png")).getImage());

        profileData = dh.getProfileData();
        if (!profileData.matches("noprofile")) {
            nameTxf.setText(profileData.split("#")[0]);
            surnameTxf.setText(profileData.split("#")[1]);
            switch (profileData.split("#")[2]) {
                case "Male":
                    genderCmb.setSelectedIndex(1);
                    break;
                case "Female":
                    genderCmb.setSelectedIndex(2);
            }
            weightGoalTxf.setText(profileData.split("#")[3]);
            try {
                currentWeightTxf.setText(profileData.split("#")[8]);
            } catch (IndexOutOfBoundsException ex) {
                currentWeightTxf.setText(profileData.split("#")[7]);
            }
            minWaterTxf.setText(profileData.split("#")[4]);
            maxCaloriesTxf.setText(profileData.split("#")[5]);
            startDateTxf.setText(profileData.split("#")[6]);
        } else {
            Calendar date = Calendar.getInstance();
            startDateTxf.setText(date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.YEAR));
        }
    }

    public void setBackground() {
        JLabel backgroundLbl = new JLabel();
        setLayout(new BorderLayout());
        add(backgroundLbl);
        backgroundLbl.setIcon(new ImageIcon(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/Background.jpg")).getImage().getScaledInstance(1000, 700, java.awt.Image.SCALE_SMOOTH)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        selectClientBtn2 = new javax.swing.JButton();
        nameTxf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        surnameTxf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        weightGoalTxf = new javax.swing.JTextField();
        currentWeightTxf = new javax.swing.JTextField();
        genderCmb = new javax.swing.JComboBox<>();
        minWaterTxf = new javax.swing.JTextField();
        maxCaloriesTxf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        startDateTxf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        todayBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 80)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Exercise");

        selectClientBtn2.setBackground(new java.awt.Color(0, 0, 0));
        selectClientBtn2.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        selectClientBtn2.setForeground(new java.awt.Color(0, 0, 0));
        selectClientBtn2.setText("Save");
        selectClientBtn2.setOpaque(false);
        selectClientBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectClientBtn2ActionPerformed(evt);
            }
        });

        nameTxf.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        nameTxf.setForeground(new java.awt.Color(0, 0, 0));
        nameTxf.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name :");

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Surname :");

        surnameTxf.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        surnameTxf.setForeground(new java.awt.Color(0, 0, 0));
        surnameTxf.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Gender :");

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Weight Goal :");

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Current Weight :");

        weightGoalTxf.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        weightGoalTxf.setForeground(new java.awt.Color(0, 0, 0));
        weightGoalTxf.setOpaque(false);

        currentWeightTxf.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        currentWeightTxf.setForeground(new java.awt.Color(0, 0, 0));
        currentWeightTxf.setOpaque(false);

        genderCmb.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        genderCmb.setForeground(new java.awt.Color(0, 0, 0));
        genderCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None Selected", "Male", "Female" }));
        genderCmb.setOpaque(false);

        minWaterTxf.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        minWaterTxf.setForeground(new java.awt.Color(0, 0, 0));
        minWaterTxf.setOpaque(false);

        maxCaloriesTxf.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        maxCaloriesTxf.setForeground(new java.awt.Color(0, 0, 0));
        maxCaloriesTxf.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Minimum Water per day :");

        jLabel8.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Maximum Calories per Day :");

        startDateTxf.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        startDateTxf.setForeground(new java.awt.Color(0, 0, 0));
        startDateTxf.setOpaque(false);
        startDateTxf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateTxfActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Start Date (D/M/YYYY):");

        todayBtn.setBackground(new java.awt.Color(0, 0, 0));
        todayBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        todayBtn.setForeground(new java.awt.Color(0, 0, 0));
        todayBtn.setText("Today");
        todayBtn.setOpaque(false);
        todayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(292, 292, 292))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(startDateTxf)
                    .addComponent(selectClientBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(nameTxf)
                    .addComponent(surnameTxf)
                    .addComponent(weightGoalTxf, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentWeightTxf, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genderCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minWaterTxf, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maxCaloriesTxf, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(29, 29, 29)
                .addComponent(todayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameTxf))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(surnameTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(weightGoalTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(currentWeightTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minWaterTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxCaloriesTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(todayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(selectClientBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectClientBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectClientBtn2ActionPerformed
        if (!nameTxf.getText().matches("")) {
            if (!surnameTxf.getText().matches("")) {
                if (!((String) genderCmb.getSelectedItem()).matches("None Selected")) {
                    if (!weightGoalTxf.getText().matches("")) {
                        if (!currentWeightTxf.getText().matches("")) {
                            if (!minWaterTxf.getText().matches("")) {
                                if (!maxCaloriesTxf.getText().matches("")) {
                                    if (!startDateTxf.getText().matches("")) {
                                        if (!profileData.equals("")) {
                                            if (startDateTxf.getText().matches(profileData.split("#")[6])) {
                                                dh.setProfileData(nameTxf.getText() + "#" + surnameTxf.getText() + "#" + (String) genderCmb.getSelectedItem() + "#" + weightGoalTxf.getText() + "#" + minWaterTxf.getText() + "#" + maxCaloriesTxf.getText() + "#" + startDateTxf.getText() + "#" + currentWeightTxf.getText());
                                                this.setVisible(false);
                                                dh.home.setVisible(true);
                                            } else {
                                                int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to change the start date? As this will erase all your previous data saved.");
                                                if (x == JOptionPane.YES_OPTION) {
                                                    dh.clearSaves();
                                                    dh.checkFiles();
                                                    dh.setProfileData(nameTxf.getText() + "#" + surnameTxf.getText() + "#" + (String) genderCmb.getSelectedItem() + "#" + weightGoalTxf.getText() + "#" + minWaterTxf.getText() + "#" + maxCaloriesTxf.getText() + "#" + startDateTxf.getText() + currentWeightTxf.getText());
                                                    this.setVisible(false);
                                                    dh.home.setVisible(true);
                                                }
                                            }
                                        } else {
                                            dh.setProfileData(nameTxf.getText() + "#" + surnameTxf.getText() + "#" + (String) genderCmb.getSelectedItem() + "#" + weightGoalTxf.getText() + "#" + minWaterTxf.getText() + "#" + maxCaloriesTxf.getText() + "#" + startDateTxf.getText() + "#" + currentWeightTxf.getText());
                                            this.setVisible(false);
                                            dh.home.setVisible(true);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Please Set Start Date");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Please Set Maximum Calories Per Day");
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Please Set Minimum Water Per Day In Milileters");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Please Set Current Weight");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please Set Weight Goal");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please Set Gender");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Set Surname");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Set Name");
        }
    }//GEN-LAST:event_selectClientBtn2ActionPerformed

    private void todayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayBtnActionPerformed
        Calendar date = Calendar.getInstance();
        startDateTxf.setText(date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.YEAR));
    }//GEN-LAST:event_todayBtnActionPerformed

    private void startDateTxfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateTxfActionPerformed
    }//GEN-LAST:event_startDateTxfActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField currentWeightTxf;
    private javax.swing.JComboBox<String> genderCmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField maxCaloriesTxf;
    private javax.swing.JTextField minWaterTxf;
    private javax.swing.JTextField nameTxf;
    private javax.swing.JButton selectClientBtn2;
    private javax.swing.JTextField startDateTxf;
    private javax.swing.JTextField surnameTxf;
    private javax.swing.JButton todayBtn;
    private javax.swing.JTextField weightGoalTxf;
    // End of variables declaration//GEN-END:variables
}
