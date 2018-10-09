package exerciseapp;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PicturesFrame extends javax.swing.JFrame {

    DataHandler dh;
    
    public PicturesFrame(DataHandler cdh) {
        dh = cdh;
        
        initComponents();
        
        setLocationRelativeTo(null);
        
        setBackground();
        
        setTitle("Exercise App");
        setIconImage(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/IconImage.png")).getImage());
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
        selectClientBtn3 = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        addPicturesBtn = new javax.swing.JButton();

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
        selectClientBtn2.setText("View Body Pictures");
        selectClientBtn2.setOpaque(false);
        selectClientBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectClientBtn2ActionPerformed(evt);
            }
        });

        selectClientBtn3.setBackground(new java.awt.Color(0, 0, 0));
        selectClientBtn3.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        selectClientBtn3.setForeground(new java.awt.Color(0, 0, 0));
        selectClientBtn3.setText("View Exercise Pictures");
        selectClientBtn3.setOpaque(false);
        selectClientBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectClientBtn3ActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(0, 0, 0));
        backBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        backBtn.setForeground(new java.awt.Color(0, 0, 0));
        backBtn.setText("Back");
        backBtn.setOpaque(false);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        addPicturesBtn.setBackground(new java.awt.Color(0, 0, 0));
        addPicturesBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        addPicturesBtn.setForeground(new java.awt.Color(0, 0, 0));
        addPicturesBtn.setText("Add Pictures");
        addPicturesBtn.setOpaque(false);
        addPicturesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPicturesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 85, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(292, 292, 292))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(selectClientBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(selectClientBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addPicturesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectClientBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectClientBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(addPicturesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        this.setVisible(false);
        dh.bodyPictures.setVisible(true);
    }//GEN-LAST:event_selectClientBtn2ActionPerformed

    private void selectClientBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectClientBtn3ActionPerformed
        this.setVisible(false);
        dh.exercisePictures.setVisible(true);
    }//GEN-LAST:event_selectClientBtn3ActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        dh.home.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void addPicturesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPicturesBtnActionPerformed
        this.setVisible(false);
        dh.addPic.setVisible(true);
    }//GEN-LAST:event_addPicturesBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPicturesBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton selectClientBtn2;
    private javax.swing.JButton selectClientBtn3;
    // End of variables declaration//GEN-END:variables
}
