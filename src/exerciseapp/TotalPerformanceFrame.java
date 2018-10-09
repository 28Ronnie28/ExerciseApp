package exerciseapp;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TotalPerformanceFrame extends javax.swing.JFrame {

    DataHandler dh;

    public TotalPerformanceFrame(DataHandler cdh) {
        initComponents();

        setLocationRelativeTo(null);

        dh = cdh;

        updateTables();

        setBackground();

        setTitle("Exercise App");
        setIconImage(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/IconImage.png")).getImage());

        setStats();
    }

    public void setBackground() {
        JLabel backgroundLbl = new JLabel();
        setLayout(new BorderLayout());
        add(backgroundLbl);
        backgroundLbl.setIcon(new ImageIcon(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/Background.jpg")).getImage().getScaledInstance(1000, 700, java.awt.Image.SCALE_SMOOTH)));
    }

    public void setStats() {
        waterLbl.setText(dh.getTotalWater() + " ML");
        calLbl.setText(dh.getTotalCal() + " KCAL");
        awayLbl.setText(dh.getAwayFromGoal() + " KG");
        lostLbl.setText(dh.getWeightLost() + " KG");
    }

    public void updateTables() {
        updateFoodTable();
        updateExerciseTable();
    }

    public void updateFoodTable() {
        try {
            ResultSet rs = dh.getTotalFoodTableInfo();
            List<String[]> foodDataB = new ArrayList<>();
            try {
                while (rs.next()) {
                    String desc = rs.getString("Description");
                    int reps = Integer.parseInt(rs.getString("Portions"));
                    int sets = Integer.parseInt(rs.getString("Calories"));

                    boolean add = false;

                    for (int i = 0; i < foodDataB.size(); i++) {
                        if (foodDataB.get(i)[0] != null && desc.matches(foodDataB.get(i)[0])) {
                            foodDataB.get(i)[2] = Integer.toString(Integer.parseInt(foodDataB.get(i)[2]) + sets);
                            foodDataB.get(i)[1] = Integer.toString((Integer.parseInt(foodDataB.get(i)[1]) + reps));
                            add = true;
                        }
                    }
                    if (!add) {
                        String addS[] = {desc, Integer.toString(reps), Integer.toString(sets)};
                        foodDataB.add(addS);
                    }
                }

                foodTbl.setModel(new DefaultTableModel(listToArray(foodDataB), new Object[]{"Description", "Portions", "Total Calories"}));

            } catch (SQLException ex) {
                Logger.getLogger(DaysPerformance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException ex) {
            System.out.println("null");
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateExerciseTable() {
        try {
            ResultSet rs = dh.getTotalExerciseTableInfo();
            List<String[]> exerciseDataB = new ArrayList<>();
            try {
                while (rs.next()) {
                    String desc = rs.getString("Description");
                    double reps = Double.parseDouble(rs.getString("RepsPerSetDistance"));
                    int sets = Integer.parseInt(rs.getString("Sets"));

                    boolean add = false;

                    for (int i = 0; i < exerciseDataB.size(); i++) {
                        if (exerciseDataB.get(i)[0] != null && desc.matches(exerciseDataB.get(i)[0])) {
                            exerciseDataB.get(i)[2] = Integer.toString(Integer.parseInt(exerciseDataB.get(i)[2]) + sets);
                            exerciseDataB.get(i)[1] = Double.toString((Double.parseDouble(exerciseDataB.get(i)[1]) + reps));
                            add = true;
                        }
                    }
                    if (!add) {
                        String addS[] = {desc, Double.toString(reps), Integer.toString(sets)};
                        exerciseDataB.add(addS);
                    }
                }

                exerciseTbl.setModel(new DefaultTableModel(listToArray(exerciseDataB), new Object[]{"Description", "Total Reps Or Total Distance (km)", "Sets"}));

            } catch (SQLException ex) {
                Logger.getLogger(DaysPerformance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException ex) {
            System.out.println("null");
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object[][] listToArray(List<String[]> arrayL) {
        Object[][] array = new Object[arrayL.size()][3];

        for (int i = 0; i < arrayL.size(); i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = arrayL.get(i)[j];
            }
        }

        return array;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        waterLbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        foodTbl = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        exerciseTbl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        calLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        awayLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lostLbl = new javax.swing.JLabel();
        newWeightBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 80)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Exercise");

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

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Water Intake :");

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Exercises Done :");

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Food Eaten :");

        waterLbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        waterLbl.setForeground(new java.awt.Color(0, 0, 0));
        waterLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        waterLbl.setText("2500 ml ");

        foodTbl.setBackground(new java.awt.Color(153, 153, 153));
        foodTbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        foodTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Portions", "Total kcal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        foodTbl.setOpaque(false);
        jScrollPane3.setViewportView(foodTbl);

        exerciseTbl.setBackground(new java.awt.Color(153, 153, 153));
        exerciseTbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        exerciseTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Sets", "Reps Per Set Or Distance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        exerciseTbl.setOpaque(false);
        jScrollPane4.setViewportView(exerciseTbl);

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Calorie Intake :");

        calLbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        calLbl.setForeground(new java.awt.Color(0, 0, 0));
        calLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        calLbl.setText("1200 KCal");

        jLabel8.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("KG away From Goal :");

        awayLbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        awayLbl.setForeground(new java.awt.Color(0, 0, 0));
        awayLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        awayLbl.setText("9 KG");

        jLabel10.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("KG Lost :");

        lostLbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        lostLbl.setForeground(new java.awt.Color(0, 0, 0));
        lostLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lostLbl.setText("0 KG");

        newWeightBtn.setBackground(new java.awt.Color(0, 0, 0));
        newWeightBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        newWeightBtn.setForeground(new java.awt.Color(0, 0, 0));
        newWeightBtn.setText("New Weight");
        newWeightBtn.setOpaque(false);
        newWeightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWeightBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(343, 343, 343))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(324, 324, 324))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 181, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(292, 292, 292))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(waterLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(calLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lostLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(awayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newWeightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(awayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newWeightBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lostLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waterLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        dh.home.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void newWeightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newWeightBtnActionPerformed
        dh.today.addNewWeight(JOptionPane.showInputDialog(this, "New Weight?"));
        setStats();
    }//GEN-LAST:event_newWeightBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel awayLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel calLbl;
    private javax.swing.JTable exerciseTbl;
    private javax.swing.JTable foodTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lostLbl;
    private javax.swing.JButton newWeightBtn;
    private javax.swing.JLabel waterLbl;
    // End of variables declaration//GEN-END:variables
}
