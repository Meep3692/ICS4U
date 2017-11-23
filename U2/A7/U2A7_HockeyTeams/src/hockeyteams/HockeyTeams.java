/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hockeyteams;

/**
 * GUI and main entry point
 * @author Darian
 */
public class HockeyTeams extends javax.swing.JFrame {

    private TeamTableModel tableModel;
    
    /**
     * Creates new form HockeyTeams
     */
    public HockeyTeams() {
        tableModel = new TeamTableModel();
        tableModel.setGradeFilter(9, true);
        tableModel.setGradeFilter(10, true);
        tableModel.setGradeFilter(11, true);
        tableModel.setGradeFilter(12, true);
        tableModel.setGradeFilter(13, true);
        tableModel.setTeamFilter(Team.Boys, true);
        tableModel.setTeamFilter(Team.Girls, true);
        tableModel.setPositionFilter(Position.D, true);//WORK HERE
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        controlsPanel = new javax.swing.JPanel();
        filtersLabel = new javax.swing.JLabel();
        filterTeamLabel = new javax.swing.JLabel();
        filterTeamGirlsCheckBox = new javax.swing.JCheckBox();
        filterTeamBoysCheckBox = new javax.swing.JCheckBox();
        filterGradeLabel = new javax.swing.JLabel();
        filterGrade9CheckBox = new javax.swing.JCheckBox();
        filterGrade10CheckBox = new javax.swing.JCheckBox();
        filterGrade11CheckBox = new javax.swing.JCheckBox();
        filterGrade12CheckBox = new javax.swing.JCheckBox();
        filterGrade13CheckBox = new javax.swing.JCheckBox();
        filterPositionCheckBox = new javax.swing.JLabel();
        filterPositionFCheckBox = new javax.swing.JCheckBox();
        filterPositionDCheckBox = new javax.swing.JCheckBox();
        filterPositionGCheckBox = new javax.swing.JCheckBox();
        addPlayerButton = new javax.swing.JButton();
        playersTableScrollPane = new javax.swing.JScrollPane();
        playersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controlsPanel.setLayout(new java.awt.GridBagLayout());

        filtersLabel.setText("Sorting");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        controlsPanel.add(filtersLabel, gridBagConstraints);

        filterTeamLabel.setText("Team");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterTeamLabel, gridBagConstraints);

        filterTeamGirlsCheckBox.setText("Girls");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterTeamGirlsCheckBox, gridBagConstraints);

        filterTeamBoysCheckBox.setText("Boys");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterTeamBoysCheckBox, gridBagConstraints);

        filterGradeLabel.setText("Grade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterGradeLabel, gridBagConstraints);

        filterGrade9CheckBox.setText("9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterGrade9CheckBox, gridBagConstraints);

        filterGrade10CheckBox.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterGrade10CheckBox, gridBagConstraints);

        filterGrade11CheckBox.setText("11");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterGrade11CheckBox, gridBagConstraints);

        filterGrade12CheckBox.setText("12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterGrade12CheckBox, gridBagConstraints);

        filterGrade13CheckBox.setText("13");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterGrade13CheckBox, gridBagConstraints);

        filterPositionCheckBox.setText("Position");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterPositionCheckBox, gridBagConstraints);

        filterPositionFCheckBox.setText("F");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterPositionFCheckBox, gridBagConstraints);

        filterPositionDCheckBox.setText("D");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterPositionDCheckBox, gridBagConstraints);

        filterPositionGCheckBox.setText("G");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        controlsPanel.add(filterPositionGCheckBox, gridBagConstraints);

        addPlayerButton.setText("Add Player");
        addPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerButtonActionPerformed(evt);
            }
        });
        controlsPanel.add(addPlayerButton, new java.awt.GridBagConstraints());

        getContentPane().add(controlsPanel, java.awt.BorderLayout.PAGE_START);

        playersTable.setModel(tableModel);
        playersTableScrollPane.setViewportView(playersTable);

        getContentPane().add(playersTableScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerButtonActionPerformed
        HockeyPlayer newPlayer = new AddPlayerDialog(this, true).showDialog();
        tableModel.addPlayer(newPlayer);
    }//GEN-LAST:event_addPlayerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(HockeyTeams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HockeyTeams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HockeyTeams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HockeyTeams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HockeyTeams().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayerButton;
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JCheckBox filterGrade10CheckBox;
    private javax.swing.JCheckBox filterGrade11CheckBox;
    private javax.swing.JCheckBox filterGrade12CheckBox;
    private javax.swing.JCheckBox filterGrade13CheckBox;
    private javax.swing.JCheckBox filterGrade9CheckBox;
    private javax.swing.JLabel filterGradeLabel;
    private javax.swing.JLabel filterPositionCheckBox;
    private javax.swing.JCheckBox filterPositionDCheckBox;
    private javax.swing.JCheckBox filterPositionFCheckBox;
    private javax.swing.JCheckBox filterPositionGCheckBox;
    private javax.swing.JCheckBox filterTeamBoysCheckBox;
    private javax.swing.JCheckBox filterTeamGirlsCheckBox;
    private javax.swing.JLabel filterTeamLabel;
    private javax.swing.JLabel filtersLabel;
    private javax.swing.JTable playersTable;
    private javax.swing.JScrollPane playersTableScrollPane;
    // End of variables declaration//GEN-END:variables
}
