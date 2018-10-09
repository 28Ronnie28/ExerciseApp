package exerciseapp;

import java.awt.BorderLayout;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExerciseAppFrame extends javax.swing.JFrame {

    DataHandler dh;
    
    public ExerciseAppFrame(DataHandler cdh) {
        initComponents();
        dh = cdh;
        
        setLocationRelativeTo(null);
        
        setBackground();
        
        setTitle("Exercise App");
        setIconImage(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/IconImage.png")).getImage());
        
        Calendar date = Calendar.getInstance(); 
        dateLbl.setText("Date : "+date.get(Calendar.DAY_OF_MONTH)+"/"+(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.YEAR));
        
        
    }
    
    public void setBackground(){
        JLabel backgroundLbl = new JLabel();
        setLayout(new BorderLayout());
        add(backgroundLbl);
        backgroundLbl.setIcon(new ImageIcon(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/Background.jpg")).getImage().getScaledInstance(1000, 700, java.awt.Image.SCALE_SMOOTH)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tProgresBtn = new javax.swing.JButton();
        dateLbl = new javax.swing.JLabel();
        picturesBtn = new javax.swing.JButton();
        profileBtn = new javax.swing.JButton();
        oProgressBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setOpaque(false);

        tProgresBtn.setBackground(new java.awt.Color(0, 0, 0));
        tProgresBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        tProgresBtn.setForeground(new java.awt.Color(0, 0, 0));
        tProgresBtn.setText("Today's Progress");
        tProgresBtn.setOpaque(false);
        tProgresBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tProgresBtnActionPerformed(evt);
            }
        });

        dateLbl.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(0, 0, 0));
        dateLbl.setText("Date: 28/03/2017");

        picturesBtn.setBackground(new java.awt.Color(0, 0, 0));
        picturesBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        picturesBtn.setForeground(new java.awt.Color(0, 0, 0));
        picturesBtn.setText("Pictures");
        picturesBtn.setOpaque(false);
        picturesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                picturesBtnActionPerformed(evt);
            }
        });

        profileBtn.setBackground(new java.awt.Color(0, 0, 0));
        profileBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        profileBtn.setForeground(new java.awt.Color(0, 0, 0));
        profileBtn.setText("Profile");
        profileBtn.setOpaque(false);
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });

        oProgressBtn.setBackground(new java.awt.Color(0, 0, 0));
        oProgressBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        oProgressBtn.setForeground(new java.awt.Color(0, 0, 0));
        oProgressBtn.setText("OverAll Progress");
        oProgressBtn.setOpaque(false);
        oProgressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oProgressBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 80)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Exercise");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(dateLbl)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(picturesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tProgresBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oProgressBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(311, 311, 311))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(292, 292, 292))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dateLbl)
                .addGap(32, 32, 32)
                .addComponent(oProgressBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(tProgresBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(picturesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(profileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
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

    private void tProgresBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tProgresBtnActionPerformed
        this.setVisible(false);
        dh.today.setVisible(true);
    }//GEN-LAST:event_tProgresBtnActionPerformed

    private void picturesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_picturesBtnActionPerformed
        this.setVisible(false);
        dh.pictures.setVisible(true);
    }//GEN-LAST:event_picturesBtnActionPerformed

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        this.setVisible(false);
        dh.profile.setVisible(true);
    }//GEN-LAST:event_profileBtnActionPerformed

    private void oProgressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oProgressBtnActionPerformed
        this.setVisible(false);
        dh.overall.setVisible(true);
    }//GEN-LAST:event_oProgressBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton oProgressBtn;
    private javax.swing.JButton picturesBtn;
    private javax.swing.JButton profileBtn;
    private javax.swing.JButton tProgresBtn;
    // End of variables declaration//GEN-END:variables
}
