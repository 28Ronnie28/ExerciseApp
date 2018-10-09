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

public class DaysPerformance extends javax.swing.JFrame {

    DataHandler dh;
    String dayNumber;
    String dayOfWeek;
    String eDate;

    Object exerciseData[][];

    public DaysPerformance(DataHandler cdh) {
        initComponents();

        dh = cdh;

        String[] dates = dh.getDates();
        dayNumber = dates[2];
        dayOfWeek = dates[1];
        eDate = dates[0];

        dateLbl.setText(eDate);
        dayOfWeekLbl.setText(dayOfWeek);
        dayNumberLbl.setText(dayNumber);

        updateTables();

        setLocationRelativeTo(null);

        setBackground();

        setTitle("Exercise App");
        setIconImage(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/IconImage.png")).getImage());

        setWaterCal();
    }

    public void setBackground() {
        JLabel backgroundLbl = new JLabel();
        setLayout(new BorderLayout());
        add(backgroundLbl);
        backgroundLbl.setIcon(new ImageIcon(new ImageIcon(ExerciseAppFrame.class.getResource("/resources/Background.jpg")).getImage().getScaledInstance(1000, 700, java.awt.Image.SCALE_SMOOTH)));
    }

    public void addFood(String Desc, String Portions, String Calories) {
        dh.addFood(Desc, Portions, Calories, dayNumber, dayOfWeek, eDate);
        setWaterCal();
    }

    public void addExercise(String Desc, String Sets, String Reps) {
        dh.addExercise(Desc, Sets, Reps, dayNumber, dayOfWeek, eDate);
        setWaterCal();
    }

    public void setWaterCal() {
        waterLbl.setText(dh.getCurWater(dayNumber) + " ML of " + dh.getMinWater() + " ML");
        calLbl.setText(dh.getCurCal(dayNumber) + " KCAL of " + dh.getMaxCalories() + " KCAL");
    }

    public boolean addNewWeight(String weight) {
        return dh.addNewWeight(weight, dayNumber, dayOfWeek, eDate);
    }

    public void updateTables() {
        updateFoodTable();
        updateExerciseTable();
    }

    public void updateFoodTable() {
        try {
            ResultSet rs = dh.getDaysFoodTableInfo(dayNumber);
            List<String[]> foodDataB = new ArrayList<>();
            try {
                while (rs.next()) {
                    String desc = rs.getString("Description");
                    int port = Integer.parseInt(rs.getString("Portions"));
                    int calo = Integer.parseInt(rs.getString("Calories"));

                    boolean add = false;

                    for (int i = 0; i < foodDataB.size(); i++) {
                        if (foodDataB.get(i)[0] != null && desc.matches(foodDataB.get(i)[0])) {
                            foodDataB.get(i)[1] = Integer.toString(Integer.parseInt(foodDataB.get(i)[1]) + port);
                            foodDataB.get(i)[2] = Integer.toString(Integer.parseInt(foodDataB.get(i)[2]) + calo);
                            add = true;
                        }
                    }
                    if (!add) {
                        String addS[] = {desc, Integer.toString(port), Integer.toString(calo)};
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
            ResultSet rs = dh.getDaysExerciseTableInfo(dayNumber);
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
    
    public Object [][] listToArray(List<String[]> arrayL){
        Object [][] array = new Object [arrayL.size()][3];
        
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        waterLbl = new javax.swing.JLabel();
        calLbl = new javax.swing.JLabel();
        addWaterBtn = new javax.swing.JButton();
        addFoodBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        foodTbl = new javax.swing.JTable();
        addExerciseBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        exerciseTbl = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        dayOfWeekLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dayNumberLbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();

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
        jLabel2.setText("Water Intake for the day :");

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Calorie intake for the day :");

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Exercises for the Day :");

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Food Eaten Today :");

        waterLbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        waterLbl.setForeground(new java.awt.Color(0, 0, 0));
        waterLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        waterLbl.setText("2500 ml of 2500 ml");

        calLbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        calLbl.setForeground(new java.awt.Color(0, 0, 0));
        calLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        calLbl.setText("1200 kCal of 1200 Kcal");

        addWaterBtn.setBackground(new java.awt.Color(0, 0, 0));
        addWaterBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        addWaterBtn.setForeground(new java.awt.Color(0, 0, 0));
        addWaterBtn.setText("Add Water Intake");
        addWaterBtn.setOpaque(false);
        addWaterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWaterBtnActionPerformed(evt);
            }
        });

        addFoodBtn.setBackground(new java.awt.Color(0, 0, 0));
        addFoodBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        addFoodBtn.setForeground(new java.awt.Color(0, 0, 0));
        addFoodBtn.setText("Add Food Eaten");
        addFoodBtn.setOpaque(false);
        addFoodBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFoodBtnActionPerformed(evt);
            }
        });

        foodTbl.setBackground(new java.awt.Color(153, 153, 153));
        foodTbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        foodTbl.setOpaque(false);
        jScrollPane3.setViewportView(foodTbl);

        addExerciseBtn.setBackground(new java.awt.Color(0, 0, 0));
        addExerciseBtn.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        addExerciseBtn.setForeground(new java.awt.Color(0, 0, 0));
        addExerciseBtn.setText("Add Exercise Done");
        addExerciseBtn.setOpaque(false);
        addExerciseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExerciseBtnActionPerformed(evt);
            }
        });

        exerciseTbl.setBackground(new java.awt.Color(153, 153, 153));
        exerciseTbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        exerciseTbl.setModel(new javax.swing.table.DefaultTableModel(
            exerciseData,
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
        if (exerciseTbl.getColumnModel().getColumnCount() > 0) {
            exerciseTbl.getColumnModel().getColumn(0).setResizable(false);
            exerciseTbl.getColumnModel().getColumn(1).setResizable(false);
            exerciseTbl.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel8.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Day of Week:");

        dayOfWeekLbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        dayOfWeekLbl.setForeground(new java.awt.Color(0, 0, 0));
        dayOfWeekLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dayOfWeekLbl.setText("Monday");

        jLabel10.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Day Number:");

        dayNumberLbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        dayNumberLbl.setForeground(new java.awt.Color(0, 0, 0));
        dayNumberLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dayNumberLbl.setText("5");

        jLabel12.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Date:");

        dateLbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(0, 0, 0));
        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dateLbl.setText("28/3/2017");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dayOfWeekLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dayNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addExerciseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(waterLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addWaterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addFoodBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(321, 321, 321))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(303, 303, 303))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayOfWeekLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addWaterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waterLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFoodBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addExerciseBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 976, Short.MAX_VALUE)
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

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        dh.home.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void addWaterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWaterBtnActionPerformed
        String intake = JOptionPane.showInputDialog(this, "Please enter the amount of water you have drink in mililitres. (only enter the number)");
        dh.addWater(intake, dayNumber, dayOfWeek, eDate);
        setWaterCal();
    }//GEN-LAST:event_addWaterBtnActionPerformed

    private void addFoodBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFoodBtnActionPerformed
        this.setVisible(false);
        dh.addFood.setVisible(true);
        setWaterCal();
        updateTables();
    }//GEN-LAST:event_addFoodBtnActionPerformed

    private void addExerciseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExerciseBtnActionPerformed
        this.setVisible(false);
        dh.addExercise.setVisible(true);
    }//GEN-LAST:event_addExerciseBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExerciseBtn;
    private javax.swing.JButton addFoodBtn;
    private javax.swing.JButton addWaterBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel calLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel dayNumberLbl;
    private javax.swing.JLabel dayOfWeekLbl;
    private javax.swing.JTable exerciseTbl;
    private javax.swing.JTable foodTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel waterLbl;
    // End of variables declaration//GEN-END:variables
}
