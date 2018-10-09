package exerciseapp;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExercisePicturesFrame extends javax.swing.JFrame {

    DataHandler dh;
    List<String> pictures;
    int viewing = 0;

    public ExercisePicturesFrame(DataHandler cdh) {
        initComponents();

        setLocationRelativeTo(null);

        dh = cdh;

        setBackground();

        setTitle("Exercise App");
        setIconImage(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/IconImage.png")).getImage());

        List<String> picturesDays = dh.getExercisePicturesDays();
        for (int i = 0; i < picturesDays.size(); i++) {
            dayCmb.addItem(picturesDays.get(i));
        }
        if (!picturesDays.isEmpty()) {
            pictureLbl.setIcon(new ImageIcon(new ImageIcon(pictures.get(0)).getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH)));
        } else {
            nextBtn.setEnabled(false);
            prevBtn.setEnabled(false);
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
        prevBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        dayCmb = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        pictureLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 80)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Exercise");

        prevBtn.setBackground(new java.awt.Color(0, 0, 0));
        prevBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        prevBtn.setForeground(new java.awt.Color(0, 0, 0));
        prevBtn.setText("Previous");
        prevBtn.setOpaque(false);
        prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtnActionPerformed(evt);
            }
        });

        nextBtn.setBackground(new java.awt.Color(0, 0, 0));
        nextBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        nextBtn.setForeground(new java.awt.Color(0, 0, 0));
        nextBtn.setText("Next");
        nextBtn.setOpaque(false);
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
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

        dayCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dayCmbItemStateChanged(evt);
            }
        });
        dayCmb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dayCmbMouseClicked(evt);
            }
        });
        dayCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayCmbActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(prevBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(292, 292, 292))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(dayCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(372, 372, 372))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dayCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prevBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBtnActionPerformed
        viewing--;
        pictureLbl.setIcon(new ImageIcon(new ImageIcon(pictures.get(viewing)).getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH)));
        if (viewing == 0) {
            prevBtn.setEnabled(false);
        }
        if (viewing < pictures.size()) {
            nextBtn.setEnabled(true);
        }
    }//GEN-LAST:event_prevBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        viewing++;
        pictureLbl.setIcon(new ImageIcon(new ImageIcon(pictures.get(viewing)).getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH)));
        if (pictures.size() - 1 == viewing) {
            nextBtn.setEnabled(false);
        }
        if (viewing < pictures.size()) {
            prevBtn.setEnabled(true);
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        dh.pictures.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void dayCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dayCmbItemStateChanged

    }//GEN-LAST:event_dayCmbItemStateChanged

    private void dayCmbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dayCmbMouseClicked

    }//GEN-LAST:event_dayCmbMouseClicked

    private void dayCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayCmbActionPerformed
        pictures = dh.getExercisePicturesForDay((String) dayCmb.getSelectedItem());
        viewing = 0;
        if (pictures.size() > 0) {
            pictureLbl.setIcon(new ImageIcon(new ImageIcon(pictures.get(0)).getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH)));
        }
        if (viewing < pictures.size()) {
            prevBtn.setEnabled(true);
            nextBtn.setEnabled(true);
        }

        if (pictures.size() - 1 == viewing) {
            nextBtn.setEnabled(false);
        }
        if (viewing == 0) {
            prevBtn.setEnabled(false);
        }
    }//GEN-LAST:event_dayCmbActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> dayCmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel pictureLbl;
    private javax.swing.JButton prevBtn;
    // End of variables declaration//GEN-END:variables
}
